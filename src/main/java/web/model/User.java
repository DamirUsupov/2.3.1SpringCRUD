package web.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long   id;
    @Column(name = "email")
    String email;
    @Column(name = "name")
    String name;
    @Column(name = "pass")
    String pass;

    public User() {
    }

    public User(String email, String name, String pass) {
        this.email = email;
        this.name = name;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
