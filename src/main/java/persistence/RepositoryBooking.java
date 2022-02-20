package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryBooking {

    private EntityManager em;

    public RepositoryBooking() {
        em = DBUtil.getEntityManager();
    }

}
