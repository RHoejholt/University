package app.daos.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import app.daos.IDAO;
import jakarta.persistence.EntityManager;
public class TeacherDAO implements IDAO<Teacher> {

    private EntityManager em;

    public TeacherDAO(EntityManager em) {
        this.em = em;
    }

        @Override
        public void save(Teacher teacher) {
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
        }

    @Override
    public void update(Teacher teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Teacher teacher) {
        em.getTransaction().begin();
        em.remove(em.contains(teacher) ? teacher : em.merge(teacher));
        em.getTransaction().commit();
    }

    @Override
    public Teacher findById(Long id) {
        return em.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> findAll() {
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return query.getResultList();
    }
}
