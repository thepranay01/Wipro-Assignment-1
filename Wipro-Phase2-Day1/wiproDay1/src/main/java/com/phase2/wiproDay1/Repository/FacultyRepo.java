package com.phase2.wiproDay1.Repository;

import com.phase2.wiproDay1.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {
}
