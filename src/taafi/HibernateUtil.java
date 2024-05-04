/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taafi;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author albat
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // loads configuration and mappings
        Configuration configuration = new Configuration().configure("/taafi/hibernate.cfg.xml");
        ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(medicine.class);
        configuration.addAnnotatedClass(mymedicine.class);
        // builds a session factory from the service registry
        sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

