import java.io.Serializable;


public class Student implements Serializable
{
	protected int id;
	protected String nume;
	protected String prenume;
	protected int an;
	protected int restante;
	protected String nrMatricol;
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
	
}
