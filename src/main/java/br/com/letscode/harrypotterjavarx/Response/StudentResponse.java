package br.com.letscode.harrypotterjavarx.Response;

import br.com.letscode.harrypotterjavarx.Entities.Student;

public class StudentResponse {

    private String id;
    private String name;
    private String houseName;

    public StudentResponse (Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.houseName = student.getHouseName();
    }


}
