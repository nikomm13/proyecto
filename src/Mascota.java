import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mascota {
    Scanner sc = new Scanner(System.in);
    public List<Mascota> lstMascotas = new ArrayList<>();
    private String raza;
    private String nombre;
    private String especie;
    private int edad;
    private String genero;
    private double peso;
    private int altura;
    private long idPropietario;
    private String datoEspecifico;
    public Mascota(String nombre, String raza, String especie,  int edad,String genero,  int altura,double peso, long idPropietario, String datoEspecifico) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.edad = edad;
        this.peso = peso;
        this.idPropietario = idPropietario;
        this.datoEspecifico = datoEspecifico;
    }
    public Mascota(){

    }
    public Mascota getMascota(int pos){
        return lstMascotas.get(pos);
    }

    public void setMascota(Mascota objM){
        lstMascotas.add(objM);
    }


    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getDatoEspecifico() {
        return datoEspecifico;
    }

    public void setDatoEspecifico(String datoEspecifico) {
        this.datoEspecifico = datoEspecifico;
    }

    public int listaMascota(){
        for (int i = 0; i < lstMascotas.size(); i ++){
            System.out.println(i + " " + lstMascotas.get(i).getNombre());
        }
        int op;
        op = Integer.parseInt(sc.nextLine());
        if (op < 0 || op>= lstMascotas.size()){
            return listaMascota();
        }
        return op;
    }
    public String toString(){
        return "mascota:{"+ nombre + especie + raza + genero +edad+ peso +altura+ idPropietario + datoEspecifico+"}";
    }

    public void setAltura(int altura) {

        this.altura = altura;
    }
}
