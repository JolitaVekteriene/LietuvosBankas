package lt.codeacademy.provider;

import lt.codeacademy.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.Environment.*;
import java.util.Properties;

public class SessionFactoryProvider {

    private static SessionFactoryProvider instance;
    private SessionFactory sessionFactory;

    private SessionFactoryProvider() {

        Configuration configuration = new Configuration();
        configuration.setProperties(createHibernateProperties());

        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryProvider getInstance() {
        if (instance == null) {
            instance = new SessionFactoryProvider();
        }

        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Properties createHibernateProperties(){
        Properties p = new Properties();

        p.put(DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        p.put(DRIVER,"org.postgresql.Driver");
        p.put(URL,"jdbc:postgresql://localhost/hibernate");
        p.put(USER,"postgres");
        p.put(PASS,"123");
        p.put(SHOW_SQL,"true");
        p.put(HBM2DDL_AUTO, "create-drop");

        return p;
    }
}
