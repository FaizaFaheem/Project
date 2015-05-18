package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import utils.DataAccessUtil;
import bean.CrimeReport;
import bean.PoliceReport;

@Path("/showcompletedcrimes")
public class EchoCompletedReports 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PoliceReport> getAllCrimeReports()
	{
		List<CrimeReport> p = new ArrayList<CrimeReport>();
		List<PoliceReport> completedCrimeReports = new ArrayList<PoliceReport>();
		
		p=DataAccessUtil.getAll(CrimeReport.class);
		for (CrimeReport c:p)
		{
			if (c.getStatus().toLowerCase().equals("completed"))
			{
				PoliceReport pr = new PoliceReport();
				pr.setCasename(c.getCasename());
				pr.setLatitude(c.getLatitude());
				pr.setLongitude(c.getLongitude());
				pr.setPhoto(c.getPhoto());
				pr.setStatus(c.getStatus().toLowerCase());
				completedCrimeReports.add(pr);
			}
		}
		return completedCrimeReports;
	}
}
