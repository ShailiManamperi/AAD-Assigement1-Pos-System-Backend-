package lk.ijse.gdse63.shaili.assignment1.Util;


import lk.ijse.gdse63.shaili.assignment1.Entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;


    private FactoryConfiguration() {
        //Injecting the properties from the property file.
        Configuration configuration = new Configuration().addProperties(PropertyInjector.injectProperties()).addAnnotatedClass(Item.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;


    }

    public Session getSession() {

        return sessionFactory.openSession();

    }
}
