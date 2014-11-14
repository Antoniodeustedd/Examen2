<%@page import="java.util.ArrayList"%>
<%@page import="es.concesionario.modelo.Vehiculo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 {
    width: 100%;    
    background-color: #f1f1c1;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar vehículos</title>
</head>
<body>
<% ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo> )request.getAttribute("listado"); %>
<table style="width:100%">
    <tr>
      <th>Id</th>
      <th>Matricula</th>
      <th>Marca</th> 
      <th>Modelo</th>
      <th>Color</th>
      <th>Número de caballos</th>
      <th>Marchas</th> 
    </tr>
  <% for(Vehiculo vehiculo: vehiculos){ %>  
   <tr>
      <td><%=vehiculo.getId() %></td>
      <td><%=vehiculo.getMatricula() %></td>
      <td><%=vehiculo.getMarca() %></td>
      <td><%=vehiculo.getModelo() %></td>
      <td><%=vehiculo.getColor() %></td>
      <td><%=vehiculo.getcaballos() %></td>
      <td><%=vehiculo.isMarchas() %></td>
  </tr>
  <%}// del for %>
</table>
 <p><a href="index.html"  >Página principal</a></p>
</body>
</html>
