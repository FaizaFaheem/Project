package demo;

import bean.CrimeReport;
import bean.Crimes;
import bean.PoliceStations;
import utils.*;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Crimes cr=new Crimes();
		cr.setDescription("abc");
		//cr.setPhoto(new byte[]);
		cr.setLatitude("2.5");
		cr.setLongitude("0.5");
		DataAccessUtil.save(cr);
		/////
		///////////
		
	 CrimeReport crep = new CrimeReport();
	 crep.setCasename("abc");
		crep.setLatitude("asdss");
		crep.setLongitude("2.5");
		crep.setNearestpolicestation("0.5");
		crep.setPolicestationlatitude("0.5");
		crep.setPolicestationlongitude("0.5");
		crep.setCity("isl");
		crep.setStatus("pending");
		DataAccessUtil.save(crep);
		
		PoliceStations p = new PoliceStations();
		 p.setName("abc");
			p.setLatitude("asdss");
			p.setLongitude("2.5");
			p.setCity("0.5");
			DataAccessUtil.save(p);	
	}
}
