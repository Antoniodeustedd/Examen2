package es.concesionario.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.concesionario.modelo.GestorVehiculos;
@WebServlet("/Procesar")
public class ProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProcesarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		String matricula= request.getParameter("matricula");
		String marca= request.getParameter("marca");
		String modelo= request.getParameter("modelo");
		String color= request.getParameter("color");
		int numeroCaballos= Integer.parseInt(request.getParameter("caballos"));
		boolean marchas= Boolean.parseBoolean(request.getParameter("marchas"));
		String borrar= request.getParameter("borrar");
	    String actualizar=request.getParameter("actualizar");
	    
	    GestorVehiculos gestor = new GestorVehiculos();
	    
	    String act = ""; 
	       
	    
	     if(borrar!=null) {
		     act= gestor.borrar(id);
		     
		
	      }
	     if(actualizar!=null) {
	         act= gestor.actualizar(id, matricula, marca, modelo, color, numeroCaballos, marchas);
	     }
		 request.setAttribute("mensaje",act);
	   
	     RequestDispatcher rd= request.getRequestDispatcher("vistaMensaje.jsp");
	     rd.forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
