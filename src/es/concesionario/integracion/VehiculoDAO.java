package es.concesionario.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.concesionario.modelo.Vehiculo;


public class VehiculoDAO {
	
	private Connection cx;
	   
    private void conectar() {
      try {
           Class.forName("com.mysql.jdbc.Driver");
           cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario","root","root");
           cx.setAutoCommit(false);
       } catch (SQLException e) {
          
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
    }
    private void desconectar() {
        try {
           cx.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    
    }

	public int darAlta(Vehiculo vehiculo) {
		
		int idRetornar=0;
		
		try {
	        conectar();
            PreparedStatement ps = cx.prepareStatement("INSERT INTO VEHICULO VALUES(?,?,?,?,?,?,?)");
		    ps.setInt(1, 0);
		    ps.setString(2, vehiculo.getMatricula());
		    ps.setString(3, vehiculo.getMarca());
		    ps.setString(4, vehiculo.getModelo());
		    ps.setString(5, vehiculo.getColor());
		    ps.setInt(6, vehiculo.getcaballos());
		    ps.setBoolean(7, vehiculo.isMarchas());
	        int filasAfectadas =ps.executeUpdate();
            cx.commit();
        
            if(filasAfectadas>=1) { 
                idRetornar= ultimoId();
            }  
        desconectar();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		       
        return idRetornar;
	}
	
	
	
	public Vehiculo consultarUno(int id) {
		
		Vehiculo v= new Vehiculo();
		try {
		    conectar();
            PreparedStatement ps = cx.prepareStatement("SELECT * FROM VEHICULO WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();  
            if(rs.next()) {   
            	v.setId(rs.getInt("id"));
            	v.setMatricula(rs.getString("matricula"));
            	v.setMarca(rs.getString("marca"));
            	v.setModelo(rs.getString("modelo"));
            	v.setColor(rs.getString("color"));
            	v.setcaballos(rs.getInt("caballos"));
            	v.setMarchas(rs.getBoolean("marchas"));
                
             }
			
       
        	 desconectar();
        	 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return v;
	}
	
	    public ArrayList<Vehiculo> consultarTodos() {
		    ArrayList<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
		    try {
            
                conectar();
           
                PreparedStatement ps = cx.prepareStatement("SELECT * FROM VEHICULO");
           
                ResultSet consulta = ps.executeQuery();
                while(consulta.next()) {
                    Vehiculo v = new Vehiculo();
                    v.setId(consulta.getInt("id"));
                    v.setMatricula(consulta.getString("matricula"));
                    v.setMarca(consulta.getString("marca"));
                    v.setModelo(consulta.getString("modelo"));
                    v.setColor(consulta.getString("color"));
                    v.setcaballos(consulta.getInt("caballos"));
                    v.setMarchas(consulta.getBoolean("marchas"));
                                
                    vehiculos.add(v);
                }
            
            desconectar();
        } catch (SQLException e) {
             e.printStackTrace();
        }
        
        return vehiculos;
		
				
	}
	public int ultimoId() {
		int  idM=90;
		try {
	        conectar();
			PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM VEHICULO"); 
			ResultSet consulta = ps.executeQuery(); 
			
			if(consulta.next()) { 
				idM=consulta.getInt("ULTIMO");
			}
			
			desconectar();
		} catch (SQLException e) {
			  e.printStackTrace();
			
		}
		
		return idM;
	
}
	public ArrayList<Vehiculo> consultarMatricula(String matricula) {
		ArrayList<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
	       try {
	           conectar();
	           PreparedStatement ps = cx.prepareStatement("SELECT * FROM VEHICULO WHERE MATRICULA LIKE ?");
	           ps.setString(1, "%" + matricula +  "%");
	           ResultSet consulta = ps.executeQuery();
	            
	           while(consulta.next()) {
	               Vehiculo v = new Vehiculo();
	               v.setId(consulta.getInt("id"));
	               v.setMatricula(consulta.getString("matricula"));
	               v.setMarca(consulta.getString("marca"));
	               v.setModelo(consulta.getString("modelo"));
	               v.setColor(consulta.getString("color"));
	               v.setcaballos(consulta.getInt("numeroCaballos"));
	               v.setMarchas(consulta.getBoolean("marchas"));
	               vehiculos.add(v);
	            }
	           
	            desconectar();
	        } catch (SQLException e) {
	           
	            e.printStackTrace();
	        }
	        return vehiculos;
		
	}
	public int borrar(int id) {
		int filasAfectadas=0;
        try { 
            conectar();
            PreparedStatement ps= cx.prepareStatement("DELETE FROM VEHICULO WHERE ID =?");
            ps.setInt(1, id);
            filasAfectadas= ps.executeUpdate();
            cx.commit();
          
            desconectar();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
       return filasAfectadas;
		
	}
	public int actualizar(int id, String matricula, String marca,
			String modelo, String color, int caballos, boolean marchas) {
		int filasAfectadas=0;
        try { 
           
              conectar();
              PreparedStatement ps= cx.prepareStatement("UPDATE VEHICULO SET MATRICULA=?, MARCA=?, MODELO=?, COLOR=?, NUMEROCABALLOS=?, MARCHAS=? WHERE ID=?");
              ps.setString(1, matricula);
              ps.setString(2, marca);
              ps.setString(3, modelo);
              ps.setString(4, color);
              ps.setInt(5, caballos);
              ps.setBoolean(6, marchas);
              ps.setInt(7, id);
              
        
              filasAfectadas= ps.executeUpdate();
              
           
              cx.commit();
          
          
              desconectar();
        } catch (SQLException e) {
              e.printStackTrace();
        }
       return filasAfectadas;
	}
	
	}
