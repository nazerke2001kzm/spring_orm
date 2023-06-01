package bitlab.jpa.spring_orm.controllers;

import bitlab.jpa.spring_orm.Enum.TaskStatus;
import bitlab.jpa.spring_orm.models.Comment;
import bitlab.jpa.spring_orm.models.Folder;
import bitlab.jpa.spring_orm.models.Task;
import bitlab.jpa.spring_orm.repositories.TaskRepository;
import bitlab.jpa.spring_orm.services.CommentService;
import bitlab.jpa.spring_orm.services.FolderService;
import bitlab.jpa.spring_orm.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    CommentService commentService;
    @Autowired
    FolderService folderService;
    @GetMapping("/detailsTasks/{id}")
    public String deatilsTask(@PathVariable Long id, Model model){
        Task task = taskService.findById(id);
        model.addAttribute("task",task);
        List<Comment> comments = commentService.getByTaskId(task.getId());
        model.addAttribute("commentss",comments);
        return "detailsTasks";
    }
    @PostMapping("/addTask")
    public String addTask(Task task, @RequestParam(name="folder_id") Long folder_id) {
        Folder folder = folderService.findById(folder_id);
        task.setFolder(folder);
        task.setStatus(TaskStatus.to_do);
        taskService.addTask(task);
        return "redirect:/details/" + folder_id;
    }
}
