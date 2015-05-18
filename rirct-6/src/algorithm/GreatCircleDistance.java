package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bean.CrimeReport;
import bean.Crimes;
import bean.PoliceStations;
import utils.*;



public class GreatCircleDistance {
	public static void main(String[] args) { 
		//read a record from crimes and read all records from police stations
		//find distances between all the points
		HashMap distances = new HashMap();
		List<Crimes> list = DataAccessUtil.getAll(Crimes.class);
		int length = list.size()-1;
		Crimes cr = list.get(length);	//get the last record
		double x1 = Math.toRadians(Double.parseDouble(cr.getLatitude()));
		double y1 = Math.toRadians(Double.parseDouble(cr.getLongitude()));
		List<PoliceStations> list2 = DataAccessUtil.getAll(PoliceStations.class);
		for (PoliceStations ps : list2)
		{
			double x2 = Math.toRadians(Double.parseDouble(ps.getLatitude()));
			double y2 = Math.toRadians(Double.parseDouble(ps.getLongitude()));
			/*************************************************************************
		    * Compute using Haversine formula
		    *************************************************************************/
		    double a = Math.pow(Math.sin((x2-x1)/2), 2)
		             + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);

		    // great circle distance in radians
		    double angle2 = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

		    // convert back to degrees
		    angle2 = Math.toDegrees(angle2);

		    // each degree on a great circle of Earth is 60 nautical miles
		    double distance2 = 60 * angle2;

		    distances.put(ps,distance2);
		    System.out.println(distance2 + " nautical miles");
		}		
		PoliceStations p = new PoliceStations();
	    Set keyset = distances.keySet();
		Object obj = Collections.min(distances.values());
		obj = (double)obj;
		Iterator iterator = distances.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println("hhh");
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			Double val = (Double) mapEntry.getValue();
			if (obj.equals(val))
			{
				System.out.println("HERE");
				p=(PoliceStations) mapEntry.getKey();
				
				break;
			}
			//System.out.println("The key is: " + mapEntry.getKey()
			//	+ ",value is :" + mapEntry.getValue());
		}
		//System.out.println(min.getKey()); // 0.1
		System.out.println("Minimum distance : "+obj.toString() + "ps " +p.getName()+ " nautical miles");
		CrimeReport report = new CrimeReport();
		
		//report.setCasename(cr.getIdcrimes());
		report.setCasename(cr.getDescription());
		report.setLatitude(cr.getLatitude());
		report.setLongitude(cr.getLongitude());
		report.setNearestpolicestation(p.getName());
		report.setPolicestationlatitude(p.getLatitude());
		report.setPolicestationlongitude(p.getLongitude());
		report.setCity(p.getCity());
		report.setStatus("reported");
		DataAccessUtil.save(report);
   }
}

/*************************************************************************
 * Compute using law of cosines
 *************************************************************************/
 // great circle distance in radians
 /*double angle1 = Math.acos(Math.sin(x1) * Math.sin(x2)
               + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

 // convert back to degrees
 angle1 = Math.toDegrees(angle1);

 // each degree on a great circle of Earth is 60 nautical miles
 double distance1 = 60 * angle1;

 System.out.println(distance1 + " nautical miles"); */

