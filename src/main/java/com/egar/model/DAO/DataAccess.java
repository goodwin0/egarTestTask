package com.egar.model.DAO;

import com.egar.model.entity.*;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Class provides access to the database.
 * Has got methods to insert, update, delete entities:
 * @see EntityDB
 * and methods to select all entities.
 */
public class DataAccess {

    /**
     * Connects to DB and returns list of orders
     */
    public static List<Order> selectAllOrders(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Order> criteria = builder.createQuery(Order.class);
        Root<Order> root = criteria.from(Order.class);
        criteria.select(root);

        List<Order> orders = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        session.close();
        return orders;
    }


    /**
     * Connects to DB and returns list of only articles,
     * which order's id apply to selected.
     */
    public static List <Article> selectArticlesForOrder(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();

//        EntityManager em =  session.getEntityManagerFactory().createEntityManager();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        Metamodel m = em.getMetamodel();
//        EntityType<Article> Article_ = m.entity(Article.class);

        CriteriaQuery<Article> cq = cb.createQuery(Article.class);
        Root<Article> p = cq.from(Article.class);
        cq.where(cb.equal(p.get("order"),order.getId()));

        List<Article> result = session.createQuery(cq).getResultList();

        return result;
    }


    /**
     * Connects to DB and returns list of orders.
     */
    public static List<Article> selectAllArticles(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Article> criteria = builder.createQuery(Article.class);
        Root<Article> root = criteria.from(Article.class);
        criteria.select(root);

        List<Article> articles = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        session.close();
        return articles;
    }

    /**
     * Inserts new entity to DB.
     */
    public static void insert(EntityDB entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Updates exiting entity in DB.
     */
    public static void update(EntityDB entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        EntityDB upE = session.get(entity.getClass(), entity.getId());
        upE.update(entity);
        session.update(upE);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Deletes entity.
     * Deletes only entities, that have no refers!
     */
    public static void delete(EntityDB entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        EntityDB delE = session.get(entity.getClass(), entity.getId());
        session.delete(delE);
        session.getTransaction().commit();
        session.close();
    }

}
