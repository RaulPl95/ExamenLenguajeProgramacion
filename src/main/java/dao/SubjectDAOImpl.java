package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Subject;

public class SubjectDAOImpl implements SubjectDAO {

    private EntityManagerFactory fabric;

    public SubjectDAOImpl() {
        fabric = Persistence.createEntityManagerFactory(
                "ExamenLenguajeProgramacion"
        );
    }

    @Override
    public void registrar(Subject subject) {

        EntityManager em = fabric.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(subject);
            em.getTransaction().commit();

            System.out.println("Subject registrado correctamente.");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Subject subject) {

        EntityManager em = fabric.createEntityManager();

        try {
            em.getTransaction().begin();

            Subject existente =
                    em.find(Subject.class, subject.getIdsubject());

            if (existente != null) {

                existente.setSubject(subject.getSubject());
                existente.setCredits(subject.getCredits());

                em.getTransaction().commit();

                System.out.println("Subject actualizado correctamente.");

            } else {

                em.getTransaction().rollback();

                System.out.println(
                        "No existe Subject con ID: "
                        + subject.getIdsubject()
                );
            }

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(int id) {

        EntityManager em = fabric.createEntityManager();

        try {
            em.getTransaction().begin();

            Subject subject =
                    em.find(Subject.class, id);

            if (subject != null) {

                em.remove(subject);
                em.getTransaction().commit();

                System.out.println("Subject eliminado correctamente.");

            } else {

                em.getTransaction().rollback();

                System.out.println(
                        "No existe Subject con ID: " + id
                );
            }

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    @Override
    public List<Subject> listar() {

        EntityManager em = fabric.createEntityManager();

        try {

            return em.createQuery(
                    "SELECT s FROM Subject s",
                    Subject.class
            ).getResultList();

        } finally {
            em.close();
        }
    }
}