package ua.com.nix.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class TransferResult {

    public enum Status {
        ACCEPTED, REJECTED
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private String reason;

    public TransferResult(Status status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public TransferResult(){
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
