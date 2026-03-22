package LearnWithNik._May.Api;

import LearnWithNik._May.Entity.Emp;
import LearnWithNik._May.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/getAll")
    public List<Emp> findAll() {
        List<Emp> allEmp = empService.findAllEmp();
        return allEmp;
    }
}
