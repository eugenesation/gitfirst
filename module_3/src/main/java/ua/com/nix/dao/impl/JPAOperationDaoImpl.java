package ua.com.nix.dao.impl;

import org.hibernate.Session;
import ua.com.nix.dao.OperationDao;
import ua.com.nix.model.dto.AccountDTO;
import ua.com.nix.model.entity.*;

import java.math.BigDecimal;
import java.util.List;

public class JPAOperationDaoImpl implements OperationDao {

    private final Session session;

    public JPAOperationDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<Category> findAllCategories() {
        try {
            session.beginTransaction();

            List<Category> categories = session.createQuery("from Category", Category.class).list();

            session.getTransaction().commit();
            return categories;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void createOperation(Operation operation) {
        try {
            session.beginTransaction();
            session.persist(operation);

            if(operation.getResult().getStatus().equals(TransferResult.Status.ACCEPTED)){
                BigDecimal balanceUpdated = operation.getAccount().getBalance().add(operation.getTransferAmount());
                operation.getAccount().setBalance(balanceUpdated);
            }
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Account findAccountByNumber(long number) {
        try {
            session.beginTransaction();
            Boolean checkIfExists = session.createQuery(" select (count(a) > 0) as exists " +
                    "from Account a where a.accountNumber = :number", Boolean.class)
                    .setParameter("number", number).getSingleResult();
            if(!checkIfExists){
                session.getTransaction().rollback();
                throw new RuntimeException("Account not found, number: " + number);
            }

            Account account = session.createQuery("from Account a " +
                    "where a.accountNumber = :number", Account.class)
                    .setParameter("number", number)
                    .getSingleResult();

            session.getTransaction().commit();
            return account;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<AccountDTO> findAccountByUserId(long id) {
        try {
            session.beginTransaction();
            Boolean checkIfExists = session.createQuery(" select (count(a) > 0) as exists " +
                    "from Account a where a.user.id = :id", Boolean.class)
                    .setParameter("id", id).getSingleResult();
            if(!checkIfExists){
                session.getTransaction().rollback();
                throw new RuntimeException("Accounts not found for user with id: " + id);
            }
            List<AccountDTO> accountDTO = session.createQuery("" +
                    "select new ua.com.nix.model.dto.AccountDTO(" +
                    "a.accountNumber, a.balance)" +
                    " from Account a where a.user.id= :id", AccountDTO.class)
                    .setParameter("id", id).list();

            session.getTransaction().commit();
            return accountDTO;
        }catch (Exception e){
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public long getUserIdByEmail(String email) throws Exception {
        try {
            session.beginTransaction();
            Boolean checkIfExists = session.createQuery(" select (count(a) > 0) as exists " +
                    "from User a where a.email = :email", Boolean.class)
                    .setParameter("email", email).getSingleResult();
            if(!checkIfExists){
                session.getTransaction().rollback();
                throw new Exception("User not found with email: " + email);
            }
            User user = session.createQuery("from User u where u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();

            session.getTransaction().commit();
            return user.getId();
        }catch (Exception e){
            session.getTransaction().rollback();
            throw e;
        }
    }
}
