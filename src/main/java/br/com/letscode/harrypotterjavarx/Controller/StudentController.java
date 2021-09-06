package br.com.letscode.harrypotterjavarx.Controller;


import br.com.letscode.harrypotterjavarx.Entities.Student;
import br.com.letscode.harrypotterjavarx.Repositories.StudentRepository;
import br.com.letscode.harrypotterjavarx.Request.StudentRequest;
import br.com.letscode.harrypotterjavarx.Response.StudentResponse;
import br.com.letscode.harrypotterjavarx.Service.StudentService;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {


    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @PostMapping("/addStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Single<StudentResponse> addStudent(@RequestBody StudentRequest studentRequest){
        return studentService.addStudent(studentRequest);
    }

    @GetMapping("/findAllStudents")
    public Observable<StudentResponse> findAllStudents(){
        return studentService.findAllStudent();}

    @GetMapping("/findByName")
    @ResponseStatus(HttpStatus.OK)
    public Single<StudentResponse> findStudentByName(@RequestParam String name){
        return studentService.findByName(name);
    }
}
