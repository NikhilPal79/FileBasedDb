package LearnWithNik._May.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "STUDENT_TABLE")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 50,nullable = true)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50)
    private String phoneNumber;
    @Column(length = 100)
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id",referencedColumnName = "id")
    private Phone phone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> course;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
