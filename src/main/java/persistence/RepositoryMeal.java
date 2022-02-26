package persistence;

import model.Customer;
import model.Meal;
import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryMeal {
    private EntityManager em;

    public RepositoryMeal() {
        em = DBUtil.getEntityManager();
    }

    //method save meal
    public void saveMeal(Meal meal){
        try {
            em.getTransaction().begin();
            this.em.persist(meal);
            em.getTransaction().commit();

        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    //method to find meal By mealId
    public Meal findMealById (int mealId){

        return em.find(Meal.class, mealId);
    }

    //method to update meal price by meal id
    public void updateMealPrice (double newPrice, int mealId){
        em.getTransaction().begin();
        String sql = "UPDATE Meal SET price = :nPrice" +
                " WHERE mealId = :id";

        int result = this.em.createQuery(sql)
                .setParameter("nPrice", newPrice)
                .setParameter("id", mealId)
                .executeUpdate();
        em.getTransaction().commit();

    }

}
