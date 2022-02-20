package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryPaymentMethod {

    private EntityManager em;

    public RepositoryPaymentMethod() {
        em = DBUtil.getEntityManager();
    }
}
