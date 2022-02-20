package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryGuestHouse {

    private EntityManager em;

    public RepositoryGuestHouse() {
        em = DBUtil.getEntityManager();
    }
}
