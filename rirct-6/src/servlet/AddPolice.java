package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DataAccessUtil;
import bean.PoliceStations;

/**
 * Servlet implementation class AddPolice
 */
@WebServlet("/AddPolice")
public class AddPolice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPolice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//conection between the client request and server response
		PrintWriter out = response.getWriter();
		out.println("Hello ");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PoliceStations p = new PoliceStations();
		p.setName(request.getParameter("Name"));
		p.setLatitude(request.getParameter("latitude"));
		p.setLongitude (request.getParameter("longitude"));
		p.setCity(request.getParameter("city"));
		DataAccessUtil.save(p);
	}
}
