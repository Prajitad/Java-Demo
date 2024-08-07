package com.prajita.demo.controller;

import com.prajita.demo.dto.Student;
import com.prajita.demo.dto.Studentinfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my")

public class MyController {
    @GetMapping("/hello")
    public ResponseEntity<String> printHello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok("Hello" + id);
    }

    @GetMapping("/myget")
    public ResponseEntity<String> myget(@RequestParam Integer id) {
        return ResponseEntity.ok("Hello" + id);
    }


    @PostMapping("/mypost")
    public ResponseEntity<String> post(@RequestBody Student student) {
        return ResponseEntity.ok("Hello" + student.getName());

    }


    @PostMapping("/mypostwithfile")
    public ResponseEntity<String> postWithFile(@ModelAttribute Studentinfo student) {
        return ResponseEntity.ok(String.valueOf(student.getFile().getSize()));

    }
    }