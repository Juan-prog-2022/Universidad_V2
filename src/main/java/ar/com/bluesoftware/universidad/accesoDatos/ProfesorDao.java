package ar.com.bluesoftware.universidad.accesoDatos;

import ar.com.bluesoftware.universidad.entidades.Alumno;
import ar.com.bluesoftware.universidad.entidades.Profesor;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface ProfesorDao {
     void guardarProfesor(Profesor profesor);

    void actualizarProfesor(Profesor profesor);

    void eliminarProfesor(int id_Profesor);

    Profesor obtenerProfesorPorDni(int dni);
    
    List<Profesor> obtenerTodosProfesores();
}
