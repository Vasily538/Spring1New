package ru.ankudinov.spring1.service;

import ru.ankudinov.spring1.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> allTasks(int page);
    void add(Task task);
    void delete(Task task);
    void edit(Task task);
    Task getById(long id);
    int taskCount();
    int pageCount();
}
