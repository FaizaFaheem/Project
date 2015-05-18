package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import utils.DataAccessUtil;
import bean.PoliceStations;
@Path("/police")
public class Police {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PoliceStations> getAllPoliceStations()
	{
		
		List<PoliceStations> p = new ArrayList<PoliceStations>();
		p=DataAccessUtil.getAll(PoliceStations.class);
		return p;
	}

}
