package LearnWithNik._May.Repo;

import LearnWithNik._May.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findAllStudentByFirstName(String firstName);


}
