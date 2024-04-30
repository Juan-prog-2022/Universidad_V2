package ar.com.bluesoftware.universidad.accesoDatos;

import ar.com.bluesoftware.universidad.entidades.Alumno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Alumno_Datos implements AlumnoDao {

    private final Session session;

    public Alumno_Datos(Session session) {
        this.session = session;
    }

    @Override
    public void guardarAlumno(Alumno alumno) {
        if (session != null) {
            session.persist(alumno);
        } else {
            // Puedes lanzar una excepción aquí o agregar un log
            throw new IllegalStateException("La sesión es nula al intentar guardar un alumno.");
        }
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(alumno);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarAlumno(int id_Alumno) {
        if (session != null) {
            Alumno alumno = session.get(Alumno.class, id_Alumno);
            if (alumno != null) {
                session.remove(alumno);
            }
        } else {
            // Puedes lanzar una excepción aquí o agregar un log
            throw new IllegalStateException("La sesión es nula al intentar eliminar un alumno.");
        }
    }

    @Override
    public Alumno obtenerAlumnoPorDni(int dni) {
        if (session != null) {
            Query<Alumno> query = session.createQuery("FROM Alumno WHERE dni = :dni", Alumno.class);
            query.setParameter("dni", dni);
            return query.uniqueResult();
        } else {
            // Puedes lanzar una excepción aquí o agregar un log
            throw new IllegalStateException("La sesión es nula al intentar obtener un alumno por DNI.");
        }
    }

    @Override
    public List<Alumno> obtenerTodosAlumnos() {
        if (session != null) {
            Query<Alumno> query = session.createQuery("SELECT a FROM Alumno a LEFT JOIN FETCH a.inscripciones", Alumno.class);
            return query.list();
        } else {
            // Puedes lanzar una excepción aquí o agregar un log
            throw new IllegalStateException("La sesión es nula al intentar obtener todos los alumnos.");
        }
    }
}
