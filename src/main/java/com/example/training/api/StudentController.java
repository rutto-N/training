package com.example.training.api;

import com.example.training.service.StudentService;
import com.example.training.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/save")
    public ResponseEntity<String> registerNewStudent(@RequestBody Student student){
        return new ResponseEntity<>( studentService.addNewStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping(path = "{id}")
    public void updateStudent(
            @PathVariable("id")Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
            ){
        studentService.updateStudent(id,name,email);

    }
}
