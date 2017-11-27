package model.service;

import model.entity.Users;
import model.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service AppUsersDetailService
 *
 * @author gandrieu
 * @version 1.0
 */

@Service
public class AppUsersDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    /**
     * User details
     * @param login
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // Search Users by login name
        Users users = usersRepository.findUsersByLogin((login));

        if (users == null){

            throw new UsernameNotFoundException(String.format("Login [%s] not found", login));
        }

        // return Users details
        return new AppUsersDetails(users, usersRepository);
    }
}