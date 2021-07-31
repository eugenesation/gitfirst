package ua.com.nix.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "number", nullable = false, unique = true)
    private Long accountNumber;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "created", nullable = false)
    private Instant created;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Operation> operationSet;

    @PrePersist
    public void onCreate() {
        if (created == null) {
            created = Instant.now();
        }
    }

    public Account(){

    }

    public Account(User user, BigDecimal balance, Instant created) {
        this.user = user;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Set<Operation> getOperationSet() {
        return operationSet;
    }

    public void setOperationSet(Set<Operation> operationSet) {
        this.operationSet = operationSet;
    }

}
