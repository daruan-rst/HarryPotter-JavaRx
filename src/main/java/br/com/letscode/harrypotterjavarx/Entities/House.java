package br.com.letscode.harrypotterjavarx.Entities;

import lombok.Data;

import java.util.List;

@Data
public class House {

    private String id;
    private String name;
    private String animal;
    private String founder;
    private List<Object> values;


}
