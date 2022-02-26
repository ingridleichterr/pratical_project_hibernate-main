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

    @SuppressWarnings("unchecked")
    public List<Customer> listAllCustomers() {
        return em.createQuery("Select f from Customer as f order by f.firstName asc")
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









}
