import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private long id;
    private String nombre;
    private String mail;
    private String direccion;
    private long telefono;

    public Propietario(){

    }
    List<Propietario> lstPropietarios = new ArrayList<>();
    public Propietario(long id, String nombre, String direccion, String mail, long telefono){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
    }

    public Propietario getMascota(int pos){
        return lstPropietarios.get(pos);
    }

    public void setMascota(Propietario objP){
        lstPropietarios.add(objP);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}
