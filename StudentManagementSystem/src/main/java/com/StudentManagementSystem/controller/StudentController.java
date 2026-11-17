package com.StudentManagementSystem.controller;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    private StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    //handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String  listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create student object to hold student from data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/students/edit/{id}")
    public String editedStudentForm(@PathVariable Long id, Model model){
//        Student student = studentService.getStudentById(id);
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){

        //get Student from database by id

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setGender(student.getGender());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        existingStudent.setCity(student.getCity());

        //save update student object
        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }


    //handler method to handle delete student request

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }




}
