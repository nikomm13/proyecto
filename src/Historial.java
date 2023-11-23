import java.util.ArrayList;
import java.util.List;

public class Historial {
    public Consulta consulta;
    List<Consulta> lstConsulta;

    public void setConsulta(Consulta consulta){
        this.consulta = consulta;
    }
    public Historial() {
        lstConsulta = new ArrayList<Consulta>();
    }
    public List<Consulta> getConsultas() {
        return lstConsulta;
    }
    public void agregarConsulta(Consulta consulta) {
        lstConsulta.add(consulta);
    }
}

