package model.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Users_Roles Entity
 *
 * @author gandrieu
 * @version 1.0
 */

@Entity
@Table(name = "users_roles")
public class UsersRoles {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_roles_id")
    private long users_roles_id=0;

    // Ref table Users
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    // Ref table Roles
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "roles_id")
    private Roles roles;

    // Constructor
    public UsersRoles(){ }

    public UsersRoles(Users users, Roles roles){
        this.users = users;
        this.roles = roles;
    }

    // Getters / Setters
    public long getUsers_roles_id() { return users_roles_id; }

    public void setUsers_roles_id(long users_roles_id) { this.users_roles_id = users_roles_id; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }

    public Roles getRoles() { return roles; }

    public void setRoles(Roles roles) { this.roles = roles; }

    // Identity
    @Override
    public String toString() {
        return "UsersRoles{" +
                "users_roles_id=" + users_roles_id +
                ", users=" + users +
                ", roles=" + roles +
                '}';
    }
}