package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity @Table(name = "test")
public class tester {
	private int id;
	private String x;
	
	public tester()
	{
		
	}
	public void setId(int id)
	{
		this.id = id;
	}
	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")	
	public int getId()
	{
		return this.id;
	}

	public void setX(String t)
	{
		this.x = t;
	}
	@Column(name = "testcol")
	public String getX()
	{
		return this.x;
	}
}
