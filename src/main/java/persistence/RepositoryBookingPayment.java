package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryBookingPayment {

    private EntityManager em;

    public RepositoryBookingPayment() {
        em = DBUtil.getEntityManager();
    }
}
