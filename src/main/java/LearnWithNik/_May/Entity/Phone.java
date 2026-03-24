package LearnWithNik._May.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PHONE_TABLE")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String make;
    private String model;
    private String color;



}
