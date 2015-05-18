package demo;


import java.util.List;

import bean.CrimeReport;
import bean.Crimes;
import bean.PoliceStations;
import utils.*;




public class Demoread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Crimes[] cr = new Crimes[5];
		List<Crimes> list = DataAccessUtil.getAll(Crimes.class);
		for (Crimes cr : list)
		{
			System.out.println(cr.getIdcrimes());
			System.out.println(cr.getPhoto());
			System.out.println(cr.getDescription());
			System.out.println(cr.getLatitude());
			System.out.println(cr.getLongitude());
			
		}
		
		List<CrimeReport> list2 = DataAccessUtil.getAll(CrimeReport.class);
		for (CrimeReport cr : list2)
		{
			System.out.println(cr.getIdcrimereport());
			System.out.println(cr.getCasename());
			System.out.println(cr.getNearestpolicestation());
			System.out.println(cr.getPolicestationlatitude());
			System.out.println(cr.getPolicestationlongitude());
			System.out.println(cr.getCity());
			System.out.println(cr.getStatus());
			System.out.println(cr.getLatitude());
			System.out.println(cr.getLongitude());
		}
		
		List<PoliceStations> list3 = DataAccessUtil.getAll(PoliceStations.class);
		for (PoliceStations cr : list3)
		{
			System.out.println(cr.getIdpolicestation());
			System.out.println(cr.getName());
			System.out.println(cr.getCity());
			System.out.println(cr.getLatitude());
			System.out.println(cr.getLongitude());
		}
	}

}
