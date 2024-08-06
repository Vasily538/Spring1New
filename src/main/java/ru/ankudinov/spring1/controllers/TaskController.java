package ru.ankudinov.spring1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ankudinov.spring1.domain.Task;
import ru.ankudinov.spring1.service.TaskService;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public String allTasks( Model model,@RequestParam(defaultValue = "1") int page) {
        model.addAttribute("tasks", taskService.allTasks(page));
        model.addAttribute("taskCount", taskService.taskCount());
        model.addAttribute("pageCount", taskService.pageCount());
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping("/{id}/edit")
    public String editTask(@PathVariable("id") long id, Model model) {
        model.addAttribute("task", taskService.getById(id));
        return "edit";
    }

    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        taskService.add(task);
        return "redirect:/tasks";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";
        taskService.edit(task);
        return "redirect:/tasks";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.delete(taskService.getById(id));
        return "redirect:/tasks";
    }
}
