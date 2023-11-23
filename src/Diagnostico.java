import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Diagnostico {
    private String diagnostico;
    private Examen examen;
    private LocalDate fecha;

    List<Examen> lstExamenes = new ArrayList<>();

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String toString(){
        return "este fue el diagnostico: "+diagnostico+" se remiten los siguientes examenes: "+examen+fecha;
    }

}

