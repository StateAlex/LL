import java.util.Random;


public class EncryptedQuery 
{
	private int nrRandom;
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
	public int _Determinant(int[][] matrix)
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
	
	public double[][] _PartitionMatrix(int nrLin, int nrCol, double[][] matrix)
	{
		double[][] newMatrix = new double [nrLin][nrCol];
		for(int i=0;i<=nrLin;i++)
			for(int j=0;j<=nrCol;j++)
				newMatrix[i][j]=matrix[i][j];
		return newMatrix;
	}
	
	
	public double[][] _AdjMatrix(int[][] matrix, int nrDimensions)
	{
		double [][] adjMatrix= new double[nrDimensions][nrDimensions];
		//am stabilit semnul fiecarui element din matrice
		for(int i=0;i<nrDimensions;i++)
			for(int j=0; j<nrDimensions;j++)
				{
					adjMatrix[i][j]=Math.pow(-1,i+j+1) * _Determinant(_PartitionMatrix(i,j,/*  */));
				}
		
		return adjMatrix;
	}
	public double[][] _InversableMatrix()
	{
		
	}
	
	//criptarea punctului din interogare
	public double[] _QueryPoint(double toEncryptPoint[], int nrDimensions)
	{
		double EncryptedPoint[]= new double [nrDimensions+1];
		
		for(int i=0; i<nrDimensions+1; i++)
			EncryptedPoint[i]=nrRandom * toEncryptPoint[i];
		EncryptedPoint[nrDimensions]=nrRandom;
		
		return EncryptedPoint;
	}
}
