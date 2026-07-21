<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Cita"%>

<%
ArrayList<Cita> lista =
(ArrayList<Cita>)request.getAttribute("listaCitas");
%>

<!DOCTYPE html>

<html>

<head>

<title>Listado de Citas</title>

</head>

<body>

<h1>Listado de Citas</h1>

<a href="<%=request.getContextPath()%>/citas?accion=nuevo">
Nueva Cita
</a>

<br><br>

<table border="1">

<tr>

<th>ID</th>
<th>Fecha</th>
<th>Hora</th>
<th>Estado</th>
<th>Cliente</th>
<th>Empleado</th>
<th>Servicio</th>
<th>Acción</th>

</tr>

<%

if(lista!=null){

for(Cita cita:lista){

%>

<tr>

<td><%=cita.getId_cita()%></td>

<td><%=cita.getFecha()%></td>

<td><%=cita.getHora()%></td>

<td><%=cita.getEstado()%></td>

<td><%=cita.getId_cliente()%></td>

<td><%=cita.getId_empleado()%></td>

<td><%=cita.getId_servicio()%></td>

<td>

<a href="<%=request.getContextPath()%>/citas?accion=eliminar&id=<%=cita.getId_cita()%>">

Eliminar

</a>

</td>

</tr>

<%

}

}

%>

</table>

</body>

</html>