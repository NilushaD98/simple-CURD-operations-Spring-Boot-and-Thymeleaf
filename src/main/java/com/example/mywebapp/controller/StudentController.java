package com.example.mywebapp.controller;

import com.example.mywebapp.entity.Student;
import com.example.mywebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(path="api/v1/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("home")
    public String homePage(){
        return "index";
    }
   @GetMapping("students")
    public String showStudentList(Model model){
       List<Student> studentList = studentService.listAll();
       model.addAttribute("studentList",studentList);
       return "users";
   }
   @GetMapping("new-student")
    public String showNewForm(Model model){
        model.addAttribute("student",new Student());
        return "newuserform";
   }

   @PostMapping("addStudent")
    public String saveStudents(Student student, RedirectAttributes ra){
        studentService.save(student);
        ra.addFlashAttribute("message","The user has been saved successfully....");
        return "redirect:students";
   }

   @GetMapping("edit{id}")
    public String showEditForm(@PathVariable("id") int id, Model model){
        Student student = studentService.get(id);
        model.addAttribute("student",student);
        return "newuserform";
   }
   @GetMapping("delete{id}")
    public String deleteStudent(@PathVariable("id")int id, RedirectAttributes ra){
        studentService.deleteStudent(id);
        ra.addFlashAttribute("message","This user successfully deleted");
        return "redirect:students";
   }
}
