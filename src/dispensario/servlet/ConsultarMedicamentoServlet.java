package dispensario.servlet;

import dispensario.dao.MedicamentoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Esta anotación le dice a la página web dónde encontrar este Servlet
@WebServlet("/ConsultarMedicamentoServlet")
public class ConsultarMedicamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // La guía nos pide explícitamente usar métodos GET y POST
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Si entran por GET, los redirigimos al formulario principal
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recibimos el parámetro de la cajita de texto del HTML
        String nombreMed = request.getParameter("nombreMedicamento");
        
        MedicamentoDAO dao = new MedicamentoDAO();
        
        // 2. Buscamos en la base de datos de MySQL Workbench
        String[] resultado = dao.consultarDisponibilidad(nombreMed);
        
        // 3. Evaluamos si encontramos el medicamento o no
        if (resultado != null) {
            // Pasamos los datos encontrados a la página JSP
            request.setAttribute("resultadoMedicamento", resultado);
        } else {
            // Pasamos un mensaje de error si no hay existencias en la EPS
            request.setAttribute("error", "Lo sentimos, el medicamento '" + nombreMed + "' no se encuentra disponible en este dispensario.");
        }
        
        // 4. Recargamos la página index.jsp para mostrar los resultados en pantalla
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
