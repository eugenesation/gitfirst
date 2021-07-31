package ua.com.nix.model.dto;

import java.math.BigDecimal;

public class AccountDTO {

    private long accountNumber;
    private BigDecimal balance;

    public  AccountDTO(){}
    public AccountDTO(long accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
