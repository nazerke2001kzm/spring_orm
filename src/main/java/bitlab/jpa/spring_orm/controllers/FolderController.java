package bitlab.jpa.spring_orm.controllers;

import bitlab.jpa.spring_orm.models.Folder;
import bitlab.jpa.spring_orm.models.Task;
import bitlab.jpa.spring_orm.models.TaskCategory;
import bitlab.jpa.spring_orm.services.FolderService;
import bitlab.jpa.spring_orm.services.TaskService;
import bitlab.jpa.spring_orm.services.TaskcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FolderController {

    @Autowired FolderService folderService;
    @Autowired TaskcategoryService taskcategoryService;
    @Autowired
    TaskService taskService;
    @GetMapping("/")
    public String homePage(Model model){
        List<Folder> folders = folderService.findAll();
        model.addAttribute("folders",folders);
        return "home";
    }
    @PostMapping("/add")
    public String addFolders(Folder folder){
        folderService.addFolder(folder);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable Long id, Model model){
        Folder folder = folderService.findById(id);
        List<TaskCategory> taskcategories = taskcategoryService.findAll();
        List<Task> tasks = taskService.findTasksByFolderId(id);
        model.addAttribute("tasks",tasks);
        model.addAttribute("folder",folder);
        model.addAttribute("taskcategories",taskcategories);
        return "details";
    }

}
