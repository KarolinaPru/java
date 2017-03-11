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
 * Servlet implementation class Calc_servlet
 */
@WebServlet(name = "calculator", description = "Calculator servlet", urlPatterns = { "/calculator" })
public class Calc_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calc_servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String base = "/";
		String url = base + "calculator.jsp";

		HttpSession session = request.getSession();
		Calculator calculator = (Calculator) session.getAttribute("calculator");
		
		if (calculator == null) {
			calculator = new Calculator();
			session.setAttribute("calculator", calculator);
			calculator.setValue("pusty");
		}

		if (request.getParameterMap().containsKey("btn")) {
			String s = request.getParameter("btn");
			if (s.contains("C"))
				calculator.setValue("0");
			else
				calculator.setBtn(s);
		}

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "properties":
				url = base + "properties.jsp";
				break;
			default:
				break;
			}
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}
}
