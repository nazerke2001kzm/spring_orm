package bitlab.jpa.spring_orm.controllers;

import bitlab.jpa.spring_orm.models.Folder;
import bitlab.jpa.spring_orm.models.TaskCategory;
import bitlab.jpa.spring_orm.repositories.FolderRepository;
import bitlab.jpa.spring_orm.repositories.TaskCategoryRepository;
import bitlab.jpa.spring_orm.services.FolderService;
import bitlab.jpa.spring_orm.services.Impl.TaskCategoryServiceImpl;
import bitlab.jpa.spring_orm.services.TaskcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskCategoryController {
    @Autowired
    TaskcategoryService taskCategoryService;
    @Autowired
    FolderService folderService;
    @Autowired
    FolderRepository folderRepository;
    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(name="folder_id") Long folder_id,
                                 @RequestParam(name="category_id") Long category_id){
        TaskCategory taskCategory = taskCategoryService.findById(category_id);
        Folder folder = folderService.findById(folder_id);
        List<TaskCategory> taskCategoriess = folder.getCategories();
        taskCategoriess.remove(taskCategory);
        folderRepository.save(folder);
        return "redirect:/details/" + folder_id;
    }
    @PostMapping("/addCategory")
    public String addcategory(@RequestParam(name="folder_id") Long folder_id,
                              @RequestParam(name="category_id") Long category_id){
        System.out.println("dfdfsdf");
        Folder folder = folderService.findById(folder_id);
        TaskCategory taskCategory = taskCategoryService.findById(category_id);
        List<TaskCategory> taskCategories = folder.getCategories();
        if(!taskCategories.contains(taskCategory)){
            taskCategories.add(taskCategory);
        }
        folderRepository.save(folder);
        return "redirect:/details/" + folder_id;
    }
    @GetMapping("/category")
    public String categoryPage(Model model){
        List<TaskCategory> taskCategories = taskCategoryService.findAll();
        model.addAttribute("categories",taskCategories);
        return "categories";
    }
    @PostMapping("/addNewCategory")
    public String addNewcategory(TaskCategory taskCategory){
        taskCategoryService.save(taskCategory);
        return "redirect:/category";
    }
    @GetMapping("/deleteNewCategory")
    public String deleteNewCategory(@RequestParam Long id){
        taskCategoryService.deleteCategory(taskCategoryService.findById(id));
        return "redirect:/category";
    }
}
