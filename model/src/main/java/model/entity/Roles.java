package model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Roles Entity
 *
 * @author gandrieu
 * @version 1.0
 */

@Entity
@Table(name = "roles")
public class Roles {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private long roles_id=0;

    @NotEmpty
    @Column(name = "name")
    private String name;

    // Constructor
    public Roles() { }

    public Roles(String name){
        this.name = name;
    }

    // Getters / Setters
    public long getRoles_id() { return roles_id; }

    public void setRoles_id(long roles_id) { this.roles_id = roles_id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    // Identity
    @Override
    public String toString() {
        return "Roles{" +
                "roles_id=" + roles_id +
                ", name='" + name + '\'' +
                '}';
    }
}

