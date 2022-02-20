package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryRoom {
    private EntityManager em;

    public RepositoryRoom() {
        em = DBUtil.getEntityManager();
    }
}
