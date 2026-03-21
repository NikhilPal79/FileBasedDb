package LearnWithNik._May.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMP_TABLE")
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    @Column(length = 20,nullable = true)
    private String firstName;
    @Column(length = 30)
    private String lastName;
    @Column(length = 50)
    private String city;
}
