package bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

public class PoliceReport {
	private String casename;
	private String latitude;
	private String longitude;
	private String casestatus;
	@Lob
	private byte[] photo;
	
	public PoliceReport()
	{
		
	}

	public void setCasename(String name)
	{
		this.casename = name;
	}
	public String getCasename()
	{
		return this.casename;
	}
	public void setLatitude(String lat)
	{
		this.latitude = lat;
	}
	public String getLatitude()
	{
		return this.latitude; 
	}
	
	public void setLongitude(String lng)
	{
		this.longitude = lng;
	}
	public String getLongitude()
	{
		return this.longitude;
	}
	public void setStatus(String status)
	{
		this.casestatus = status;
	}
	public String getStatus()
	{
		return this.casestatus;
	}
	public void setPhoto(byte[] Photo)
	{
		this.photo = Photo;
	}
	public byte[] getPhoto()
	{
		return this.photo;
	}

}
