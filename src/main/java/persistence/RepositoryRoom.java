package persistence;

import model.Customer;
import model.Room;
import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryRoom {
    private EntityManager em;

    public RepositoryRoom() {
        em = DBUtil.getEntityManager();
    }

    //method save new room
    public void saveRoom(Room room){
        try {
            em.getTransaction().begin();
            this.em.persist(room);
            em.getTransaction().commit();

        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

}
