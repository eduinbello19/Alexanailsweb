<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Cita</title>
</head>
<body>

<h1>Registrar Cita</h1>

<form action="<%=request.getContextPath()%>/citas"
      method="post">

    <label>Fecha:</label>
    <input type="date"
           name="fecha"
           required>

    <br><br>

    <label>Hora:</label>
    <input type="time"
           name="hora"
           required>

    <br><br>

    <label>Estado:</label>
    <input type="text"
           name="estado"
           required>

    <br><br>

    <label>ID Cliente:</label>
    <input type="number"
           name="id_cliente"
           required>

    <br><br>

    <label>ID Empleado:</label>
    <input type="number"
           name="id_empleado"
           required>

    <br><br>

    <label>ID Servicio:</label>
    <input type="number"
           name="id_servicio"
           required>

    <br><br>

    <button type="submit">
        Guardar
    </button>

</form>

</body>
</html>