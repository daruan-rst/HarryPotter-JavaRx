package br.com.letscode.harrypotterjavarx.Service;


import br.com.letscode.harrypotterjavarx.Entities.Student;
import br.com.letscode.harrypotterjavarx.Request.HouseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;

public class StudentService {

    static String webUrl = "https://api-harrypotter.herokuapp.com/";

    public static Student sortingStudent() {
        String resourceUrl = webUrl + "/sortinghat" ;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        Gson gson = new Gson();
        return gson.fromJson(response.getBody(), Student.class);
    }


    private static HouseRequest getHouse() {
        String resourceUrl = webUrl + "/houses" ;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        Gson gson = new Gson();
        return gson.fromJson(response.getBody(), HouseRequest.class);
    }

}

