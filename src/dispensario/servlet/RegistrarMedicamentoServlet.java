package dispensario.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ESTÁNDAR DE CODIFICACIÓN: PATRÓN CONTROLADOR (MVC)
 * Nombre: RegistrarMedicamentoServlet
 * Descripción: Controla la inserción de nuevos medicamentos en el sistema.
 * @author Mariana Contreras Gil
 */
@WebServlet("/RegistrarMedicamentoServlet")
public class RegistrarMedicamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        // RECEPCIÓN DE DATOS DESDE LA VISTA JSP
        String nombre = request.getParameter("nombre");
        String laboratorio = request.getParameter("laboratorio");
        String cantidadStr = request.getParameter("cantidad");

        // VALIDACIÓN DE CAMPOS SEGÚN ARTEFACTOS DE REQUISITOS
        if (nombre == null || nombre.trim().isEmpty() || cantidadStr == null) {
            response.sendRedirect("registro.jsp?error=campos_vacios");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            
            // SIMULACIÓN DE PERSISTENCIA (FRAMEWORK ORM LOGIC)
            System.out.println("[ORM-LOG] Guardando medicamento en la BD...");
            System.out.println("Medicamento: " + nombre + " | Cantidad: " + cantidad);

            response.sendRedirect("registro.jsp?success=true");
            
        } catch (NumberFormatException e) {
            response.sendRedirect("registro.jsp?error=cantidad_invalida");
        }
    }
}

