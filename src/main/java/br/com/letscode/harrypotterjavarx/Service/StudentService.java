package br.com.letscode.harrypotterjavarx.Service;


import br.com.letscode.harrypotterjavarx.Entities.House;
import br.com.letscode.harrypotterjavarx.Entities.Student;
import br.com.letscode.harrypotterjavarx.Repositories.StudentRepository;
import br.com.letscode.harrypotterjavarx.Request.StudentRequest;
import br.com.letscode.harrypotterjavarx.Response.StudentResponse;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;


@Service
@AllArgsConstructor
public class StudentService {

    static String webUrl = "http://api-harrypotter.herokuapp.com/";

    private final StudentRepository studentRepository;

    public static Student sortingStudent() {
        String resourceUrl = webUrl + "/sortinghat" ;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        Gson gson = new Gson();
        return gson.fromJson(response.getBody(), Student.class);
    }


    private static House getHouse(Student student) {
        String resourceUrl = webUrl + "/house/"+ student.getHouseId() ;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        Gson gson = new Gson();
        return gson.fromJson(response.getBody(), House.class);
    }

    public Single<StudentResponse> addStudent(StudentRequest studentRequest){
        return Single.create(singleSubscriver ->{
            Student student = studentBluilder(studentRequest);
            studentRepository.save(student);
        });
    }

    private Student studentBluilder(StudentRequest studentRequest){
        return new Student(studentRequest.getName() , getHouse(sortingStudent()));
    }

    public Observable<StudentResponse> findAllStudent() {
        return Observable.fromIterable(studentRepository.findAll()).map(this::convert);
    }

    private StudentResponse convert(Student student){
        return StudentResponse.convert(student);
    }

    public Single<StudentResponse> findByName(String name){
        return Single.create(single ->{
            var student = studentRepository.findByName(name);
            single.onSuccess(convert(student));
        });
    }



}

