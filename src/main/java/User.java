import lombok.*;
import javax.persistence.*;

@Entity
@Table (name = "\"User\"" , schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    public User(String name, String city, int age, String country){
        this.name = name;
        this.city = city;
        this.age = age;
        this.country = country;
    }
    @Id
    @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name")
    private String name;

    private String city;

    private int age;

    private String country;
}
