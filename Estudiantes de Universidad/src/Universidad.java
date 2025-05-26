import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Universidad {

    public void matricularEstudiante(int estudianteId, int cursoId, double calificacion) throws SQLException {
        String sql = "INSERT INTO matricula (estudiante_id, curso_id, calificacion) VALUES (" + estudianteId + ", "
                + cursoId + ", " + calificacion + ")";
        try {
            Connection conn = ConexionBBDD.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void registrarCalificacion(int estudianteId, int cursoId, double calificacion) throws SQLException {
        String sql = "UPDATE matricula SET calificacion = " + calificacion + " WHERE estudiante_id = " + estudianteId + " AND curso_id = " + cursoId;
        try {
            Connection conn = ConexionBBDD.getConnection();
           Statement stmt = conn.createStatement();

            
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void calcularPromedio(int estudianteId) throws SQLException {
        String sql = "SELECT AVG(calificacion) AS promedio FROM matricula WHERE estudiante_id = " + estudianteId;

        try {
            Connection conn = ConexionBBDD.getConnection();
            Statement stmt = conn.createStatement();

            
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Promedio del estudiante " + estudianteId + ": " + rs.getDouble("promedio"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void listarEstudiantesPorCurso(int cursoId) throws SQLException {
        String sql = "SELECT e.id, e.nombre FROM estudiantes e JOIN matricula m ON e.id = m.estudiante_id WHERE m.curso_id = " + cursoId;

        try {
            Connection conn = ConexionBBDD.getConnection();
            Statement stmt = conn.createStatement();

            
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Estudiantes en el curso " + cursoId + ":");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void mostrarHistorialAcademico(int estudianteId) throws SQLException {
        String sql = "SELECT c.nombre, m.calificacion FROM cursos c JOIN matricula m ON c.id = m.curso_id WHERE m.estudiante_id = " + estudianteId;

        try {
            Connection conn = ConexionBBDD.getConnection();
            Statement stmt = conn.createStatement();

            
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Historial académico del estudiante " + estudianteId + ":");
            while (rs.next()) {
                int cursoId = rs.getInt("id");
                String cursoNombre = rs.getString("nombre");
                double calificacion = rs.getDouble("calificación");
                System.out.println("ID: " + cursoId + ", Curso: " + cursoNombre + ", Calificación: " + calificacion);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
