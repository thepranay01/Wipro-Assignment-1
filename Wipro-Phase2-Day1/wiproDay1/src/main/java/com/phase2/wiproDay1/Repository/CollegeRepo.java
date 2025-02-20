package com.phase2.wiproDay1.Repository;

import com.phase2.wiproDay1.Model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollegeRepo extends JpaRepository<College, Long> {

    Optional<College> findByName(String name);
}