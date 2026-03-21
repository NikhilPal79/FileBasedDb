package LearnWithNik._May.Service;

import LearnWithNik._May.Entity.Student;
import LearnWithNik._May.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    /*public List<Student> findAll() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }*/
}
