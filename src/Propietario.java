public class Propietario {
    public long id;
    public String nombre;
    public String mail;
    public String direccion;
    public long telefono;

    public Propietario(long id, String nombre, String direccion, String mail, long telefono){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
    }
}
