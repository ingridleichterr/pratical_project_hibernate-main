package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryMealType {

    private EntityManager em;

    public RepositoryMealType() {
        em = DBUtil.getEntityManager();
    }
}
