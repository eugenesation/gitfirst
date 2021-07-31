package ua.com.nix.dao;

import ua.com.nix.model.dto.AccountDTO;
import ua.com.nix.model.entity.Account;
import ua.com.nix.model.entity.Category;
import ua.com.nix.model.entity.Operation;

import java.sql.SQLException;
import java.util.List;

public interface OperationDao {

    long getUserIdByEmail(String email) throws Exception;

    void createOperation(Operation operation) throws SQLException;

    List<Category> findAllCategories() throws SQLException;

    Account findAccountByNumber(long number) throws SQLException;

    List<AccountDTO> findAccountByUserId(long id) throws SQLException;

}
