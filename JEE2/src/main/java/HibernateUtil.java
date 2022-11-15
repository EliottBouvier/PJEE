import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Initial SessionFactoryCreation failed. " + e);
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
