package ua.com.nix.dao;

import ua.com.nix.model.dto.AccountDTO;
import ua.com.nix.model.dto.ReportDTO;
import ua.com.nix.model.entity.Account;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

public interface ReportDao {

    List<ReportDTO> findAllOperationsByAccountNumber(long number, Instant start, Instant end) throws SQLException;

    long getUserIdByEmail(String email) throws SQLException;

    Account findAccountByNumber(long number) throws SQLException;

    List<AccountDTO> findAccountByUserId(long id) throws SQLException;

}
