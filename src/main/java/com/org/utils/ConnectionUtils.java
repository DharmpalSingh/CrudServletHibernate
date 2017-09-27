package com.org.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionUtils {

	private static SessionFactory sessionFactory;
	
public static SessionFactory getSessionFactorys()
{
	Configuration configuration = new Configuration();
	configuration.configure("hibernate.cfg.xml");
    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
            configuration.getProperties()). buildServiceRegistry();
     sessionFactory = configuration.buildSessionFactory(serviceRegistry);
     return sessionFactory;
	
}

}
