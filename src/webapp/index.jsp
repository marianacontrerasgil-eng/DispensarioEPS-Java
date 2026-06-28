<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dispensario EPS - Consulta de Medicamentos</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f7f6; padding: 20px; display: flex; justify-content: center; }
        .contenedor { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); width: 400px; }
        h2 { color: #2c3e50; text-align: center; }
        .campo { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #34495e; }
        input[type="text"] { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background-color: #2ecc71; border: none; color: white; font-size: 16px; border-radius: 4px; cursor: pointer; font-weight: bold; }
        button:hover { background-color: #27ae60; }
        .resultado { margin-top: 20px; padding: 15px; border-radius: 4px; background-color: #e8f8f5; border: 1px solid #a3e4d7; }
    </style>
</head>
<body>

<div class="contenedor">
    <h2>Dispensario EPS 🏥</h2>
    <p style="text-align: center; color: #7f8c8d;">Evite filas. Consulte la disponibilidad de su orden médica aquí.</p>
    
    <!-- Formulario HTML que envía los datos mediante método POST al Servlet -->
    <form action="ConsultarMedicamentoServlet" method="POST">
        <div class="campo">
            <label for="nombre">Nombre del Medicamento:</label>
            <input type="text" id="nombre" name="nombreMedicamento" placeholder="Ej. Acetaminofén" required>
        </div>
        <button type="submit">Consultar Disponibilidad</button>
    </form>

    <%-- Elementos de JSP para mostrar el resultado si el Servlet nos devuelve datos --%>
    <% 
        String[] resultado = (String[]) request.getAttribute("resultadoMedicamento");
        if (resultado != null) {
    %>
        <div class="resultado">
            <h3>Resultado de la Búsqueda:</h3>
            <p><strong>Medicamento:</strong> <%= resultado[0] %></p>
            <p><strong>Laboratorio:</strong> <%= resultado[1] %></p>
            <p><strong>Cantidad en Inventario:</strong> <%= resultado[2] %> unidades</p>
            <p style="color: green; font-weight: bold;">¡Disponible para entrega a domicilio! 🚀</p>
        </div>
    <% 
        } else if (request.getAttribute("error") != null) {
    %>
        <div class="resultado" style="background-color: #fadbd8; border-color: #f5b7b1;">
            <p style="color: #c0392b; font-weight: bold;"><%= request.getAttribute("error") %></p>
        </div>
    <% 
        } 
    %>
</div>

</body>
</html>
