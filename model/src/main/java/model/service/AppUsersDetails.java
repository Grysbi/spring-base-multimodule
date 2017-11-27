package model.service;

import model.entity.Roles;
import model.entity.Users;
import model.repository.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * AppUsersDetails
 *
 * @author gandrieu
 * @version 1.0
 */

public class AppUsersDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    // Properties
    private Users users;
    private UsersRepository usersRepository;

    // Constructor
    public AppUsersDetails(){ }

    public AppUsersDetails(Users users, UsersRepository usersRepository){
        this.users = users;
        this.usersRepository = usersRepository;
    }

    /**
     * Interface
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Roles roles : usersRepository.getRoles(users.getUsers_id())) {
            authorities.add(new SimpleGrantedAuthority(roles.getName()));
        }
        return authorities;
    }

    // Getters / setters
    public static long getSerialVersionUID() { return serialVersionUID; }

    public Users getUsers() { return users; }

    public void setUsers(Users users) { this.users = users; }

    public UsersRepository getUsersRepository() { return usersRepository; }

    public void setUsersRepository(UsersRepository usersRepository) { this.usersRepository = usersRepository; }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getLogin();
    }

    // Config
    // User account is never expire
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // User account is never blocked
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // User account is never expire
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // User account is always enable
    @Override
    public boolean isEnabled() {
        return true;
    }
}
