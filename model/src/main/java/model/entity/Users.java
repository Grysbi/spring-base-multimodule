package model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Users Entity
 *
 * @author gandrieu
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class Users {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private long users_id=0;

    @NotEmpty
    @Column(name = "login")
    private String login;

    @NotEmpty
    @Column(name = "password")
    private String password;

    // Constructor
    public Users(){ }

    public Users(String login, String password){
        this.login = login;
        this.password = password;
    }

    // Getters / Setters
    public long getUsers_id() { return users_id; }

    public void setUsers_id(long users_id) { this.users_id = users_id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    // Identity
    @Override
    public String toString() {
        return "Users{" +
                "users_id=" + users_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
