import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        
        int opcion;
        Universidad universidad = new Universidad();

        try {
            
            do {
                System.out.println("¿Qué quieres hacer?: ");
                System.out.println("1- Matricular estudiantes en cursos");
                System.out.println("2- Registrar calificaciones");
                System.out.println("3- Calcular promedios por estudiante");
                System.out.println("4- Generar lista de estudiantes por curso");
                System.out.println("5- Mostrar historial académico completo");
                System.out.println("0- Salir");
                System.out.print("¿Qué eliges?: ");
                opcion = Integer.parseInt(teclado.nextLine());

                int cursoId;
                int estudianteId;
                double calificacion;
                switch (opcion) {
                    case 1:
                        System.out.print("Dime el ID del estudiante: ");
                        estudianteId = Integer.parseInt(teclado.nextLine());
                        System.out.print("Dime el ID del curso del estudiante: ");
                        cursoId = Integer.parseInt(teclado.nextLine());
                        System.out.print("Dime la calificación del estudiante: ");
                        calificacion = Double.parseDouble(teclado.nextLine());

                        universidad.matricularEstudiante(estudianteId, cursoId, calificacion);
                        break;

                    case 2:
                        System.out.print("Dime el ID del estudiante: ");
                        estudianteId = Integer.parseInt(teclado.nextLine());
                        System.out.print("Dime el ID del curso del estudiante: ");
                        cursoId = Integer.parseInt(teclado.nextLine());
                        System.out.print("Dime la calificación del estudiante: ");
                        calificacion = Double.parseDouble(teclado.nextLine());

                        universidad.registrarCalificacion(estudianteId, cursoId, calificacion);
                        break;

                    case 3:
                        System.out.println("Dime el ID del estudiante: ");
                        estudianteId = Integer.parseInt(teclado.nextLine());

                        universidad.calcularPromedio(estudianteId);
                        break;

                    case 4:
                        System.out.println("Dime el ID del curso del estudiante: ");
                        cursoId = Integer.parseInt(teclado.nextLine());

                        universidad.listarEstudiantesPorCurso(cursoId);
                        break;

                    case 5:
                        System.out.println("Dime el ID del estudiante: ");
                        estudianteId = Integer.parseInt(teclado.nextLine());

                        universidad.mostrarHistorialAcademico(estudianteId);
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida. Escoge un número del 0 al 5.");
                        break;
                }

            } while (opcion != 0);
        } catch (Exception e) {
            // TODO: handle exception
        }

        teclado.close();
    }
}