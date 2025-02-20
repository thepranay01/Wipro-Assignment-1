package com.phase2.wiproDay1.Controller;


import com.phase2.wiproDay1.Model.College;
import com.phase2.wiproDay1.Service.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
//@RequiredArgsConstructor
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("Hello, Swagger!", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<College> addCollege(@RequestBody College college){
        College collegeAdded = collegeService.addCollege(college);
        return new ResponseEntity<>(collegeAdded, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<College>> getAllCollege(){
        List<College> allColleges = collegeService.getAllCollege();
        return new ResponseEntity<>(allColleges, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<College> getCollegeByName(@PathVariable String name) {
        return collegeService.getCollegeByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollegeName(@PathVariable Long id, @RequestParam String newName) {
        College updatedCollege = collegeService.updateCollegeName(id, newName);
        return (updatedCollege != null) ? ResponseEntity.ok(updatedCollege) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
        return ResponseEntity.noContent().build();
    }
}