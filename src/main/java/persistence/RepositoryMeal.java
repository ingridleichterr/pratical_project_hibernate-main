package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryMeal {
    private EntityManager em;

    public RepositoryMeal() {
        em = DBUtil.getEntityManager();
    }
}
