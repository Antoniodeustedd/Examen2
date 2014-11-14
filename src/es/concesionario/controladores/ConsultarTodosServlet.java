package es.concesionario.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.GestorVehiculos;
import es.concesionario.modelo.Vehiculo;


@WebServlet("/ConsultarTodos")
public class ConsultarTodosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ConsultarTodosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GestorVehiculos gestor= new GestorVehiculos();
		ArrayList<Vehiculo> vehiculos= gestor.consultarTodos();
		
		request.setAttribute("listado", vehiculos);
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("mostrarTodos.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
