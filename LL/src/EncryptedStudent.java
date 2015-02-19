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
	
	public double _Dimension1;
	public double _Dimension2;
	public double _Dimension3;
	public double _EPlus_Dimension;
	
	public double get_EPlus_Dimension() {
		return _EPlus_Dimension;
	}
	public void set_EPlus_Dimension(double _EPlus_Dimension) {
		_EPlus_Dimension = _EPlus_Dimension;
	}
	
	public double get_Dimension1() {
		return _Dimension1;
	}
	public void set_Dimension1(double _Dimension1) {
		_Dimension1 = _Dimension1;
	}
	public double get_Dimension2() {
		return _Dimension2;
	}
	public void set_Dimension2(double _Dimension2) {
		_Dimension2 = _Dimension2;
	}
	public double get_Dimension3() {
		return _Dimension3;
	}
	public void set_Dimension3(double _Dimension3) {
		_Dimension3 = _Dimension3;
	}

	public void initStudent(int id, int an, int nrRestante)
	{
		student.setId(id);
		student.setAn(an);
		student.setRestante(nrRestante);
		
		_Dimension1=student.id * student.id;
		_Dimension2=student.an * student.an;
		_Dimension3=student.restante * student.restante;
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
		euclidianNorm=Math.sqrt(_Dimension1 + _Dimension2 + _Dimension3 );
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
		
		dPlusOneDimPoint[0]=_Dimension1;
		dPlusOneDimPoint[1]=_Dimension2;
		dPlusOneDimPoint[2]=_Dimension3;
		double euclidianNorm=euclidianNormOfP();
		dPlusOneDimPoint[3]=0.5 * euclidianNorm * euclidianNorm;
		
		for(int i=0;i<_Key.length;i++)
			encryptedPoint[i]=0;
		
		// urmeaza p'=MT * p cu caciulita
		int transposedMatrix[][]=transposedMatrix();
		for(int i=0;i<transposedMatrix.length;i++)
			for(int j=0;j<transposedMatrix.length;j++)
				encryptedPoint[i] = encryptedPoint[i]+transposedMatrix[i][j] * dPlusOneDimPoint[j];
		
		_Dimension1 = encryptedPoint[0];
		_Dimension2 = encryptedPoint[1];
		_Dimension3 = encryptedPoint[2];
		_EPlus_Dimension = encryptedPoint[3];
				
		System.out.println(_Dimension1 +" "+ _Dimension2 + " " + _Dimension3 +  " " + _EPlus_Dimension);
	}	
}