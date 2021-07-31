package ua.com.nix.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "amount", nullable = false)
    private BigDecimal transferAmount;

    @Column(name = "issued_at", nullable = false)
    private Instant issuedAt;

    @Embedded
    private TransferResult result;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "operation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<Category> categories = new HashSet<>();


    @PrePersist
    public void onCreate() {
        if (issuedAt == null) {
            issuedAt = Instant.now();
        }
    }

    public Operation(){
    }

    public Operation(Account account, BigDecimal transferAmount) {
        this.account = account;
        this.transferAmount = transferAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Instant issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public TransferResult getResult() {
        return result;
    }

    public void setResult(TransferResult result) {
        this.result = result;
    }

}
