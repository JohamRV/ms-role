package pe.edu.pucp.msrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pucp.msrole.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
