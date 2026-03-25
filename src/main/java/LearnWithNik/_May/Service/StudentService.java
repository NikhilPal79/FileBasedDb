package LearnWithNik._May.Service;

import LearnWithNik._May.Entity.Course;
import LearnWithNik._May.Entity.Phone;
import LearnWithNik._May.Entity.Student;
import LearnWithNik._May.Repo.CourseRepo;
import LearnWithNik._May.Repo.PhoneRepo;
import LearnWithNik._May.Repo.StudentRepo;
import LearnWithNik._May.Repo.TeacherRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    PhoneRepo phoneRepo;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    TeacherRepo teacherRepo;

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

    @Transactional
    public Student createStudent(Student student){
        teacherRepo.saveAll(student.getTeacher());

        courseRepo.saveAll(student.getCourse());

        Phone savedPhone = phoneRepo.save(student.getPhone());
        student.setPhone(savedPhone);
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

    public  List<String> getLastName(String lastName){
        return studentRepo.findAllLastNameByFirstName(lastName);
    }
}
