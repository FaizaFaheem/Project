package servlet;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;










import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import utils.DataAccessUtil;
import algorithm.HaversineNearestDistance;
import bean.CrimeReport;
import bean.Crimes;
import bean.PoliceStations;

/**
 * Servlet implementation class Nearestpolice
 */
@WebServlet("/Nearestpolice")
public class Nearestpolice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nearestpolice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("Hello-in nearest police");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//First save the incoming crime report to the crimes table
		Crimes c = new Crimes();
		//Collection<Part> parts = request.getParts();
		/*Part filePart = request.getPart("photo");
		InputStream imageInputStream = filePart.getInputStream();
		BufferedImage image=ImageIO.read(imageInputStream);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( (RenderedImage) image, "jpg", baos );
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();*/
		/*InputStream inputStream = null; 
		Part filePart = request.getPart("photo");  
        if (filePart != null) {  
            // debug messages  
            System.out.println(filePart.getName());  
            System.out.println(filePart.getSize());  
            System.out.println(filePart.getContentType());  
  
            // obtains input stream of the upload file  
            inputStream = filePart.getInputStream();  
        } */ 
       // byte[] s = IOUtils.toByteArray(inputStream);
		/*c.setPhoto(s);
		c.setLatitude(request.getParameter("latitude"));
		c.setLongitude(request.getParameter("longitude"));
		c.setDescription(request.getParameter("description"));
		DataAccessUtil.save(c);
		
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
		report.setStatus("reported");
		DataAccessUtil.save(report);*/
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			System.out.println("You are not trying to upload<br/>");
			return;
		}
		System.out.println("You are trying to upload<br/>");
		byte[] data=null;
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// Parse the request
			List<FileItem> uploadItems = upload.parseRequest( request );

			for( FileItem uploadItem : uploadItems )
			{
			  if( uploadItem.isFormField() )
			  {
			    String fieldName = uploadItem.getFieldName();
			    String value = uploadItem.getString();
			    if (fieldName.equals("latitude"))
			    	c.setLatitude(value);
			    else if (fieldName.equals("longitude"))
			    	c.setLongitude(value);
			    else if (fieldName.equals("description"))
			    	c.setDescription(value);
			  }
			  else
			  {
				  data = uploadItem.get();
				  c.setPhoto(data);
			  }
			}
		} 
		catch (FileUploadException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataAccessUtil.save(c);
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
		report.setPhoto(data);
		report.setStatus("reported");
		DataAccessUtil.save(report);
		response.setStatus(HttpServletResponse.SC_OK);
		response.getOutputStream().println("Hurray !! This Servlet Works");
	}
}
