package app.daos.impl;
import app.daos.IDAO;
import jakarta.persistence.EntityManager;
import app.entities.course;

public class CourseDAO implements IDAO<Course, Integer> {

    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    @Override
    public void update(Course course) {
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Course course) {
        em.getTransaction().begin();
        em.remove(em.contains(course) ? course : em.merge(course));
        em.getTransaction().commit();
    }

    @Override
    public Course findById(Integer integer) {
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
        return query.getResultList();
    }
}
