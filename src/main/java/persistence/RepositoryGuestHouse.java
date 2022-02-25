package persistence;

import model.Customer;
import model.GuestHouse;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryGuestHouse {

    private EntityManager em;

    public RepositoryGuestHouse() {
        em = DBUtil.getEntityManager();
    }

    public List<GuestHouse> showGuestHouseTable() {
        String sql = "SELECT address, name, phoneNumber" +
                " FROM GuestHouse";

        return em.createQuery(sql, GuestHouse.class).getResultList();
    }
}
