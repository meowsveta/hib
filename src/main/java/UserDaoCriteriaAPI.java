import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class UserDaoCriteriaAPI {

    public void update(User user) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<User> criteriaUpdate = builder.createCriteriaUpdate(User.class);
        Root<User> root = criteriaUpdate.from(User.class);
        criteriaUpdate.set("name", user.getName());
        criteriaUpdate.set("city", user.getCity());
        criteriaUpdate.set("age", user.getCountry());
        criteriaUpdate.set("country", user.getCountry());
        criteriaUpdate.where(builder.equal(root.get("id"), user.getId()));
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    public void deleteById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<User> criteriaDelete = cb.createCriteriaDelete(User.class);
        Root<User> userRoot = criteriaDelete.from(User.class);
        criteriaDelete.where(cb.equal(userRoot.get("id"), id));
        em.getTransaction().begin();
        int rowsDeleted = em.createQuery(criteriaDelete).executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        em.getTransaction().commit();
    }
    public List<User> findAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        CriteriaQuery <User> select = cq.select(userRoot);
        TypedQuery<User> query = em.createQuery(select);
        List<User> allUser = query.getResultList();
        return allUser;
    }

    public List<User> findAllPagingAndFilter (int firstResult, int maxResult, String filter1, String filter2) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        CriteriaQuery <User> select = cq.select(userRoot);
        TypedQuery<User> query = em.createQuery(select);
        cq.where(cb.equal(userRoot.get(filter1), filter2));
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        List<User> allUser = query.getResultList();
        return allUser;
    }

    public List findById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> userRoot = cq.from(User.class);
        cq.where(cb.equal(userRoot.get("id"), id));
        CriteriaQuery <User> select = cq.select(userRoot);
        TypedQuery<User> query = em.createQuery(select);
        List<User> allUser = query.getResultList();
        return allUser;
    }

    public void add(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

}
