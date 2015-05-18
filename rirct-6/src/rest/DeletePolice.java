package rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import utils.DataAccessUtil;
import bean.PoliceStations;

@Path("/deletepolice")
public class DeletePolice {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PoliceStations> getAllPoliceStations()
	{
		
		List<PoliceStations> p = new ArrayList<PoliceStations>();
		p=DataAccessUtil.getAll(PoliceStations.class);
		return p;
	}
	@DELETE
	public void DeletePoliceStation()
	{
		
		String station_name="abc";
		String xcord = "asdss";
		String ycord = "2.5";
		
		List<PoliceStations> list = DataAccessUtil.getAll(PoliceStations.class);
		for (PoliceStations ps : list)
		{
			if (ps.getName().equals(station_name) && ps.getLatitude().equals(xcord)
					&& ps.getLongitude().equals(ycord))
			{
				DataAccessUtil.update(ps);
			}
				
		}
	}

}
