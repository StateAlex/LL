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
	public double encryptedPoint[]= new double[_Key.length];	
	public Student student= new Student();
	
	double param1=student.id * student.id;
	double param2=student.an * student.an;
	double param3=student.restante * student.restante;
	double param4=Integer.parseInt(student.nume) * Integer.parseInt(student.nume);
	double param5=Integer.parseInt(student.prenume) * Integer.parseInt(student.prenume);
	double param6=Integer.parseInt(student.nrMatricol) * Integer.parseInt(student.nrMatricol);
	
	public void initStudent(int id, int an, String nume, String prenume, String nrMatricol)
	{
		student.setId(id);
		student.setAn(an);
		student.setNume(nume);
		student.setPrenume(prenume);
		student.setNrMatricol(nrMatricol);
	}
	public void initStudent(int id, int an, String nume, String prenume, String nrMatricol, int nrRestante)
	{
		student.setId(id);
		student.setAn(an);
		student.setNume(nume);
		student.setPrenume(prenume);
		student.setNrMatricol(nrMatricol);
		student.setRestante(nrRestante);
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
}
