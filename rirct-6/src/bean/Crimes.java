package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

import com.mysql.jdbc.Blob;

import javax.sql.rowset.serial.SerialBlob;
 


@Entity @Table(name = "crimes")
public class Crimes {
	
	private int idcrimes;
	private String latitude;
	private String longitude;
	private String description;
	@Lob
	private byte[] photo;
	public Crimes()
	{
		
	}
	public void setIdcrimes(int id)
	{
		this.idcrimes = id;
	}
	@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idCrimes")
	
	public int getIdcrimes()
	{
		return this.idcrimes;
	}

	public void setPhoto(byte[] Photo)
	{
		this.photo = Photo;
	}
	@Column(name = "Photo")
	public byte[] getPhoto()
	{
		return this.photo;
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
	public void setDescription(String desc)
	{
		this.description = desc;
	}
	@Column(name = "Description")
	public String getDescription()
	{
		return this.description;
	}
}
	 