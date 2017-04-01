package atj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Second
 */
@WebServlet("/Second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Second() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


	      HttpSession session = request.getSession();
	      
	      Counter counter = (Counter)session.getAttribute("counter");
	      
	      if(counter == null) {
	        counter = new Counter();
	        session.setAttribute("counter", counter);
	     
	      }

	      if(request.getParameterMap().containsKey("clr_btn")) {
	            counter.setValue(counter.getValue()+1);
	        
	        }
	        
	      String url = "/second.jsp";
	      
	     

	      RequestDispatcher requestDispatcher =
	        getServletContext().getRequestDispatcher(url);
	      requestDispatcher.forward(request, response);
	    }
	}

