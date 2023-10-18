
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private HibernateSessionFactoryUtil() {}
    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
             sessionFactory = configuration.buildSessionFactory();
        }
        catch (Exception e){
            System.out.println("Исключение!" + e);
        }
        return sessionFactory;
    }
}
