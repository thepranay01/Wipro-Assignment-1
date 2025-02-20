package com.phase2.wiproDay1.Controller;

import com.phase2.wiproDay1.Model.Department;
import com.phase2.wiproDay1.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @GetMapping("/by-college/{collegeName}")
    public ResponseEntity<List<Department>> getDepartmentsByCollegeName(@PathVariable String collegeName) {
        return ResponseEntity.ok(departmentService.getDepartmentsByCollegeName(collegeName));
    }
}