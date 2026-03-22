package LearnWithNik._May.Api;

import LearnWithNik._May.Entity.Student;
import LearnWithNik._May.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@Controller*/
@RequestMapping("/student")
/*@ResponseBody*/
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /*@RequestMapping(method = RequestMethod.GET, path = "/getAll")*/
    @GetMapping( "/getAll")
    public List<Student> getAllStudents(){
        List<Student> students = studentService.findAll();
        return students;
    }


}
