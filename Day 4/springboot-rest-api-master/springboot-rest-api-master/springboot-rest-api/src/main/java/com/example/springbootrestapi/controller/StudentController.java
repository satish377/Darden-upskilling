package com.example.springbootrestapi.controller;

import com.example.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "satish",
                "peruri"
        );
        return ResponseEntity.ok().header("custom-header", "satish").body(student);
        // return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"satish", "peruri"));
        students.add(new Student(2,"venkata", "peruri"));
        students.add(new Student(3, "veera", "peruri"));
        students.add(new Student(4,"nani", "n s"));
        return ResponseEntity.ok(students);
    }

    // Spring Boot Rest API with Path Variable
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        Student student =  new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }


    //Spring boot REST API with Request Param
    //http://localhost:8084/students/query?id=1&firstName=satish&lastName=Satish
    @GetMapping("/query")
    public  ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        Student student= new  Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    //Spring boot REST API that handle HTTP Post Request
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);

    }

    //Spring boot REST API that handles HTTP Put request
   @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring boot REST API that handles HTTP Delete request
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
