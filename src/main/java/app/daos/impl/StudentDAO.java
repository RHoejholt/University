package app.daos.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import app.daos.IDAO;
import jakarta.persistence.EntityManager;
public class StudentDAO implements IDAO<Student> {

    private EntityManager em;

    public StudentDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Student student) {
        em.getTransaction().begin();
        em.remove(em.contains(student) ? student : em.merge(student));
        em.getTransaction().commit();
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }
}
