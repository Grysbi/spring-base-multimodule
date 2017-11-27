package model.repository;

import model.entity.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Roles
 *
 * @author gandrieu
 * @version 1.0
 */

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {

    /**
     * Search Roles by name
     *
     * @param name
     * @return Roles
     */
    @Query("SELECT r FROM Roles r WHERE r.name LIKE '%?1%'")
    Roles findRolesByName(String name);
}
