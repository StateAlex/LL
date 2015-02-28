import java.util.Random;


public class EncryptedQuery 
{
	private int nrRandom;
	private int[][] _Key=
		{
			{ 1,2,3,4},
			{ 5,6,7,8},
			{ 4,3,2,1},
			{ 8,7,6,5}
		};
	public EncryptedQuery()
	{
		// generarea numarului random mai mare ca 0
		Random GeneratorRandom = new Random();
		nrRandom = GeneratorRandom.nextInt();
		while(nrRandom < 0)
		{
			nrRandom = GeneratorRandom.nextInt();
		}
	}

	// Metoda care calculeaza determinantul matricii cheie
	public int _Determinant(int [][] matrix)
	{ //method sig. takes a matrix (two dimensional array), returns determinant.
	    int sum = 0; 
	    int s;
	    if(matrix.length == 1)
	    {  //bottom case of recursion. size 1 matrix determinant is itself.
	      return(matrix[0][0]);
	    }
	    for(int i=0;i<matrix.length;i++)
	    { 
	    	//finds determinant using row-by-row expansion
	      int[][]smaller= new int[matrix.length-1][matrix.length-1]; //creates smaller matrix- values not in same row, column
	      for(int a=1;a<matrix.length;a++)
	      {
	        for(int b=0;b<matrix.length;b++)
	        {
	          if(b<i){
	            smaller[a-1][b]=matrix[a][b];
	          }
	          else if(b>i){
	            smaller[a-1][b-1]=matrix[a][b];
	          }
	        }
	      }
	      if(i%2==0)
	      { //sign changes based on i
	        s=1;
	      }
	      else
	      {
	        s=-1;
	      }
	      sum+=s * matrix[0][i] * (_Determinant(smaller));// recursive step: determinant of larger determined by smaller.
	    }
	    return(sum); //returns determinant value. once stack is finished, returns final determinant.
	  }
	/*
	 * Metoda care returneaza o matrice de i linii si j coloane
	 */
	public int[][] _PartitionMatrix(int nrLin, int nrCol, int[][] matrix)
	{
		int[][] newMatrix = new int [nrLin][nrCol];
		for(int i=0;i<=nrLin;i++)
			for(int j=0;j<=nrCol;j++)
				newMatrix[i][j]=matrix[i][j];
		return newMatrix;
	}
	
	/*
	 * Metoda care calculeaza inversa matricei
	 */
	public double[][] _InvMatrix()
	{
		// calculam matricea adjuncta si impartim cu det. key
		int nrDimensions = _Key.length;
		double [][] invMatrix= new double[nrDimensions][nrDimensions];
		//am stabilit semnul fiecarui element din matrice
		for(int i=0;i<nrDimensions;i++)
			for(int j=0; j<nrDimensions;j++)
				{
					invMatrix[i][j]=Math.pow(-1,i+j+1);
					invMatrix[i][j]=invMatrix[i][j] * _Determinant(_PartitionMatrix(i,j,_Key)) / _Determinant(_Key);;
				}
		return invMatrix;
	}
	
	//criptarea punctului din interogare
	public double[] _QueryPoint(double toEncryptPoint[], int nrDimensions)
	{
		double EncryptedPoint[]= new double [nrDimensions+1];
		double finalEncryptedPoint[]= new double [nrDimensions+1];
		double [][] invMatrix= new double[nrDimensions+1][nrDimensions+1];
		invMatrix=_InvMatrix();
		
		for(int i=0; i<nrDimensions; i++)
			EncryptedPoint[i] = nrRandom * toEncryptPoint[i];
		EncryptedPoint[nrDimensions]=nrRandom;
		
		for(int i=0;i<nrDimensions+1;i++)
			for(int j=0;j<nrDimensions+1;j++)
				finalEncryptedPoint[i]=finalEncryptedPoint[i]+invMatrix[i][j]*EncryptedPoint[j];
		return EncryptedPoint;
	}
}
