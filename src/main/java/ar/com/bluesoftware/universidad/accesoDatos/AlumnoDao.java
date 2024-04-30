package ar.com.bluesoftware.universidad.accesoDatos;

import ar.com.bluesoftware.universidad.entidades.Alumno;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface AlumnoDao {
    void guardarAlumno(Alumno alumno);

    void actualizarAlumno(Alumno alumno);

    void eliminarAlumno(int id_Alumno);

    Alumno obtenerAlumnoPorDni(int dni);
    
    List<Alumno> obtenerTodosAlumnos();
}
