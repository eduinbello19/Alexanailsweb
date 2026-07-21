package servlet;

import controller.CitaController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cita;

import java.io.IOException;
import java.util.ArrayList;

// Diferencias entre CitaView y CitasServlet:
//
// 1. CitaView pertenece a una aplicación de escritorio, mientras que
//    CitasServlet pertenece a una aplicación web.
//
// 2. CitaView interactúa con el usuario mediante ventanas emergentes
//    (JOptionPane), mientras que CitasServlet recibe solicitudes
//    desde un navegador web.
//
// 3. CitaView se ejecuta desde el metodo main(), mientras que
//    CitasServlet es ejecutado automáticamente por el servidor Tomcat
//    cuando se accede a la URL correspondiente.
//
// 4. CitaView solicita y muestra la información directamente al usuario,
//    mientras que CitasServlet procesa las peticiones HTTP y envía la
//    información a páginas JSP o HTML para su visualización.
//
// 5. Ambos utilizan el mismo CitaController para realizar las operaciones
//    CRUD sobre la base de datos, cambiando únicamente la forma en que
//    el usuario interactúa con la aplicación.
//
// 6. CitaView es útil para pruebas y aplicaciones de escritorio;
//    CitasServlet está diseñado para aplicaciones web accesibles desde
//    cualquier navegador.


@WebServlet("/citas")
public class CitasServlet extends HttpServlet
{
    private CitaController citaController = new CitaController();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {
        String accion = request.getParameter("accion");

        if (accion == null)
        {
            accion = "listar";
        }

        switch (accion)
        {
            case "nuevo":
                mostrarFormulario(request, response);
                break;

            case "eliminar":
                eliminarCita(request, response);
                break;

            case "listar":
            default:
                listarCitas(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String estado = request.getParameter("estado");

        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        int id_servicio = Integer.parseInt(request.getParameter("id_servicio"));

        Cita cita = new Cita(
                0,
                fecha,
                hora,
                estado,
                id_cliente,
                id_empleado,
                id_servicio
        );

        citaController.agregar(cita);

        response.sendRedirect("citas");
    }

    private void listarCitas(HttpServletRequest request,
                             HttpServletResponse response)
            throws ServletException, IOException
    {
        ArrayList<Cita> listaCitas = citaController.mostrar();

        request.setAttribute("listaCitas", listaCitas);

        request.getRequestDispatcher("/citas/listar.jsp")
                .forward(request, response);
    }

    private void mostrarFormulario(HttpServletRequest request,
                                   HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/citas/formulario.jsp")
                .forward(request, response);
    }

    private void eliminarCita(HttpServletRequest request,
                              HttpServletResponse response)
            throws IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));

        citaController.eliminar(id);

        response.sendRedirect("citas");
    }
}