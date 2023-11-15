import java.util.Date;

public class Consulta {
        private Veterinario veterinario;
        private Mascota mascota;
        private Diagnostico diagnostico;
        private Examen examen;
        private Medicamento medicamento;
        private Tratamiento tratamiento;
        private Date fecha;


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
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

    public Consulta(Veterinario veterinario,Mascota mascota, Diagnostico diagnostico, Examen examen, Medicamento medicamento, Tratamiento tratamiento, Date fecha){
        this.veterinario = veterinario;
        this.diagnostico = diagnostico;
        this.mascota = mascota;
        this.fecha = fecha;
        this.tratamiento = tratamiento;
        this.examen = examen;
        this.medicamento = medicamento;
    }
public String toString(){
    return "Consulta de "+ mascota+ "atendido por "+veterinario+ "quien diagnosticó : "+diagnostico+ examen+tratamiento+medicamento+ "con fecha de:"+fecha;
}

//ok

