package com.dispensario.controller;

import com.dispensario.modelo.Medicamento;
import com.dispensario.dao.MedicamentoDAO;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
@CrossOrigin(origins = "*") // Conector CORS seguro para que tu Frontend en React consuma los datos
public class MedicamentoController {

    private MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

    // Endpoint REST de Spring Boot para Consultar Inventario
    @GetMapping("/medicamentos")
    public List<Medicamento> consultarMedicamentos(@RequestParam(required = false) String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            return medicamentoDAO.buscarPorNombre(nombre); 
        }
        return medicamentoDAO.listarTodos(); 
    }

    // Endpoint REST de Spring Boot para Registrar Medicamento en el stock
    @PostMapping("/medicamentos/registrar")
    public String registrarMedicamento(@RequestBody Medicamento medicamento) {
        boolean registrado = medicamentoDAO.registrar(medicamento);
        if (registrado) {
            return "{\"status\": \"success\", \"message\": \"Medicamento indexado en Spring Boot de forma limpia\"}";
        }
        return "{\"status\": \"error\", \"message\": \"Error al procesar el registro del insumo\"}";
    }
}
