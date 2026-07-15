<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar cliente</title>
</head>
<body>

<h1>Registrar cliente</h1>

<form action="<%= request.getContextPath() %>/clientes"
      method="post">

    <input type="hidden"
           name="accion"
           value="guardar">

    <label for="nombre">Nombre:</label>
    <input type="text"
           id="nombre"
           name="nombre"
           required>

    <br><br>

    <label for="documento">Documento:</label>
    <input type="text"
           id="documento"
           name="documento"
           required>

    <br><br>

    <label for="telefono">Teléfono:</label>
    <input type="text"
           id="telefono"
           name="telefono"
           required>

    <br><br>

    <label for="direccion">Dirección:</label>
    <input type="text"
           id="direccion"
           name="direccion"
           required>

    <br><br>

    <label for="correo">Correo:</label>
    <input type="email"
           id="correo"
           name="correo"
           required>

    <br><br>

    <button type="submit">
        Guardar
    </button>

    <a href="<%= request.getContextPath() %>/clientes">
        Cancelar
    </a>

</form>

</body>
</html>