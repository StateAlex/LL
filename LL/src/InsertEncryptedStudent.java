import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class InsertEncryptedStudent 
{
	
	public static void main(String[] args)
	{
		/*Configuration configuration = new Configuration();
		configuration.configure("DBconnection.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		Session s= sessionFactory.openSession();
		org.hibernate.Transaction tx= s.beginTransaction();*/
		EncryptedStudent Estudent=new EncryptedStudent();
		Estudent.initStudent(50,3,0);
		Estudent.encryptedPointMethod();
		/*s.save(Estudent);
		s.flush();
		tx.commit();
		s.close();*/
	}
	
}
