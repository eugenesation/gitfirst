package ua.com.nix.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class OperationDTO {

    private long accountNumber;
    private BigDecimal transferAmount;
    private List<String> category;

    public OperationDTO(long accountNumber, BigDecimal transferAmount, List<String> category) {
        this.accountNumber = accountNumber;
        this.transferAmount = transferAmount;
        this.category = category;
    }

    public OperationDTO(){}

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

}
