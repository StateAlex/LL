public class EncryptedStudent 
{
	protected int[][] _Key=
			{
				{ 1,2,3,4},
				{ 5,6,7,8},
				{ 4,3,2,1},
				{ 8,7,6,5}
			};
	public double encryptedPoint[]= new double[_Key.length+1];	
	public Student student= new Student();
	
	public double param1, param2, param3;
	public void initStudent(int id, int an, int nrRestante)
	{
		student.setId(id);
		student.setAn(an);
		student.setRestante(nrRestante);
		
		param1=student.id * student.id;
		param2=student.an * student.an;
		param3=student.restante * student.restante;
	}
	/*
 	 * Metoda care returneaza Transpusa matricii 
	 */
	protected int[][] transposedMatrix()
	{
		System.out.println(this._Key.length);
		int[][] trMatrix= new int[this._Key.length+1][this._Key.length+1];
		for( int i=0; i< this._Key.length;i++)
			for(int j=0;j< this._Key.length;j++)
				trMatrix[j][i]=this._Key[i][j];
		
		//afisare transpusa
		System.out.println("Matricea transpusa: ");
		for(int i=0;i< this._Key.length;i++)
			{
				for(int j=0;j<this._Key.length;j++)
					System.out.print(trMatrix[i][j]+" ");
				System.out.println();
			}
		return trMatrix;
		
	}
	/*
	 * Metoda care returneaza norma euclidiana a punctului p
	 */
	protected double euclidianNormOfP()
	{
		double euclidianNorm;
		euclidianNorm=Math.sqrt(param1 + param2 + param3 );
		System.out.println("Norma euclidiana: "+ euclidianNorm);
		return euclidianNorm;
	}
	/*
	 * Metoda care returneaza punctul/tuplul criptat
	 */
	public void encryptedPointMethod()
	{
		double dPlusOneDimPoint[]=new double [_Key.length+1];
		// vectorul normal, la care se ataseaza 0.5 * norma euclidiana
		
		dPlusOneDimPoint[0]=param1;
		dPlusOneDimPoint[1]=param2;
		dPlusOneDimPoint[2]=param3;
		double euclidianNorm=euclidianNormOfP();
		dPlusOneDimPoint[3]=0.5 * euclidianNorm * euclidianNorm;
		
		for(int i=0;i<_Key.length;i++)
			encryptedPoint[i]=0;
		
		// urmeaza p'=MT * p cu caciulita
		int transposedMatrix[][]=transposedMatrix();
		for(int i=0;i<transposedMatrix.length;i++)
			for(int j=0;j<transposedMatrix.length;j++)
				encryptedPoint[i]=encryptedPoint[i]+transposedMatrix[i][j] * dPlusOneDimPoint[j];
		
		System.out.println("Punctul criptat: ");
		for(int i=0;i<encryptedPoint.length-1;i++)
			System.out.print(encryptedPoint[i]+" ");
	}	
}
