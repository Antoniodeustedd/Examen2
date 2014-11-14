package es.concesionario.modelo;

import java.util.ArrayList;

import es.concesionario.integracion.VehiculoDAO;


public class GestorVehiculos {
	
	private VehiculoDAO vehiculodao= new VehiculoDAO();

	public int darAlta(String matricula, String marca, String modelo,
			String color, int numeroCaballos, boolean marchas) {
		
		Vehiculo vehiculo= new Vehiculo(matricula, marca, modelo, color, numeroCaballos, marchas);
		int id= vehiculodao.darAlta(vehiculo);
		
				
		return id;
		
	}

	public Vehiculo consultarUno(int id) {
		Vehiculo vehiculo= vehiculodao.consultarUno(id);
				
		return vehiculo;
	}

	public ArrayList<Vehiculo> consultarTodos() {
		ArrayList<Vehiculo> vehiculos= vehiculodao.consultarTodos();

		return vehiculos;
	}

	public ArrayList<Vehiculo> consultarMatricula(String matricula) {
		ArrayList<Vehiculo> vehiculos= vehiculodao.consultarMatricula(matricula);
		
		return vehiculos;
	}

	public String borrar(int id) {
		String msg;
		
		int vehiculosBorrados= vehiculodao.borrar(id);
        if(vehiculosBorrados>=1) {
            msg="Se ha borrado " + vehiculosBorrados +" vehículo";
        }
        else {
              msg="Imposible borrar";
        }
       return msg;
		
	}

	public String actualizar(int id, String matricula, String marca,
			String modelo, String color, int numeroCaballos, boolean marchas) {
		
		String msg;
        
        int filas= vehiculodao.actualizar(id, matricula, marca, modelo, color, numeroCaballos, marchas);
        if(filas>=1) {
            msg="Se ha actualizado " + filas +" vehiculo";
        }
        else {
              msg="Imposible actualizar";
        }
       return msg;
		
	}
	
	public String noAlta() {
		String msg;
		
		msg= "No posible dar de alta: Matricula repetida";
		
		
		
		return msg;
	}
	

}
