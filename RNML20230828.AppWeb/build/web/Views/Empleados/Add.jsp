<%-- 
    Document   : Add
    Created on : 28 ago. 2023, 10:48:42
    Author     : MINEDUCYT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Empleado</title>
    </head>
    <body>
        <h1>Agregar Empleado</h1>
         <form action="Empleados" method="post">
             <input type="hidden" name="action" value="Add">
            Nombre: <input type="text" name="nombre" required><br>
            Apellido: <input type="text" name="apellido"  required><br>
           Email: <input type="text" name="email"  required><br>
           PuestoEmpleado: <input type="text" name="puestoempleado"  required><br>
            <input type="submit" value="Agregar ">
        </form>
        <br>
                              <a href="Empleados">Lista de Empleados</a>

    </body>
</html>
