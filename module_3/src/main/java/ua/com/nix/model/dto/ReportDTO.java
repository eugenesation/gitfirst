package ua.com.nix.model.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class ReportDTO {

    private long accountNumber;
    private BigDecimal transferAmount;
    private String categoryName;
    private String categoryType;
    private Instant issuedAt;
    private String status;
    private String reason;

    public ReportDTO(){}

    public ReportDTO(long accountNumber, BigDecimal transferAmount, String categoryName, String categoryType,
                     Instant issuedAt, String status, String reason) {
        this.accountNumber = accountNumber;
        this.transferAmount = transferAmount;
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.issuedAt = issuedAt;
        this.status = status;
        this.reason = reason;
    }

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Instant issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "accountNumber=" + accountNumber +
                ", transferAmount=" + transferAmount +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType='" + categoryType + '\'' +
                ", issuedAt=" + issuedAt +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

}
