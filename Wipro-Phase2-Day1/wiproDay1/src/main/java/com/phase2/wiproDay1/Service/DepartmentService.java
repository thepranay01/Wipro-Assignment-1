package com.phase2.wiproDay1.Service;

import com.phase2.wiproDay1.Model.College;
import com.phase2.wiproDay1.Model.Department;
import com.phase2.wiproDay1.Model.Faculty;
import com.phase2.wiproDay1.Repository.CollegeRepo;
import com.phase2.wiproDay1.Repository.DepartmentRepo;
import com.phase2.wiproDay1.Repository.FacultyRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    CollegeRepo collegeRepo;

    @Autowired
    FacultyRepo facultyRepo;

    @Transactional

    public Department saveDepartment(Department department) {
        // Ensure College exists before setting
        if (department.getCollege() != null && department.getCollege().getId() != null) {
            College college = collegeRepo.findById(department.getCollege().getId())
                    .orElseThrow(() -> new RuntimeException("College not found with id: " + department.getCollege().getId()));
            department.setCollege(college);
        } else {
            throw new RuntimeException("College must not be null");
        }

        // Ensure HOD exists before setting
        if (department.getHod() != null && department.getHod().getId() != null) {
            Faculty hod = facultyRepo.findById(department.getHod().getId())
                    .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + department.getHod().getId()));
            department.setHod(hod);
        }

        // Ensure Faculty list exists
        if (department.getFaculties() != null && !department.getFaculties().isEmpty()) {
            List<Faculty> faculties = department.getFaculties().stream()
                    .map(f -> facultyRepo.findById(f.getId())
                            .orElseThrow(() -> new RuntimeException("Faculty not found with id: " + f.getId())))
                    .collect(Collectors.toList());
            department.setFaculties(faculties);
        }

        return departmentRepo.save(department);
    }

    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return departmentRepo.findByCollegeName(collegeName);
    }
}