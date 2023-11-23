import javax.print.attribute.standard.PrinterMoreInfoManufacturer;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class clinica {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //Texto
            String filePath = "C:\\proyects\\untitled\\src\\Texto.txt";
            // clases con las que se interactua
            Mascota pet = new Mascota();
            clinica obj = new clinica();
            Veterinario vet = new Veterinario();
            Propietario prop = new Propietario();
            Diagnostico diag = new Diagnostico();
            Medicamento med = new Medicamento();
            Examen exa = new Examen();
            Consulta con = new Consulta();
            Tratamiento trat = new Tratamiento();
            Historial historial = new Historial();

            //-------------------------------------------------------------
            List<Veterinario> veterinarios = new ArrayList<>();
            List<Mascota> mascotasElegidas = new ArrayList<>();
            List<Examen> examenes = new ArrayList<>();
            Map<Veterinario, Integer> mapa = new HashMap<>();

                    //Creacion de texto
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
                                    vet.lstVeterinarios.add(veterinario);
                                    break;

                                case "Examen":
                                    Examen examen = new Examen(data[1], Integer.parseInt(data[2]));
                                    exa.lstExamenes.add(examen);
                                    break;

                                case "Medicamento":
                                    Medicamento medicamento = new Medicamento(data[1], Integer.parseInt(data[2]));
                                    med.lstMedicamentos.add(medicamento);
                                    break;

                                case "Propietario":
                                    Propietario propietario = new Propietario(Long.parseLong(data[1]), data[2], data[3], data[4],
                                            Long.parseLong(data[5]));
                                    prop.lstPropietarios.add(propietario);
                                    break;

                                default:
                                    // Tratar otros casos si es necesario
                                    break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            int opcion;
            do {
                obj.menu();

                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        //creando consulta -----------------------------------------------------------------------
                        System.out.println("Elija a su mascota: ");
                        int pos = pet.listaMascota(); // Imprimir las mascotas que existen (ubicado en clase mascota)
                         // esto es para mandarlo a la consulta
                        mascotasElegidas.add(pet.getMascota(pos));
                        //------------------------------------------------------------------------------------
                        System.out.println("Elija un veterinario");
                        int pos2 = vet.listaVeterinarios();  // imprimir veterinarios que existen (ubicado en clase veterinario)
                         // esto es para mandarlo a la consulta
                        //------------------------------------------------------------------------------------
                        Diagnostico diag1 = new Diagnostico();
                        System.out.println();
                        System.out.println("Ingrese el diagnostico: ");
                        String diagnostico = sc.nextLine(); // el diagnostico del medico
                        diag1.setDiagnostico(diagnostico);

                        int numMed; // muestra la opccion del medicamento
                        int mas; // muestra la opcion cuando quiere mas medicamento

                        obj.menuMedicamentos();
                        numMed = Integer.parseInt(sc.nextLine());
                        Tratamiento trat1 = new Tratamiento();

                        if (numMed == 1) {
                            do {
                                System.out.println("Elija un medicamento: ");
                                int pos3 = med.listaMedicamentos();
                                trat1.lstMedicamentos.add(med.getMedicamento(pos3));
                                System.out.println("Dosis del medicamento");
                                int dosis = Integer.parseInt(sc.nextLine());
                                trat1.lstDosis.add(dosis);
                                System.out.println("Por cuanto tiempo: en semanas");
                                int tiempo = Integer.parseInt(sc.nextLine());
                                trat1.lstMedicamentos.add(med.getMedicamento(pos3));
                                System.out.println("Desea agregar mas medicamentos: ");
                                obj.menuMedicamentos();
                                mas = Integer.parseInt(sc.nextLine());
                            } while (mas != 2);
                        } else {

                            trat1.lstMedicamentos.add(new Medicamento("ninguno", 0));
                        }
                        //-------------------------------------------------------------------------------------
                        System.out.println();
                        System.out.println("Desea agregar examenes ?: ");

                        int numExam; // muestra la opccion del examen
                        int masExam; // muestra la opcion cuando quiere mas examenes

                        obj.menuExamenes();
                        numExam = Integer.parseInt(sc.nextLine());
                        Examen exa1 = new Examen();
                        if (numExam == 1) {
                            do {
                                System.out.println("Elija un Examen: ");
                                int pos4 = exa.listaExamenes();
                                diag1.lstExamenes.add(exa.getExamenes(pos4));
                                exa1.lstExamenes.add(exa.getExamenes(pos4));
                                System.out.println("Desea agregar mas examenes: ");
                                obj.menuExamenes();
                                mas = Integer.parseInt(sc.nextLine());
                            } while (mas != 2);
                        } else {
                            diag.lstExamenes.add(new Examen("ninguno", 0));
                        }
                        LocalDate dia = LocalDate.of(2023, 11, 23);
                        diag1.setFecha(dia);

                        Consulta consult1 = new Consulta(vet.getVeterinario(pos2),pet.getMascota(pos), diag1,exa1, trat1 ,dia );
                        historial.lstConsulta.add(consult1);

                        //factura
                        int totalFactura = 0;
                        int totalMedicamentos = 0;
                        int totalExamenes = 0;

                        //medicamentos
                        for (Medicamento m : trat1.lstMedicamentos) {
                            totalMedicamentos = totalMedicamentos + m.getCosto();
                        }
                        //examenes
                        for (Examen e : diag1.lstExamenes) {
                            totalExamenes = totalExamenes + e.getPrecio();
                        }
                        if ((totalFactura | totalExamenes) != 0) {
                            totalExamenes = totalExamenes + 10000;
                            totalMedicamentos = totalMedicamentos + 10000;
                        }

                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Aca está su factura: ");
                        System.out.println();
                        System.out.println("Medicamentos: " + totalMedicamentos + "$");
                        System.out.println("Examenes: " + totalExamenes + "$");
                        System.out.println("Consulta: 80000 $");
                        totalFactura = totalExamenes + totalMedicamentos + 80000;
                        System.out.println("Total factura: " + totalFactura + "$");
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Selecciona un reporte que quieras ver: ");
                        obj.menuReporte();
                        int op2 = Integer.parseInt(sc.nextLine());
                        switch (op2) {
                            case 1: // Cantidad de mascotas atendidas hasta el momento, porcentaje perros y gatos
                                int cantMascotas = mascotasElegidas.size();
                                double canPerro = 0;
                                double canGato = 0;

                                for (Mascota masc : mascotasElegidas) {
                                    String especie = masc.getEspecie();
                                    if (especie.equals("Perro")) {
                                        canPerro = +1;
                                    } else {
                                        canGato = +1;
                                    }
                                }
                                canPerro = (canPerro * 100) / cantMascotas;
                                canGato = (canGato * 100) / cantMascotas;
                                System.out.println("Cantidad de mascotas: " + cantMascotas);
                                System.out.println("porcentaje de Perros: " + canPerro + "%");
                                System.out.println("porcentaje de Gatos: " + canGato + "%");
                                System.out.println();
                                break;

                            case 2:

                                for (Consulta consulta : historial.getConsultas()) {
                                    // Obtener el veterinario y la mascota de la consulta
                                    Veterinario veterinario = consulta.getVeterinario();
                                    Mascota mascota = consulta.getMascota();

                                    // Si el mapa ya contiene al veterinario, incrementar su contador en uno
                                    if (mapa.containsKey(veterinario)) {
                                        mapa.put(veterinario, mapa.get(veterinario) + 1);
                                    }
                                    // Si el mapa no contiene al veterinario, agregarlo al mapa con el contador en uno
                                    else {
                                        mapa.put(veterinario, 1);
                                    }
                                }
                                // Mostrar el contenido del mapa para ver el registro de cada veterinario
                                for (Map.Entry<Veterinario, Integer> entrada : mapa.entrySet()) {
                                    System.out.println(entrada.getKey().getNombre() + " ha atendido a " + entrada.getValue() + " mascotas.");
                                }

                                break;


                                case 3: // Medicamento mas suministrado y la cantidad de veces suministrada.

                                    break;

                            case 4: // Paciente mas recurrente.

                                break;
                            case 5: // salir
                                System.exit(0);
                            default:
                                throw new IllegalStateException("Unexpected value: " + opcion);
                        }
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        throw new IllegalStateException("Unexpected value: " + opcion);
                }
            }while (opcion != 3);

        } // main

        public void menu(){
            System.out.println("Bienvenido a la veterinaria");
            System.out.println("1. Crear cita.");
            System.out.println("2. Ver reporte.");
            System.out.println("3. Salir.");
        }
        public void menuMedicamentos(){
            System.out.println("Medicamentos");
            System.out.println("1. SI. ");
            System.out.println("2. NO. ");
        }
    public void menuExamenes(){
        System.out.println("Examenes");
        System.out.println("1. SI. ");
        System.out.println("2. NO. ");
    }

    public void menuReporte(){
        System.out.println("1. Cantidad de mascotas atendidas hasta el momento, porcentaje perros y gatos.");
        System.out.println("2. Cantidad de mascotas atendidas por cada veterinario.");
        System.out.println("3. Medicamento mas suministrado y la cantidad de veces suministrada.");
        System.out.println("4. Paciente mas recurrente.");
        System.out.println("5. Salir. ");
    }

        } // class




