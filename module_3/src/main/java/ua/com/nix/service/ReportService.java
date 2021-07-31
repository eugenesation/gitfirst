package ua.com.nix.service;

import com.opencsv.CSVWriter;
import ua.com.nix.dao.ReportDao;
import ua.com.nix.model.dto.AccountDTO;
import ua.com.nix.model.dto.ReportDTO;
import ua.com.nix.model.entity.Category;
import ua.com.nix.model.entity.TransferResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private final ReportDao reportDao;

    public ReportService(ReportDao reportDao){
        this.reportDao = reportDao;
    }


    public void generateReport(long number, Instant startDate, Instant endDate) throws SQLException, IOException {
        List<ReportDTO> operations = reportDao.findAllOperationsByAccountNumber(number,startDate, endDate);
        BigDecimal income = calculateIncome(operations);
        BigDecimal saldo = calculateSaldo(income, operations);
        generateCSV(convert(operations), income, saldo);
    }

    public List<AccountDTO> getAccounts(String email) throws SQLException {
        long id = reportDao.getUserIdByEmail(email);
        return reportDao.findAccountByUserId(id);
    }


    private BigDecimal calculateIncome(List<ReportDTO> operations){
        BigDecimal income = new BigDecimal(0);
        for (ReportDTO operation : operations) {
            if(operation.getStatus().equals(TransferResult.Status.ACCEPTED.name())){
                if(operation.getCategoryType().equals(Category.Type.INCOME.name()))
                    income = income.add(operation.getTransferAmount());
            }
        }
        return income;
    }

    private BigDecimal calculateSaldo(BigDecimal income, List<ReportDTO> operations){
        BigDecimal expense = new BigDecimal(0);
        for (ReportDTO operation : operations) {
            if(operation.getStatus().equals(TransferResult.Status.ACCEPTED.name())){
                if(operation.getCategoryType().equals(Category.Type.EXPENSE.name()))
                    expense = expense.add(operation.getTransferAmount());
            }
        }
        return income.subtract(expense);
    }

    private void generateCSV(List<String[]> operations, BigDecimal income, BigDecimal saldo) throws IOException{
        File file = new File("module_3/report.csv");
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeAll(operations);
            writer.writeNext(new String[]{"Income: ", String.valueOf(income)});
            writer.writeNext(new String[]{"Saldo: ", String.valueOf(saldo)});

        } catch (IOException e) {
            throw new IOException(e.getMessage() + "Failed to export CSV");
        }
    }


    private List<String[]> convert(List<ReportDTO> operations){
        List<String[]> converted = new ArrayList<>();
        String[] header = {"account_number", "transfer_amount", "category", "type", "issued_at", "status", "reason"};
        converted.add(header);
        for (ReportDTO operation: operations) {
            String[] a = new String[7];
            a[0] = String.valueOf(operation.getAccountNumber());
            a[1] = String.valueOf(operation.getTransferAmount());
            a[2] = operation.getCategoryName();
            a[3] = operation.getCategoryType();
            a[4] = operation.getIssuedAt().toString();
            a[5] = operation.getStatus();
            a[6] = operation.getReason();
            converted.add(a);
        }
        return converted;
    }

}
