package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
 


@Entity @Table(name = "crimereport")
public class CrimeReport {
	
	private int idcrimereport;
	private String casename;
	private String latitude;
	private String longitude;
	private String nearestpolicestation;
	private String policestationlat;
	private String policestationlong;
	private String city;
	private String casestatus;
	@Lob
	private byte[] photo;
	
	public CrimeReport()
	{
		
	}
	public void setIdcrimereport(int id)
	{
		this.idcrimereport = id;
	}
	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idcrimereport")
	public int getIdcrimereport()
	{
		return this.idcrimereport;
	}

	public void setCasename(String name)
	{
		this.casename = name;
	}
	@Column(name = "casename")
	public String getCasename()
	{
		return this.casename;
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
	public void setNearestpolicestation(String polstation)
	{
		this.nearestpolicestation = polstation;
	}
	@Column(name = "nearestpolicestation")
	public String getNearestpolicestation()
	{
		return this.nearestpolicestation;
	}
	public void setPolicestationlatitude(String lat)
	{
		this.policestationlat = lat;
	}
	@Column(name = "polstationlatitude")
	public String getPolicestationlatitude()
	{
		return this.policestationlat;
	}

	public void setPolicestationlongitude(String lng)
	{
		this.policestationlong = lng;
	}
	@Column(name = "polstationlongitude")
	public String getPolicestationlongitude()
	{
		return this.policestationlong;
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
	public void setStatus(String status)
	{
		this.casestatus = status;
	}
	@Column(name = "casestatus")
	public String getStatus()
	{
		return this.casestatus;
	}
	public void setPhoto(byte[] Photo)
	{
		this.photo = Photo;
	}
	@Column(name = "photo")
	public byte[] getPhoto()
	{
		return this.photo;
	}
}
