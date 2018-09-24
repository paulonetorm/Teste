package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.log.Log;

@WebServlet("/sistema")
public class SistemaTodoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String pront = null;
		String logicaReq = request.getParameter("logica");
		String comando = "Atividadeppi.comando" + logicaReq;
		try {
			Class<?> classe = Class.forName(comando);
			Log logica = (Log)classe.newInstance();

			pront = logica.execute(request, response);
		} catch (Exception e) {
			pront = "erro.jsp";
		}
		
		dispatcher = request.getRequestDispatcher(pront);
		dispatcher.forward(request, response);
	}
}