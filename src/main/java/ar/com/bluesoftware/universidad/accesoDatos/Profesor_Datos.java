package ar.com.bluesoftware.universidad.accesoDatos;

import ar.com.bluesoftware.universidad.entidades.Profesor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Profesor_Datos implements ProfesorDao{

     private final Session session;

    public Profesor_Datos(Session session) {
        this.session = session;
    }
    

    @Override
    public void guardarProfesor(Profesor profesor) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(profesor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo adecuado de la excepción en una aplicación real
        }
    }

    @Override
    public void actualizarProfesor(Profesor profesor) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(profesor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo adecuado de la excepción en una aplicación real
        }
    }

    @Override
    public void eliminarProfesor(int id_Profesor) {
       Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Profesor profesor = session.get(Profesor.class, id_Profesor);
            if (profesor != null) {
                session.remove(profesor);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo adecuado de la excepción en una aplicación real
        }
    }

    @Override
    public Profesor obtenerProfesorPorDni(int dni) {
        return session.get(Profesor.class, dni);
    }

    @Override
    public List<Profesor> obtenerTodosProfesores() {
        Query<Profesor> query = session.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return query.list();
    }
}
