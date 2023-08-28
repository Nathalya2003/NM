package rnml20230828.appweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rnml20230828.accesoadatos.EmpleadosDAL;
import rnml20230828.entidades.Empleados;


@WebServlet(name = "EmpleadosServlet", urlPatterns = {"/Empleados"})
public class EmpleadosServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        //Si queremos agregar dirigimos a la vista de agregar libro
        if ("Add".equals(action)) {
            // QUIERO QUE ME REDIRIGA A LA VISTA DE AGREGAR NUEVO LIBRO
            request.getRequestDispatcher("Views/Empleados/Add.jsp").forward(request, response);
        } else if ("Edit".equals(action)) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            try {
                Empleados Empleados = EmpleadosDAL.obtenerEmpleadosPorId(Id);
                request.setAttribute("empleado", Empleados);
                request.getRequestDispatcher("Views/Empleados/Edit.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(EmpleadosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  else {
            try {
                // Aca se obtiene los libros
                List<Empleados> Empleados = EmpleadosDAL.listarEmpleados();
                request.setAttribute("emplealos", Empleados);

                request.getRequestDispatcher("Views/Empleados/Listar.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(EmpleadosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("Add".equals(action)) {

            String Nombre = request.getParameter("nombre");
            String Apellido = request.getParameter("apellido");
            String Email = request.getParameter("email");
            String PuestoEmpleado = request.getParameter("puestoempleado");
            
            Empleados nuevoEmpleado = new Empleados(0, Nombre, Apellido,Email, PuestoEmpleado);

            try {
                int result = EmpleadosDAL.agregarEmpleados(nuevoEmpleado);

                if (result > 0) {
                    response.sendRedirect("Empleados");
                }

            } catch (SQLException e) {

                e.printStackTrace();
                response.getWriter().println("An error occurred.");
            }
        }
        else if ("Edit".equals(action)) {
          int Id = Integer.parseInt(request.getParameter("id"));
            String Nombre = request.getParameter("nombre");
            String Apellido = request.getParameter("apellido");
            String Email = request.getParameter("email");
            String PuestoEmpleado = request.getParameter("puestoempleado");
          

            Empleados Actualizar = new Empleados(Id, Nombre, Apellido,Email, PuestoEmpleado);


            try {
                int result = EmpleadosDAL.editarEmpleados(Actualizar);
                if (result > 0) {
                    response.sendRedirect("Empleados");
                }
            } catch (SQLException e) {

                e.printStackTrace();
                response.getWriter().println("An error occurred.");
            }
        }
    }// </editor-fold>

}
