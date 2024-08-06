package ru.ankudinov.spring1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ankudinov.spring1.domain.Task;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDAOImpl implements TaskDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<Task> allTasks(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Task ").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public void add(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(task);
    }

    @Override
    public void delete(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(task);
    }

    @Override
    public void edit(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.update(task);
    }

    @Override
    public Task getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Task.class, id);
    }

    @Override
    public Long taskCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT COUNT (*) FROM Task ", Long.class).getSingleResult();
    }

    @Override
    public Long pageCount() {
        Long taskCount = taskCount();
        Long pageCount = (taskCount+9)/10;
        return pageCount;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
