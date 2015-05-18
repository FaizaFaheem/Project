package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
 


@Entity @Table(name = "policestations")
public class PoliceStations {
	private int idpolicestations;
	private String name;
	private String latitude;
	private String longitude;
	private String city;
	
	public PoliceStations()
	{
		
	}
	public void setIdpolicestation(int id)
	{
		this.idpolicestations = id;
	}
	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idpolicestations")
	public int getIdpolicestation()
	{
		return this.idpolicestations;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	@Column(name = "Name")
	public String getName()
	{
		return this.name;
	}
	public void setLatitude(String lat)
	{
		this.latitude = lat;
	}
	@Column(name = "latitude")
	public String getLatitude()
	{
		return this.latitude;
	}

	public void setLongitude(String lng)
	{
		this.longitude = lng;
	}
	@Column(name = "longitude")
	public String getLongitude()
	{
		return this.longitude;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	@Column(name = "city")
	public String getCity()
	{
		return this.city;
	}
}
