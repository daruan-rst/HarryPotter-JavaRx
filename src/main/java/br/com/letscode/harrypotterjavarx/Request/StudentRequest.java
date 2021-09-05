package br.com.letscode.harrypotterjavarx.Request;

import br.com.letscode.harrypotterjavarx.Entities.Student;

import java.util.UUID;

public class StudentRequest {

    private String name;

    public Student convert (String houseName){

        return Student.builder().
                id(UUID.randomUUID().toString())
                .name(this.name)
                .houseName(houseName)
                .build();
    }
}

