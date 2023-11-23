import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Medicamento {
    Scanner sc = new Scanner(System.in);
    protected String nombre;
    protected int costo;
    List<Medicamento> lstMedicamentos = new ArrayList<>();
    public Medicamento(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }
    public Medicamento(){

    }
    public Medicamento getMedicamento(int pos){
        return lstMedicamentos.get(pos);
    }

    public void setMedicamento(Medicamento objM){
        lstMedicamentos.add(objM);
    }

    public int listaMedicamentos(){
        for (int i = 0; i < lstMedicamentos.size(); i ++){
            System.out.println(i + " " + lstMedicamentos.get(i).getNombre());
        }
        int op;
        op =   Integer.parseInt(sc.nextLine());
        if (op < 0 || op>= lstMedicamentos.size()){
            return listaMedicamentos();
        }
        return op;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String toString(){
        return "Medicamento: "+nombre+costo;
    }
}
