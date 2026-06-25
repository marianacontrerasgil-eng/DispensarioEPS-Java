package dispensario.modelo;

public class Medicamento {
    private int id;
    private String nombreMedicamento;
    private String laboratorio;
    private int cantidadDisponible;
    private boolean estaDisponible;

    public Medicamento(int id, String nombreMedicamento, String laboratorio, int cantidadDisponible, boolean estaDisponible) {
        this.id = id;
        this.nombreMedicamento = nombreMedicamento;
        this.laboratorio = laboratorio;
        this.cantidadDisponible = cantidadDisponible;
        this.estaDisponible = estaDisponible;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreMedicamento() { return nombreMedicamento; }
    public void setNombreMedicamento(String nombreMedicamento) { this.nombreMedicamento = nombreMedicamento; }

    public String getLaboratorio() { return laboratorio; }
    public void setLaboratorio(String laboratorio) { this.laboratorio = laboratorio; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public boolean isEstaDisponible() { return estaDisponible; }
    public void setEstaDisponible(boolean estaDisponible) { this.estaDisponible = estaDisponible; }
}


   
