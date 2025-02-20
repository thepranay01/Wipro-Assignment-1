package com.phase2.wiproDay1.Service;

import com.phase2.wiproDay1.Model.Faculty;
import com.phase2.wiproDay1.Repository.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepository;

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        return faculty.orElse(null);
    }

    // Update Faculty details
    public Faculty updateFaculty(Long id, Faculty facultyDetails) {
        if (facultyRepository.existsById(id)) {
            facultyDetails.setId(id);
            return facultyRepository.save(facultyDetails);
        }
        return null;
    }


    // Delete Faculty by
    public boolean deleteFaculty(Long id) {
        if (facultyRepository.existsById(id)) {
            facultyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
