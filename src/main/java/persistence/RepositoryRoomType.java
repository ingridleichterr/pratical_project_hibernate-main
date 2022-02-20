package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryRoomType {

    private EntityManager em;

    public RepositoryRoomType() {
        em = DBUtil.getEntityManager();
    }
}
