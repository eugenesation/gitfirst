package ua.com.nix.service;

import ua.com.nix.dao.OperationDao;
import ua.com.nix.model.dto.AccountDTO;
import ua.com.nix.model.dto.OperationDTO;
import ua.com.nix.model.dto.TransferResultDTO;
import ua.com.nix.model.entity.Account;
import ua.com.nix.model.entity.Category;
import ua.com.nix.model.entity.Operation;
import ua.com.nix.model.entity.TransferResult;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OperationService {

    private final OperationDao operationDao;

    public OperationService(OperationDao operationDao) {
        this.operationDao = operationDao;
    }


    public TransferResultDTO makeTransfer(OperationDTO operationDto) throws SQLException {

        Account account = operationDao.findAccountByNumber(operationDto.getAccountNumber());
        Operation operation = new Operation(account, operationDto.getTransferAmount());

        TransferResult transferResult;
        if (operationDto.getTransferAmount().longValue() == 0) {
            transferResult = new TransferResult(TransferResult.Status.REJECTED,
                    "Invalid transfer amount. Cannot transfer zero units");
        } else if (account.getBalance().add(operationDto.getTransferAmount()).longValue() <0){
            transferResult = new TransferResult(TransferResult.Status.REJECTED, "Insufficient funds");
        }else {
            Category.Type type;
            if(operationDto.getTransferAmount().longValue() > 0 ) type = Category.Type.INCOME;
            else type = Category.Type.EXPENSE;

            try {
                List<Category> categories = operationDao.findAllCategories();
                Set<Category> categorySet = new HashSet<>();
                for (String categoryName: operationDto.getCategory()){
                    categorySet.add(categories.stream()
                            .filter(category -> category.getName().equals(categoryName) && category.getType().equals(type))
                            .findFirst()
                            .orElseThrow(RuntimeException::new));
                }
                operation.setCategories(categorySet);
                transferResult = new TransferResult(TransferResult.Status.ACCEPTED, "");
            }catch (RuntimeException e){
                transferResult = new TransferResult(TransferResult.Status.REJECTED,
                        "Invalid category for operation type " + type);
            }
        }

        operation.setResult(transferResult);
        operationDao.createOperation(operation);

        return new TransferResultDTO(operation.getResult().getStatus(), operation.getResult().getReason());



    }

    public List<AccountDTO> getAccounts(String email) throws Exception {
        long id = operationDao.getUserIdByEmail(email);
        return operationDao.findAccountByUserId(id);
    }


}
