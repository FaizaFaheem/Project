
package utils;
import java.util.List;

import org.hibernate.Session;

public class DataAccessUtil {
	
	public static void save(Object transientObject) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.save(transientObject);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Object transientObject) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.update(transientObject);
		//session.save(transientObject);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public static void delete(Object transientObject) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.delete(transientObject);
		session.getTransaction().commit();
		session.close();
	}
	
	public static <T> List<T> getAll(Class<T> persistentClass) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> list = session.createQuery( "from " + persistentClass.getName() ).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public static <T> T getById(Class<T> persistentClass, Long id) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		T instance = (T)session.createQuery( "from " + persistentClass.getName() +" where id=:id").setLong("id", id) .uniqueResult();
		session.getTransaction().commit();
		session.close();
		return instance;
	}
	
	public static <T> T getByPhone(Class<T> persistentClass, String phone) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		T instance = (T)session.createQuery( "from " + persistentClass.getName() +" where phone=:phone").setString("phone", phone) .uniqueResult();
		session.getTransaction().commit();
		session.close();
		return instance;
	}
	
	public static <T> T getByName(Class<T> persistentClass, String name) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		T instance = (T)session.createQuery( "from " + persistentClass.getName() +" where name=:name").setString("name", name) .uniqueResult();
		session.getTransaction().commit();
		session.close();
		return instance;
	}
	
	public static <T> T getByUname(Class<T> persistentClass, String username) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		T instance = (T)session.createQuery( "from " + persistentClass.getName() +" where username=:username").setString("username", username) .uniqueResult();
		session.getTransaction().commit();
		session.close();
		return instance;
	}
}