package servlet;

import constant.UrlConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.RequestDispatcher.ERROR_EXCEPTION;

@WebServlet(name = "ErrorHandlerServlet", urlPatterns = "/error")
public class ErrorHandlerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		getServletContext().log(request.getAttribute(ERROR_EXCEPTION).toString());

		request.getRequestDispatcher(UrlConstants.ERROR_JSP).forward(request, response);
	}
}
