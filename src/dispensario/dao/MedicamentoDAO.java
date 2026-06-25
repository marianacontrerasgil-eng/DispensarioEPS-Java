package dispensario.dao;

import dispensario.conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentoDAO {

    // 1. INSERCIÓN (Crear/Registrar medicamento)
    public boolean registrarMedicamento(String nombre, String laboratorio, int cantidad) {
        String sql = "INSERT INTO medicamentos (nombre_medicamento, laboratorio, cantidad_disponible, esta_disponible) VALUES (?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setString(2, laboratorio);
            ps.setInt(3, cantidad);
            ps.setBoolean(4, cantidad > 0);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTA (Leer/Verificar disponibilidad por Nombre)
    public String[] consultarDisponibilidad(String nombre) {
        String sql = "SELECT * FROM medicamentos WHERE nombre_medicamento LIKE ?";
        String[] datosMedicamento = null;

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, "%" + nombre + "%");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    datosMedicamento = new String[3];
                    datosMedicamento[0] = rs.getString("nombre_medicamento");
                    datosMedicamento[1] = rs.getString("laboratorio");
                    datosMedicamento[2] = String.valueOf(rs.getInt("cantidad_disponible"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
        return datosMedicamento;
    }
}
