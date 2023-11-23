import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Veterinario {
    Scanner sc = new Scanner(System.in);
    protected String nombre;
    protected String especialidad;
    protected String codigo;

    public List<Veterinario> lstVeterinarios = new ArrayList<>();
    public Veterinario(String nombre, String especialidad, String codigo){
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.codigo = codigo;
    }
    public boolean equals(Object obj) {
        // Si el objeto es nulo o no es de la clase Veterinario, devolver false
        if (obj == null || !(obj instanceof Veterinario)) {
            return false;
        }
        // Si el objeto es el mismo que el que llama al método, devolver true
        if (obj == this) {
            return true;
        }
        // Si el objeto es de la clase Veterinario, comparar el atributo nombre
        Veterinario otro = (Veterinario) obj;
        return this.nombre.equals(otro.nombre);
    }

    public int listaVeterinarios(){
        for (int i = 0; i < lstVeterinarios.size(); i ++){
            System.out.println(i + " " + lstVeterinarios.get(i).getNombre());
        }
        int op;
        op = Integer.parseInt(sc.nextLine());
        if (op < 0 || op>= lstVeterinarios.size()){
            return listaVeterinarios();
        }
        return op;
    }

    public String getNombre() {
        return nombre;
    }
    public Veterinario(){

    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public Veterinario getVeterinario(int pos2){

        return lstVeterinarios.get(pos2);
    }

    public void setVeterinario(Veterinario objV){
        lstVeterinarios.add(objV);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String toString(){
        return nombre+especialidad+codigo;
    }

}

