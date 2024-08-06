package ru.ankudinov.spring1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.ankudinov.spring1.dao.TaskDAO;
import ru.ankudinov.spring1.dao.TaskDAOImpl;
import ru.ankudinov.spring1.domain.Task;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskDAO taskDAO;

    @Autowired
    public void setTaskDAO(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Transactional
    @Override
    public List<Task> allTasks(int page) {
        return taskDAO.allTasks(page);
    }


    @Override
    public void add(Task task) {
        taskDAO.add(task);
    }

    @Override
    public void delete(Task task) {
        taskDAO.delete(task);
    }

    @Override
    public void edit(Task task) {
        taskDAO.edit(task);
    }

    @Override
    public Task getById(long id) {
        return taskDAO.getById(id);
    }

    @Override
    public int taskCount() {
        return Math.toIntExact(taskDAO.taskCount());
    }

    @Override
    public int pageCount() {
        return Math.toIntExact(taskDAO.pageCount());
    }
}
