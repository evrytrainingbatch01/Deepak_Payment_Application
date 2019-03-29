package com.uitl;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
private static final SessionFactory factory;
    
    static {
        try {
        	StandardServiceRegistry sr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
    		
          factory=meta.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return factory;
    }
	
}
