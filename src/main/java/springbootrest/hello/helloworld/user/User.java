package springbootrest.hello.helloworld.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {


    private  Integer id;

    @Size(min=2,message="name should be min 2 Characters")
    private  String name;

    @Past(message = "Birth Date should be  in Past" )
    private LocalDate birth_date;
    public User(Integer id, String name, LocalDate birth_date) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", user_name='" + name + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
