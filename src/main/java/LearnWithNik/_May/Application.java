package LearnWithNik._May;

import LearnWithNik._May.Entity.Emp;
import LearnWithNik._May.Entity.Student;
import LearnWithNik._May.Repo.StudentRepo;
import LearnWithNik._May.Service.EmpService;
import LearnWithNik._May.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        StudentService studentService = context.getBean(StudentService.class);
        System.out.println(studentService.findAll());

        EmpService empService = context.getBean(EmpService.class);
        List<Emp> allEmp = empService.findAllEmp();
        System.out.println(allEmp);

    };




}
