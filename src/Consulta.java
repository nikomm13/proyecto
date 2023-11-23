import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private Veterinario veterinario; //-
    private Mascota mascota; //-
    private Diagnostico diagnostico; //-
    private Examen examen;
    private Tratamiento tratamiento;
    private LocalDate fecha;

    public Consulta(Veterinario veterinario, Mascota mascota, Diagnostico diagnostico, Examen examen, Tratamiento tratamiento, LocalDate fecha){
        this.veterinario = veterinario;
        this.mascota = mascota;
        this.diagnostico = diagnostico;
        this.examen = examen;
        this.tratamiento = tratamiento;
        this.fecha = fecha;
    }
    List<Veterinario> lstVeterinarios = new ArrayList<>();
    List<Examen> lstExamenes = new ArrayList<>();

    public Consulta(){
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }


    public String toString() {
        return "Consulta de " + mascota + "atendido por " + veterinario + "quien diagnosticó : " + diagnostico + examen + tratamiento + "con fecha de:" + fecha + ". ";
    }

}

