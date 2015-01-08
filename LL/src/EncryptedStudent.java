import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class EncryptedStudent 
{
	protected int[][] _Key=
			{
				{ 1,2,3,4,1,2,1 },
				{ 5,6,7,8,5,6,2 },
				{ 4,3,2,1,4,3,3 },
				{ 8,7,6,5,8,7,4 },
				{ 6,5,4,3,2,1,5 },
				{ 1,3,5,7,8,6,6 },
				{ 2,4,6,8,1,3,7 }
			};
		
	static Student student= new Student();
	
	double param1=student.id * student.id;
	double param2=student.an * student.an;
	double param3=student.restante * student.restante;
	double param4=Integer.parseInt(student.nume) * Integer.parseInt(student.nume);
	double param5=Integer.parseInt(student.prenume) * Integer.parseInt(student.prenume);
	double param6=Integer.parseInt(student.nrMatricol) * Integer.parseInt(student.nrMatricol);
	
	protected static void initStudent()
	{
		student.setId(3);
		student.setAn(3);
		student.setNume("Hriscu");
		student.setPrenume("Florin");
		student.setNrMatricol("31022234SL120272");
	}
	
	/*
	 * Metoda care returneaza Transpusa matricii 
	 */
	protected int[][] transposedMatrix()
	{
		int[][] trMatrix= new int[this._Key.length][this._Key.length];
		for( int i=0; i< this._Key.length;i++)
			for(int j=0;j< this._Key.length;j++)
				trMatrix[j][i]=this._Key[i][j];
		
		//afisare transpusa
		System.out.println("Matricea transpusa: ");
		for(int i=0;i<this._Key.length;i++)
			{
				for(int j=0;j<this._Key.length;i++)
					System.out.println(trMatrix[i][i]);
				System.out.println();
			}
		return trMatrix;
		
	}
	/*
	 * Metoda care returneaza norma euclidiana a punctului p
	 */
	protected double euclidianNormOfP()
	{
		double euclidianNorm=Math.sqrt(param1 + param2 + param3 + param4 + param5 + param6);
		System.out.println("Norma euclidiana: ");
		return euclidianNorm;
	}
	/*
	 * Metoda care returneaza punctul/tuplul criptat
	 */
	public void encryptedPointMethod()
	{
		double dPlusOneDimPoint[][]=new double [_Key.length+1][1];
		dPlusOneDimPoint[0][0]=param1;
		dPlusOneDimPoint[1][0]=param2;
		dPlusOneDimPoint[2][0]=param3;
		dPlusOneDimPoint[3][0]=param4;
		dPlusOneDimPoint[4][0]=param5;
		dPlusOneDimPoint[5][0]=param6;
		double euclidianNorm=euclidianNormOfP(); 
		dPlusOneDimPoint[6][0]=0.5 * euclidianNorm * euclidianNorm;
		
		double encryptedPoint[]= new double[_Key.length];
		for(int i=0;i<_Key.length;i++)
			encryptedPoint[i]=0;
		
		int transposedMatrix[][]=transposedMatrix();
		for(int i=0;i<transposedMatrix.length;i++)
			for(int j=0;j<transposedMatrix.length;j++)
				encryptedPoint[i]=encryptedPoint[i]+transposedMatrix[i][j] * dPlusOneDimPoint[j][0];
		System.out.println("Punctul criptat: ");
		for(int i=0;i<encryptedPoint.length;i++)
			System.out.print(encryptedPoint[i]+" ");
	}
	
	public static void main(String[] args)
	{
		Configuration configuration = new Configuration();
		configuration.configure("DBconnection.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		Session s= sessionFactory.openSession();
		org.hibernate.Transaction tx= s.beginTransaction();
		s.save(student);
		s.flush();
		tx.commit();
		s.close();
	}
}
