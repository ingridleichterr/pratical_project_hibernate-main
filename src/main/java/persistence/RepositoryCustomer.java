package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import model.Customer;
import util.DBUtil;

public class RepositoryCustomer {

    private EntityManager em;

    public RepositoryCustomer() {
        em = DBUtil.getEntityManager();
    }

    //method list all cusomers
    @SuppressWarnings("unchecked")
    public List<Customer> listAllCustomers() {
        return em.createQuery("Select n from Customer as n order by n.name asc")
                .getResultList();
    }

    //method save customer
    public void saveCustomer(Customer customer){
        try {
            em.getTransaction().begin();
            this.em.persist(customer);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    //method count total customers
    public long countCustomers(){
        String sql = "SELECT count(customerId) FROM Customer";
        return (long)em.createQuery(sql).getSingleResult();
    }








}
