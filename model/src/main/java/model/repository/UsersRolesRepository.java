package model.repository;

import model.entity.UsersRoles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository UsersRoles
 *
 * @author gandrieu
 * @version 1.0
 */

@Repository
public interface UsersRolesRepository extends CrudRepository<UsersRoles, Long> {

}
