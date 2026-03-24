package LearnWithNik._May.Api;

import LearnWithNik._May.Dto.StudentDTO;
import LearnWithNik._May.Entity.Student;
import LearnWithNik._May.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*@Controller*/
@RequestMapping("/student")
/*@ResponseBody*/
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /*@RequestMapping(method = RequestMethod.GET, path = "/getAll")*/
    @GetMapping( value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents(){
        List<Student> students = studentService.findAll();
        return students;
    }

    @GetMapping(value ="/byId")
    public Optional<Student> getById(@RequestParam("id")Integer identification){
        Optional<Student> optionalStu = studentService.findById(identification);
        return optionalStu;
    }

    @GetMapping(value ="/byId/{identifier}")
    public Optional<Student> getByIdInPath(@PathVariable("identifier")Integer identification){
        Optional<Student> optionalStu = studentService.findById(identification);
        return optionalStu;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody@Validated Student student){
        Student studentServiceStudent = studentService.createStudent(student);
        return studentServiceStudent;

    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student);
        return updatedStudent;
    }

    @GetMapping("/allByName")
    public List<Student> getAllByFirstName(@RequestParam() String Name){
        return studentService.getAllByFirstName(Name);
    }

    @PostMapping("/lastnames")
    public List<String> getAllByLastName(@RequestBody StudentDTO studentDTO){
        return studentService.getLastName(studentDTO.getFirstName());
    }


}
