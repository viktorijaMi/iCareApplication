package mk.ukim.finki.icareapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class User {

    @Id
    private String username;

    private String password;

    private String date_of_birth;

    private String name;

    private String surname;

    private String gender;

    private Feelings start_feeling;

    private boolean frequent_feeling;

    private boolean panic_attack;

    private String why_the_app;

    private boolean stressed_period;

    public User(String name, String surname, String gender, String date_of_birth, String username, String password){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.username = username;
        this.password = password;
    }
}
