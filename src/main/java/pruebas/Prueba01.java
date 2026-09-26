package pruebas;

import java.util.List;

import dao.SubjectDAO;
import dao.SubjectDAOImpl;
import model.Subject;

public class Prueba01 {

    public static void main(String[] args) {

        SubjectDAO dao = new SubjectDAOImpl();

        System.out.println("===== REGISTRAR =====");
        Subject nuevo = new Subject("Base de Datos", "4");
        dao.registrar(nuevo);

        System.out.println("\n===== LISTAR =====");
        mostrarLista(dao.listar());

        System.out.println("\n===== EDITAR =====");
        nuevo.setSubject("Base de Datos Avanzada");
        nuevo.setCredits("5");
        dao.editar(nuevo);

        System.out.println("\n===== LISTAR ACTUALIZADO =====");
        mostrarLista(dao.listar());

        System.out.println("\n===== ELIMINAR =====");
        dao.eliminar(nuevo.getIdsubject());

        System.out.println("\n===== LISTAR FINAL =====");
        mostrarLista(dao.listar());
    }

    private static void mostrarLista(List<Subject> lista) {

        for (Subject subject : lista) {
            System.out.println(
                    subject.getIdsubject() + " | "
                    + subject.getSubject() + " | "
                    + subject.getCredits()
            );
        }
    }
}