package br.com.letscode.harrypotterjavarx.Entities;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;

    @SerializedName("sorting-hat-choice")
    private String houseId;

    public Student(String name, House house) {
        this.name = name;
        this.houseId = house.getId();
    }
}
