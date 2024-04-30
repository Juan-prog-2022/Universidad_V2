package ar.com.bluesoftware.universidad.accesoDatos;

import ar.com.bluesoftware.universidad.entidades.Alumno;
import ar.com.bluesoftware.universidad.entidades.Materia;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Juan
 */
public class Materia_Datos implements MateriaDao {

    private final Session session;

    public Materia_Datos(Session session) {
        this.session = session;
    }

    @Override
    public void guardarMateria(Materia materia) {
        session.persist(materia);
    }

    @Override
    public void actualizarMateria(Materia materia) {
        session.merge(materia);
    }

    @Override
    public void eliminarMateria(int id_Materia) {
        Materia materia = session.get(Materia.class, id_Materia);
        if (materia != null) {
            session.remove(materia);
        }
    }

    @Override
    public Materia obtenerMateria(int id_Materia) {
        return session.get(Materia.class, id_Materia);
    }

    @Override
    public List<Materia> obtenerTodasMaterias() {
        Query<Materia> query = session.createQuery("SELECT m FROM Materia m LEFT JOIN FETCH m.inscripciones", Materia.class);
        return query.list();
    }
    
    @Override
    public List<Materia> obtenerMateriasCursadasPorAlumno(Alumno alumno) {
        // Consulta para obtener las materias cursadas por un alumno específico
        String queryString = "SELECT m FROM Materia m JOIN FETCH m.inscripciones i WHERE i.alumno = :alumno";
        Query<Materia> query = session.createQuery(queryString, Materia.class);
        query.setParameter("alumno", alumno);
        return query.list();
    }
}
