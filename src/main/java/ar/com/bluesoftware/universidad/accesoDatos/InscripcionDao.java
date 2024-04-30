package ar.com.bluesoftware.universidad.accesoDatos;

import ar.com.bluesoftware.universidad.entidades.Inscripcion;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface InscripcionDao {
    void guardarInscripcion(Inscripcion inscripcion);

    void actualizarInscripcion(Inscripcion inscripcion);

    void eliminarInscripcion(int id_Inscripto);

    Inscripcion obtenerInscripcion(int id_Inscripto);

    List<Inscripcion> obtenerTodasInscripciones();
}
