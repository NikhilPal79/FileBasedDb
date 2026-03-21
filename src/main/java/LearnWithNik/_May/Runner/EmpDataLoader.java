package LearnWithNik._May.Runner;

import LearnWithNik._May.Entity.Emp;
import LearnWithNik._May.Repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpDataLoader implements CommandLineRunner {

    @Autowired
    EmpRepo empRepo;
    @Override
    public void run(String... args) throws Exception {

       /* Emp emp = new Emp();
        emp.setId(1244);
        emp.setFirstName("Jack");
        emp.setLastName("Sam");
        emp.setCity("Berlin");
        empRepo.save(emp);
    }*/
    }
}
