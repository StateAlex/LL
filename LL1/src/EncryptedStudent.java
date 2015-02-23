import java.io.Serializable;

public class EncryptedStudent implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int[][] _Key=
			{
				{ 1,2,3,4},
				{ 5,6,7,8},
				{ 4,3,2,1},
				{ 8,7,6,5}
			};
	public double encryptedPoint[]= new double[_Key.length+1];	
	public Student student= new Student();
	
	private double dimension1;
	private double dimension2;
	private double dimension3;
	private double ePlusdimension;
	
	private double getdimension1() 
	{
		return this.dimension1;
	}
	
	private void setdimension1(double dimension1) 
	{
		this.dimension1 = dimension1;
	}
	
	private double getdimension2() 
	{
		return this.dimension2;
	}
	
	private void setdimension2(double dimension2) 
	{
		this.dimension2 = dimension2;
	}
	
	private double getdimension3() 
	{
		return this.dimension3;
	}
	
	private void setdimension3(double dimension3) 
	{
		this.dimension3 = dimension3;
	}
	
	private double getePlusdimension() 
	{
		return this.ePlusdimension;
	}
	
	private void setePlusdimension(double ePlusdimension) 
	{
		this.ePlusdimension = ePlusdimension;
	}
	public void initStudent(int id, int an, int nrRestante)
	{
		student.setId(id);
		student.setAn(an);
		student.setRestante(nrRestante);
		
		this.dimension1=student.id * student.id;
		this.dimension2=student.an * student.an;
		this.dimension3=student.restante * student.restante;
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
		euclidianNorm=Math.sqrt(this.dimension1 + this.dimension2 + this.dimension3 );
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
		
		dPlusOneDimPoint[0]=this.dimension1;
		dPlusOneDimPoint[1]=this.dimension2;
		dPlusOneDimPoint[2]=this.dimension3;
		double euclidianNorm=euclidianNormOfP();
		dPlusOneDimPoint[3]=0.5 * euclidianNorm * euclidianNorm;
		
		for(int i=0;i<_Key.length;i++)
			encryptedPoint[i]=0;
		
		// urmeaza p'=MT * p cu caciulita
		int transposedMatrix[][]=transposedMatrix();
		for(int i=0;i<transposedMatrix.length;i++)
			for(int j=0;j<transposedMatrix.length;j++)
				encryptedPoint[i] = encryptedPoint[i]+transposedMatrix[i][j] * dPlusOneDimPoint[j];
		
		this.dimension1 = encryptedPoint[0];
		this.dimension2 = encryptedPoint[1];
		this.dimension3 = encryptedPoint[2];
		this.ePlusdimension = encryptedPoint[3];
				
		System.out.println(dimension1 +" "+ dimension2 + " " + dimension3 +  " " + ePlusdimension);
	}	
}