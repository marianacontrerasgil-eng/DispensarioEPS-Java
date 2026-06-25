package dispensario.main;

import dispensario.dao.MedicamentoDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Probando Conexión del Proyecto SENA ===");
        
        MedicamentoDAO buscador = new MedicamentoDAO();
        
        // Probamos el método de consulta
        String[] resultado = buscador.consultarDisponibilidad("Acetaminofén");

        if (resultado != null) {
            System.out.println("¡Conexión Exitosa con MySQL!");
            System.out.println("Medicamento: " + resultado[0]);
            System.out.println("Laboratorio: " + resultado[1]);
            System.out.println("Cantidad disponible en EPS: " + resultado[2]);
        } else {
            System.out.println("No se encontraron medicamentos o error de conexión.");
        }
    }
}
