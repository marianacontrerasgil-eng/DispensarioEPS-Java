package dispensario.servlet;

import dispensario.dao.MedicamentoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ConsultarMedicamentoServlet")
public class ConsultarMedicamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        String nombreMed = request.getParameter("nombreMedicamento");
        
        MedicamentoDAO dao = new MedicamentoDAO();
        
        
        String[] resultado = dao.consultarDisponibilidad(nombreMed);
        
        
        if (resultado != null) {
            
            request.setAttribute("resultadoMedicamento", resultado);
        } else {
            
            request.setAttribute("error", "Lo sentimos, el medicamento '" + nombreMed + "' no se encuentra disponible en este dispensario.");
        }
        
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
