package br.com.letscode.harrypotterjavarx.Entities;

import lombok.Data;

import java.util.List;

@Data
public class House {

    private String name;
    private String patronum;
    private String ghost;
    private List<String> values;

}
