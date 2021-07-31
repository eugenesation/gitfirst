package ua.com.nix.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    public enum Type{
        INCOME, EXPENSE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

    @ManyToMany(mappedBy = "categories")
    private Set<Operation> operationSet = new HashSet<>();

    public Category(){
    }

    public Category(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Operation> getOperationSet() {
        return operationSet;
    }

    public void setOperationSet(Set<Operation> operationSet) {
        this.operationSet = operationSet;
    }

}
