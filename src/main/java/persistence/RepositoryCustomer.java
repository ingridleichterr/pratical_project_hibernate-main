package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import model.customer;
import util.DBUtil;

public class RepositoryCustomer {

    private EntityManager em;

    public RepositoryCustomer() {
        em = DBUtil.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<customer> listAllCustomers() {
        return em.createQuery("Select f from Customer as f order by f.firstName asc")
                .getResultList();
    }


}
