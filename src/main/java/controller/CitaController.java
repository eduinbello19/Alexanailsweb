package controller;

import connection.Conexion;
import model.Cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CitaController
{
    // Creación de la conexión
    private Conexion conexion = new Conexion();

    // Metodo agregar
    public boolean agregar(Cita cita)
    {
        Connection con = conexion.getConexion();

        String query = "INSERT INTO cita (fecha, hora, estado, id_cliente, id_empleado, id_servicio) VALUES (?,?,?,?,?,?)";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, cita.getFecha());
            pst.setString(2, cita.getHora());
            pst.setString(3, cita.getEstado());
            pst.setInt(4, cita.getId_cliente());
            pst.setInt(5, cita.getId_empleado());
            pst.setInt(6, cita.getId_servicio());

            return pst.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo eliminar
    public boolean eliminar(int id)
    {
        Connection con = conexion.getConexion();

        String query = "DELETE FROM cita WHERE id_cita = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            return pst.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo actualizar
    public boolean actualizar(Cita cita)
    {
        Connection con = conexion.getConexion();

        String query = "UPDATE cita SET fecha = ?, hora = ?, estado = ?, id_cliente = ?, id_empleado = ?, id_servicio = ? WHERE id_cita = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, cita.getFecha());
            pst.setString(2, cita.getHora());
            pst.setString(3, cita.getEstado());
            pst.setInt(4, cita.getId_cliente());
            pst.setInt(5, cita.getId_empleado());
            pst.setInt(6, cita.getId_servicio());
            pst.setInt(7, cita.getId_cita());

            return pst.executeUpdate() > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    // Metodo mostrar
    public ArrayList<Cita> mostrar()
    {
        ArrayList<Cita> listaCitas = new ArrayList<>();

        Connection con = conexion.getConexion();

        String query = "SELECT * FROM cita";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next())
            {
                Cita cita = new Cita(
                        rs.getInt("id_cita"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getString("estado"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_empleado"),
                        rs.getInt("id_servicio")
                );

                listaCitas.add(cita);

                System.out.println(
                        "Cita encontrada: " + cita.getId_cita()
                );
            }

            System.out.println(
                    "Cantidad de citas encontradas: "
                            + listaCitas.size()
            );

            rs.close();
            pst.close();
        }
        catch (SQLException e)
        {
            System.out.println(
                    "Error al consultar cita: " + e.getMessage()
            );

            e.printStackTrace();
        }

        return listaCitas;
    }
}
