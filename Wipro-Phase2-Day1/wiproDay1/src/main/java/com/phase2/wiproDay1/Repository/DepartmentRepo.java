package com.phase2.wiproDay1.Repository;

import com.phase2.wiproDay1.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    List<Department> findByCollegeName(String collegeName);
}