package br.com.letscode.harrypotterjavarx.Response;

import br.com.letscode.harrypotterjavarx.Entities.House;
import br.com.letscode.harrypotterjavarx.Entities.Student;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StudentResponse {

    private String id;
    private String name;
    private String houseName;

    public static StudentResponse convert(Student student){
        return new StudentResponse(student.getId(),student.getName(),student.getHouseId()); }

    public StudentResponse(Student student, House house) {
        this.id = student.getId();
        this.name = student.getName();
        this.houseName = house.getId();
    }

}
