package demo;


import java.util.List;

import bean.CrimeReport;
import utils.*;


public class Demoupdate {
	public static void main(String[] args) {
		String casename="abc";
		String xcord = "asdss";
		String ycord = "2.5";
		
		List<CrimeReport> list = DataAccessUtil.getAll(CrimeReport.class);
		for (CrimeReport cr : list)
		{
			if (cr.getCasename().equals(casename) && cr.getLatitude().equals(xcord)
					&& cr.getLongitude().equals(ycord) && (cr.getStatus()).toLowerCase().equals("pending"))
			{
				cr.setStatus("completed");
				DataAccessUtil.update(cr);
			}
				
		}
		
	}

}
