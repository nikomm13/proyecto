import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tratamiento {
    Scanner sc = new Scanner(System.in);
    public Medicamento medicamento;
    public int tiempo;
    public double dosis;

    List<Medicamento> lstMedicamentos = new ArrayList<>();
    ArrayList<Integer> lstTiempo = new ArrayList<Integer>();
    ArrayList<Integer> lstDosis = new ArrayList<Integer>();


    public Tratamiento(Medicamento medicamento, int tiempo, double dosis){
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.tiempo = tiempo;
    }
    public Tratamiento(){

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
    public String toString(){
        return "Se fórmulo: "+medicamento+" con la cantidad "+dosis+ "cada "+tiempo+"horas";
    }

}
