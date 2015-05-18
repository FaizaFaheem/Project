package rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import utils.DataAccessUtil;
import bean.CrimeReport;
import bean.PoliceStations;

@Path("/editpolice")
public class EditPolice {	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PoliceStations> getAllPoliceStations()
	{
		
		List<PoliceStations> p = new ArrayList<PoliceStations>();
		p=DataAccessUtil.getAll(PoliceStations.class);
		return p;
	}*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PoliceStations> getAllPoliceStations()
	{
		
		List<PoliceStations> p = new ArrayList<PoliceStations>();
		p=DataAccessUtil.getAll(PoliceStations.class);
		return p;
	}
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
	public PoliceStations EditPoliceStation(@FormParam("Name") String station_name,@FormParam("xcoordinate") String xcord,@FormParam("ycoordinate") String ycord,@FormParam("city") String city)
	{	
		List<PoliceStations> list = DataAccessUtil.getAll(PoliceStations.class);
		PoliceStations p = new PoliceStations();
		for (PoliceStations ps : list)
		{
			if (ps.getName().equals(station_name))
			{
				ps.setLatitude(xcord);
				ps.setLongitude(ycord);
				ps.setCity(city);
				DataAccessUtil.update(ps);
				p=ps;
			}	 
		}
		return p;
	}
}
