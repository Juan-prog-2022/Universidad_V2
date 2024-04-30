package ar.com.bluesoftware.universidad.accesoDatos;

import ar.com.bluesoftware.universidad.entidades.Alumno;
import ar.com.bluesoftware.universidad.entidades.Materia;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface MateriaDao {
    void guardarMateria(Materia materia);

    void actualizarMateria(Materia materia);

    void eliminarMateria(int id_Materia);

    Materia obtenerMateria(int id_Materia);

    List<Materia> obtenerTodasMaterias();
    
    List<Materia> obtenerMateriasCursadasPorAlumno(Alumno alumno);
}
