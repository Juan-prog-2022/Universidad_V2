package ar.com.bluesoftware.universidad.accesoDatos;

import ar.com.bluesoftware.universidad.entidades.Inscripcion;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Juan
 */
public class Inscripcion_Datos implements InscripcionDao {

    private final Session session;

    public Inscripcion_Datos(Session session) {
        this.session = session;
    }

    @Override
    public void guardarInscripcion(Inscripcion inscripcion) {
        session.persist(inscripcion);
    }

    @Override
    public void actualizarInscripcion(Inscripcion inscripcion) {
        session.merge(inscripcion);
    }

    @Override
    public void eliminarInscripcion(int id_Inscripto) {
        Inscripcion inscripcion = session.get(Inscripcion.class, id_Inscripto);
        if (inscripcion != null) {
            session.remove(inscripcion);
        }
    }

    @Override
    public Inscripcion obtenerInscripcion(int id_Inscripto) {
        return session.get(Inscripcion.class, id_Inscripto);
    }

    @Override
    public List<Inscripcion> obtenerTodasInscripciones() {
        Query<Inscripcion> query = session.createQuery("SELECT i FROM Inscripcion i JOIN FETCH i.alumno a JOIN FETCH i.materia m", Inscripcion.class);
        return query.list();
    }
}
