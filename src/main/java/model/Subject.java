package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubject")
    private int idsubject;

    @Column(name = "subject")
    private String subject;

    @Column(name = "credits")
    private String credits;

    public Subject() {
    }

    public Subject(String subject, String credits) {
        this.subject = subject;
        this.credits = credits;
    }

    public Subject(int idsubject, String subject, String credits) {
        this.idsubject = idsubject;
        this.subject = subject;
        this.credits = credits;
    }

    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Subject [idsubject=" + idsubject
                + ", subject=" + subject
                + ", credits=" + credits + "]";
    }
}