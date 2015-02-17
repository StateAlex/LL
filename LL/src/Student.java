import java.io.Serializable;


public class Student implements Serializable
{
	protected int id;
	protected int an;
	protected int restante;
	protected int getId() 
	{
		return id;
	}
	protected void setId(int id) 
	{
		this.id = id;
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
}
