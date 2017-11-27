package model.repository;

import model.entity.Roles;
import model.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository Users
 *
 * @author gandrieu
 * @version 1.0
 */

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    /**
     * List Roles by Users ID
     * @param users_id
     * @return List Roles
     */
    @Query("SELECT ur.roles FROM UsersRoles ur WHERE ur.users.users_id=?1")
    Iterable<Roles> getRoles(long users_id);

    /**
     * List Roles by Users login and password
     * @param login
     * @param password
     * @return List Roles
     */
    @Query("SELECT ur.roles FROM UsersRoles ur WHERE ur.users.login=?1 AND ur.users.password=?2")
    Iterable<Roles> getRoles(String login, String password);

    /**
     * Search Users by login name
     * @param login
     * @return Users
     */
    Users findUsersByLogin(String login);
}
