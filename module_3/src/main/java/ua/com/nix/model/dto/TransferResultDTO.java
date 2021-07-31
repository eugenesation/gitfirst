package ua.com.nix.model.dto;

import ua.com.nix.model.entity.TransferResult;

public class TransferResultDTO {

    private TransferResult.Status status;
    private String reason;

    public TransferResultDTO(TransferResult.Status status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public TransferResult.Status getStatus() {
        return status;
    }

    public void setStatus(TransferResult.Status status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "TransferResultDTO{" +
                "status=" + status +
                ", reason='" + reason + '\'' +
                '}';
    }

}
