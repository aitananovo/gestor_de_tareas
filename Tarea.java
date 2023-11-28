import java.util.ArrayList;
import java.util.Scanner;

public class Tarea {
    private int id;
    private String titulo;
    private Prioridad prioridad;

    private String comentario;

    public Tarea(int id, String titulo, String comentario, Prioridad prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.comentario = comentario;
        this.prioridad = prioridad;
    }
    public enum Prioridad{
            BAJA,
            MEDIA,
            ALTA
        }

    public void setPrioridad(Prioridad prioridad){
        this.prioridad = prioridad;
    }
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Prioridad getPrioridad(){
        return prioridad;
    }

    public String getComentario(){
        return comentario;
    }

    public void nuevoComentario(String newComentario){
        comentario = newComentario;
    }

    public void modificacionComentario(String newComentario){
        comentario = comentario+","+newComentario;
    }

    public void eliminaComentario(){
        comentario = "";
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
            System.out.println(tarea.getId() + ". " + tarea.getTitulo()+": "+tarea.getComentario() + " - Prioridad: " + tarea.getPrioridad());
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

    public void agregarTarea(Tarea tarea, Tarea.Prioridad prioridad) {
         tarea.setPrioridad(prioridad);
         listaTareas.add(tarea);
         System.out.println("Tarea agregada con éxito.");
    }

    public void añadirComentario(int id, Scanner scanner){
        System.out.println("Introduzca el comentario que quieras añadir a la tarea.");
        String comentario;
        scanner.nextLine();
        comentario = scanner.nextLine();
        listaTareas.get(id).nuevoComentario(comentario);
    }

    public void modificarComentario(int id, Scanner scanner){
        System.out.println("Introduce el texto que quieras añadir al comentario");
        String comentario1;
        scanner.nextLine();
        comentario1 = scanner.nextLine();
        listaTareas.get(id).modificacionComentario(comentario1);
    }
    public void eliminarComentario(int id, Scanner scanner){
        listaTareas.get(id).eliminaComentario();
    }

    public void gestionarComentarios(Scanner scanner){
        int gestionComentario;
        do{
            System.out.println("Elige la opcion de gestion de comentario que quieras realizar.");
            System.out.println("\nMenú: ");
            System.out.println("1. Añadir un comentario nuevo.");
            System.out.println("2. Modificar el comentario actual.");
            System.out.println("3. Eliminar el comentario actual.");
            System.out.println("0. Salir.");

            System.out.println("Ingrese la opción deseada: ");
            gestionComentario= scanner.nextInt();

            switch (gestionComentario) {
                case 1:
                    System.out.println("Introduce el número de la tarea que quieras modificar.");
                    int id;
                    id = scanner.nextInt();
                    añadirComentario(id, scanner);
                    break;

                case 2:
                    System.out.println("Introduce el número de la tarea que quieras modificar.");
                    int id1;
                    id1 = scanner.nextInt();
                    modificarComentario(id1, scanner);
                    break;

                case 3:
                    System.out.println("Introduce el número de la tarea que quieras modificar.");
                    int id2;
                    id2 = scanner.nextInt();
                    eliminarComentario(id2, scanner);
                    break;

                case 0: 
                    System.out.println("Saliendo del gestor de comentarios");
                    break;
                default:
                    break;
            }
        }while(gestionComentario != 0);
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
            System.out.println("4. Gestionar comentarios");
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
                        System.out.println("Ingrese si desea un comentario: ");
                        String comentario = scanner.nextLine();
                        System.out.print("Ingrese la prioridad de la tarea (BAJA, MEDIA, ALTA): ");
                        String prioridadStr = scanner.nextLine();
                        Tarea.Prioridad prioridad = Tarea.Prioridad.valueOf(prioridadStr.toUpperCase()); 
                        Tarea nuevaTarea = new Tarea(id, titulo,comentario, prioridad);
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

                case 4:
                        gestor.gestionarComentarios(scanner);
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
