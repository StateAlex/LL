import java.io.Serializable;


public class Student implements Serializable
{
	protected int id;
	protected String nume;
	protected String prenume;
	protected int an;
	protected int restante;
	protected String nrMatricol;
	
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
	
	protected int getId() 
	{
		return id;
	}
	protected void setId(int id) 
	{
		this.id = id;
	}
	protected String getNume() 
	{
		return nume;
	}
	protected void setNume(String nume) 
	{
		this.nume = nume;
	}
	protected String getPrenume() 
	{
		return prenume;
	}
	protected void setPrenume(String prenume) 
	{
		this.prenume = prenume;
	}
	protected int getAn() 
	{
		return an;
	}
	protected void setAn(int an)
	{
		this.an = an;
	}
	protected int getRestante() 
	{
		return restante;
	}
	protected void setRestante(int restante) 
	{
		this.restante = restante;
	}
	protected String getNrMatricol() 
	{
		return nrMatricol;
	}
	protected void setNrMatricol(String nrMatricol) 
	{
		this.nrMatricol = nrMatricol;
	}
	protected void encrypt_Function()
	{
		
	}
	/*
	 * Functie care returneaza Transpusa matricii 
	 */
	protected int[][] transposedMatrix()
	{
		int[][] trMatrix= new int[this._Key.length][this._Key.length];
		for( int i=0; i< this._Key.length;i++)
			for(int j=0;j< this._Key.length;j++)
				trMatrix[j][i]=this._Key[i][j];
		return trMatrix;
	}
	protected double euclidianNormOfP()
	{
		int param1=this.id*this.id;
		int param2=this.an*this.an;
		int param3=this.restante*this.restante;
		int param4=Integer.parseInt(this.nume)*Integer.parseInt(this.nume);
		int param5=Integer.parseInt(this.prenume)*Integer.parseInt(this.prenume);
		int param6=Integer.parseInt(this.nrMatricol)*Integer.parseInt(this.nrMatricol);
		double euclidianNorm=Math.sqrt(param1+param2+param3+param4+param5+param6);
		return euclidianNorm;
	}
}
