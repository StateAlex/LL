import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class InsertStudent 
{

	public static void main(String[] args)
	{
		Configuration configuration = new Configuration();
		configuration.configure("DBconnection.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		Session s= sessionFactory.openSession();
		org.hibernate.Transaction tx= s.beginTransaction();
		Student student= new Student();
		student.setId(2);
		student.setAn(3);
		student.setNume("Hanu");
		student.setPrenume("Theodor");
		student.setNrMatricol("31093104SL120272");
		s.save(student);
		s.flush();
		tx.commit();
		s.close();
	}
}