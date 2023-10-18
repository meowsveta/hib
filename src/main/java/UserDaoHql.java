import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHql {

    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void add(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }


    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("update User set name = :nameParam, age = :ageParam" +
                ", city = :cityParam ," +
                "country = :countryParam" +
                " where id = :idParam");
        query.setParameter("nameParam", user.getName());
        query.setParameter("ageParam", user.getAge() );
        query.setParameter("cityParam", user.getCity());
        query.setParameter("countryParam", user.getCountry());
        query.setParameter("idParam", user.getId());
        tx1.commit();
        session.close();
    }

    public void deleteById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("delete  User where id = :idParam");
        query.setParameter("idParam", id);
        session.delete(session.get(User.class, id));
        tx1.commit();
    }


    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("delete  User where name = ':nameParam' and age = :ageParam" +
                "and city = ':cityParam' and" +
                "country = ':countryParam'");
        query.setParameter("nameParam", user.getName());
        query.setParameter("ageParam", user.getAge() );
        query.setParameter("cityParam", user.getCity());
        query.setParameter("countryParam", user.getCountry());
       // query.setParameter("idParam", user.getId());
        tx1.commit();
        session.close();
    }

    public List<User> findAll() {
        //List<User> users = null;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> users= query.list();
        tx1.commit();
        session.close();
        return users;
    }

    public List<User> findAllFilter(String filter1, String filter2, int firstResult, int maxResult) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From User where " + filter1 + " = '" + filter2 +"'");
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        List<User> users = query.list();
        return users;
    }
}
