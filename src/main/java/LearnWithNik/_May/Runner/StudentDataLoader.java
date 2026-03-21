package LearnWithNik._May.Runner;

import LearnWithNik._May.Entity.Student;
import LearnWithNik._May.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentDataLoader implements CommandLineRunner {

    @Autowired
    StudentRepo studentRepo;
    @Override
    public void run(String... args) throws Exception {

       /* Student student = new Student();
        student.setId(1598);
        student.setFirstName("ankita");
        student.setLastName("patel");
        student.setPhoneNumber("45612378");
        student.setEmail("ankita@gmail.com");
        studentRepo.save(student);*/
    }
}
