package servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import algorithm.HaversineNearestDistance;
import bean.CrimeReport;
import bean.Crimes;
import bean.PoliceStations;
import bean.tester;
import sun.misc.BASE64Decoder;
import sun.rmi.runtime.Log;
import utils.DataAccessUtil;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getOutputStream().println("Hurray !! This Servlet Works");
		PrintWriter out = response.getWriter();
		out.println("Hello ");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log(request.getParameter("description"));
		log("HERE");
		//tester t = new tester();
		//t.setX(request.getParameter("description"));
		Crimes c = new Crimes();
		c.setDescription(request.getParameter("description"));
		c.setLatitude(request.getParameter("latitude"));
		c.setLongitude(request.getParameter("longitude"));
		BASE64Decoder decoder = new BASE64Decoder();
		c.setPhoto(decoder.decodeBuffer(request.getParameter("photo")));
		DataAccessUtil.save(c);
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.getOutputStream().println("Hurray !! This Servlet Works");
		PoliceStations p = new PoliceStations();
		p=HaversineNearestDistance.findNearestDistance(c);
		//Now find the nearest police station and add the crime report to the crimereport table
		CrimeReport report = new CrimeReport();
		
		//report.setCasename(cr.getIdcrimes());
		report.setCasename(c.getDescription());
		report.setLatitude(c.getLatitude());
		report.setLongitude(c.getLongitude());
		report.setNearestpolicestation(p.getName());
		report.setPolicestationlatitude(p.getLatitude());
		report.setPolicestationlongitude(p.getLongitude());
		report.setCity(p.getCity());
		report.setPhoto(c.getPhoto());
		report.setStatus("pending");
		DataAccessUtil.save(report);
		response.setStatus(HttpServletResponse.SC_OK);
		response.getOutputStream().println("Hurray !! This Servlet Works");

		//response.getOutputStream().println(request.getParameter("action"));
		/*  try {
	            int length = request.getContentLength();
	            byte[] input = new byte[length];
	            ServletInputStream sin = request.getInputStream();
	            int c, count = 0 ;
	            while ((c = sin.read(input, count, input.length-count)) != -1) {
	                count +=c;
	            }
	            sin.close();
	 
	            String recievedString = new String(input);
	            response.setStatus(HttpServletResponse.SC_OK);
	            OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());
	 
	            Integer doubledValue = Integer.parseInt(recievedString) * 2;
	 
	            writer.write(doubledValue.toString());
	            writer.flush();
	            writer.close();
	 
	 
	 
	        } catch (IOException e) {
	 
	 
	            try{
	                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	                response.getWriter().print(e.getMessage());
	                response.getWriter().close();
	            } catch (IOException ioe) {
	            }
	        } */
	}
}
