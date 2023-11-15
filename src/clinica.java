import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class clinica {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String filePath = "C:\\proyects\\untitled\\src\\Texto.txt";
            Mascota pet = new Mascota();
            clinica obj = new clinica();
            List<Veterinario> veterinarios = new ArrayList<>();
            List<Examen> examenes = new ArrayList<>();
            List<Medicamento> medicamentos = new ArrayList<>();
            List<Propietario> propietarios = new ArrayList<>();


                    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(":");
                            String clase = data[0];

                            switch (clase) {
                                case "Mascota":
                                    Mascota mascota = new Mascota(data[1],data[3],data[2],Integer.parseInt(data[4]),data[5],Integer.parseInt(data[6]),Double.parseDouble(data[7]),Long.parseLong(data[8]),data[9]);
                                    pet.lstMascotas.add(mascota);
                                    break;

                                case "Veterinario":
                                    Veterinario veterinario = new Veterinario(data[1], data[2], data[3]);
                                    veterinarios.add(veterinario);
                                    break;

                                case "Examen":
                                    Examen examen = new Examen(data[1], Integer.parseInt(data[2]));
                                    examenes.add(examen);
                                    break;

                                case "Medicamento":
                                    Medicamento medicamento = new Medicamento(data[1], Integer.parseInt(data[2]));
                                    medicamentos.add(medicamento);
                                    break;

                                case "Propietario":
                                    Propietario propietario = new Propietario(Long.parseLong(data[1]), data[2], data[3], data[4],
                                            Long.parseLong(data[5]));
                                    propietarios.add(propietario);
                                    break;

                                default:
                                    // Tratar otros casos si es necesario
                                    break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            obj.menu();
            int opc = sc.nextInt();

            switch (opc){
                case 1:
                    int pos = pet.listaMascota();
                    pet.getMascota(pos);

                    //---------------------------------------

                    // DIAGNOSTICO

                    // EXAMENES

                    // TRATAMIENTO

                    // GENERAR FACTURA

                    // generar historial
                break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
            }

        } // main

        public void menu(){
            System.out.println("Bienvenido a la veterinaria");
            System.out.println("1. Crear cita.");
            System.out.println("2. Ver reporte.");
            System.out.println("3. Salir.");
        }






        } // class




