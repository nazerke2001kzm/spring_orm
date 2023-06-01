package bitlab.jpa.spring_orm.controllers;

import bitlab.jpa.spring_orm.models.Comment;
import bitlab.jpa.spring_orm.models.Task;
import bitlab.jpa.spring_orm.services.CommentService;
import bitlab.jpa.spring_orm.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    TaskService taskService;
    @PostMapping("/addComment")
    public String addComment(@RequestParam String comment,@RequestParam (name="task_id") Long task_id){
        Comment comment1 = new Comment();
        Task task = taskService.findById(task_id);
        comment1.setComment(comment);
        comment1.setDate(LocalDateTime.now());
        comment1.setTask(task);
        commentService.addComment(comment1);
        return "redirect:/detailsTasks/"+ task.getId() ;
    }
}