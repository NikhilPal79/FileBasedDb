package LearnWithNik._May.Service;

import LearnWithNik._May.Entity.Student;
import LearnWithNik._May.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> findAll() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }


    /// Optional bcz we need to handle null pointer exception
    public Optional<Student> findById(Integer id){
        Optional<Student> studentOptional = studentRepo.findById(id);
        return studentOptional;
    }

    ///  to create new student

    public Student createStudent(Student student){
        Student savedStudent = studentRepo.save(student);
        return savedStudent;
    }
    /// to update new student

    public Student updateStudent(Student student){
        Optional<Student> studentOptional = studentRepo.findById(student.getId());
        if(studentOptional.isPresent()){
            studentRepo.save(student);
        }
        return student;
    }

    public List<Student> getAllByFirstName(String firstName){
        List<Student> allStudentByFirstName = studentRepo.findAllStudentByFirstName(firstName);
        return allStudentByFirstName;
    }
}
