package es.concesionario.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.GestorVehiculos;
import es.concesionario.modelo.Vehiculo;

@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registro() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricula= request.getParameter("matricula");
		String marca= request.getParameter("marca");
		String modelo= request.getParameter("modelo");
		String color= request.getParameter("color");
		int caballos= Integer.parseInt(request.getParameter("caballos"));
		boolean marchas= Boolean.parseBoolean(request.getParameter("marchas"));
		GestorVehiculos gestor= new GestorVehiculos();
		int id= gestor.darAlta(matricula, marca, modelo, color, caballos, marchas);
		
		String respuesta;
		if (id==0){
			respuesta= gestor.noAlta();
			
			request.setAttribute("mensaje",respuesta);
			RequestDispatcher rd= request.getRequestDispatcher("vistaMensaje.jsp");
		    rd.forward(request, response);
		}
		
		Vehiculo v= gestor.consultarUno(id);
		request.setAttribute("vehiculo", v);
		RequestDispatcher rd;
	    rd= request.getRequestDispatcher("vistaIndividual.jsp");
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
