package ru.ankudinov.spring1.dao;

//import org.hibernate.query.Page;
import ru.ankudinov.spring1.domain.Task;


import java.util.List;

public interface TaskDAO {
    List<Task> allTasks(int page);
    void add(Task task);
    void delete(Task task);
    void edit(Task task);
    Task getById(long id);
    Long taskCount();
    Long pageCount();

}
