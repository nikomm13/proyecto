import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Examen {
    Scanner sc = new Scanner(System.in);
    private String nombre;
    public int precio;

    List<Examen> lstExamenes = new ArrayList<>();

    public Examen(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public Examen() {
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }
    public int getPrecio(){
        return precio;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public Examen getExamenes(int pos) {
        return lstExamenes.get(pos);
    }

    public void setExamenes(Examen objE) {
        lstExamenes.add(objE);
    }

    public int listaExamenes() {
        for (int i = 0; i < lstExamenes.size(); i++) {
            System.out.println(i + " " + lstExamenes.get(i).getNombre());
        }
        int op;
        op = Integer.parseInt(sc.nextLine());
        if (op < 0 || op >= lstExamenes.size()) {
            return listaExamenes();
        }
        return op;
    }
    public String toString() {
        return "Examen: " + nombre + " " + precio;
    }

}
