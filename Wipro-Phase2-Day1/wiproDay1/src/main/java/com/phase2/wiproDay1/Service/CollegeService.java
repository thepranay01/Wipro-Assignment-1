package com.phase2.wiproDay1.Service;

import com.phase2.wiproDay1.Model.College;
import com.phase2.wiproDay1.Repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {

    @Autowired
    CollegeRepo collegeRepo;

    public College addCollege(College college) {
        return collegeRepo.save(college);
    }

    public List<College> getAllCollege() {
        return collegeRepo.findAll();
    }

    public Optional<College> getCollegeById(Long id){
        return collegeRepo.findById(id);
    }

    public Optional<College> getCollegeByName(String name){
        return collegeRepo.findByName(name);
    }

    public void deleteCollege(Long id){
        collegeRepo.deleteById(id);
    }

    public College updateCollegeName(Long id, String newName){
        Optional<College> collegeOpt = collegeRepo.findById(id);
        if (collegeOpt.isPresent()) {
            College college = collegeOpt.get();
            college.setName(newName);
            return collegeRepo.save(college);
        }
        return null;
    }
}