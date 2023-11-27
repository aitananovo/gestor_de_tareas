import java.util.ArrayList;
import java.util.Scanner;

public class Tarea {
    private int id;
    private String titulo;

    public Tarea(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}

class GestorDeTareas {
    private ArrayList<Tarea> listaTareas;

    public GestorDeTareas() {
        listaTareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
        System.out.println("Tarea agregada con éxito.");
    }

    public void listarTareas() {
        System.out.println("Lista de tareas:");
        for (Tarea tarea : listaTareas) {
            System.out.println(tarea.getId() + ". " + tarea.getTitulo());
        }
    }

    public void eliminarTarea(int id) {
        for (int i = 0; i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getId() == id) {
                listaTareas.remove(i);
                System.out.println("Tarea eliminada con éxito.");
                return;
            }
        }
        System.out.println("No se encontró una tarea con ese ID.");
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDeTareas gestor = new GestorDeTareas();

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID de la tarea: ");
                    int id = scanner.nextInt();
                    System.out.print("Ingrese el título de la tarea: ");
                    scanner.nextLine(); 
                    String titulo = scanner.nextLine();
                    Tarea nuevaTarea = new Tarea(id, titulo);
                    gestor.agregarTarea(nuevaTarea);
                    break;

                case 2:
                    gestor.listarTareas();
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la tarea a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    gestor.eliminarTarea(idEliminar);
                    break;

                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
