package br.com.letscode.harrypotterjavarx.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private String id;
    private String name;
    private String houseName;

}
