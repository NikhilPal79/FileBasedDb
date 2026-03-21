package LearnWithNik._May.Service;

import LearnWithNik._May.Entity.Emp;
import LearnWithNik._May.Repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    EmpRepo empRepo;


    public List<Emp> findAllEmp(){
        List<Emp> empList = empRepo.findAll();
        return empList;
    }
}
