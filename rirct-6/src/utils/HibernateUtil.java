
package utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/** Default session factory */
	private static SessionFactory sessionFactory; 

	/**
	 * Get default session factory.
	 */
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory () {
		if(sessionFactory==null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	/**
	 * @see SessionFactory#openSession()
	 */
	public static Session openSession() {
		return getSessionFactory().openSession();
	}

	/**
	 * @see SessionFactory#getCurrentSession()
	 */
	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
}