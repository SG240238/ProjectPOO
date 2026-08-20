import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistroEstudiantes{

    static Map<String, String> alumnos = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== UDB VIRTUAL =====");
            System.out.println("PROGRAMACIÓN ORIENTADA A OBJETOS");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Mostrar todos los alumnos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarAlumno();
                    break;

                case 2:
                    buscarAlumno();
                    break;

                case 3:
                    eliminarAlumno();
                    break;

                case 4:
                    mostrarTodos();
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    public static void ingresarAlumno() {

        System.out.print("Ingrese el carnet: ");
        String carnet = scanner.nextLine();

        System.out.print("Ingrese el nombre completo: ");
        String nombre = scanner.nextLine();

        if (alumnos.containsKey(carnet)) {
            System.out.println("El carnet ya se encuentra registrado.");
        } else {
            alumnos.put(carnet, nombre);
            System.out.println("Alumno ingresado exitosamente");
        }
    }

    public static void buscarAlumno() {

        System.out.print("Ingrese el carnet del alumno: ");
        String carnet = scanner.nextLine();

        if (alumnos.containsKey(carnet)) {
            System.out.println("Alumno encontrado:");
            System.out.println("Carnet: " + carnet);
            System.out.println("Nombre: " + alumnos.get(carnet));
        } else {
            System.out.println("Alumno no encontrado, no se puede Mostrar");
        }
    }

    public static void eliminarAlumno() {

        System.out.print("Ingrese el carnet del alumno: ");
        String carnet = scanner.nextLine();

        if (alumnos.containsKey(carnet)) {
            alumnos.remove(carnet);
            System.out.println("Alumno eliminado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado, No se puede Eliminar");
        }
    }

    public static void mostrarTodos() {

        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE ALUMNOS =====");

        for (Map.Entry<String, String> alumno : alumnos.entrySet()) {
            System.out.println("Carnet: " + alumno.getKey());
            System.out.println("Nombre: " + alumno.getValue());
            System.out.println("----------------------------");
        }
    }
}