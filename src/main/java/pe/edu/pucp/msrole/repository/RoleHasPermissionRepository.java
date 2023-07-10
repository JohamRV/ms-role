package pe.edu.pucp.msrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.pucp.msrole.entity.RoleHasPermission;
import pe.edu.pucp.msrole.entity.RoleHasPermissionKey;

import java.util.List;

@Repository
public interface RoleHasPermissionRepository extends JpaRepository<RoleHasPermission, RoleHasPermissionKey> {

    @Query(value = "SELECT p.NAME FROM pucp_stack.PSTK_ROL_HAS_POLICY rhp\n" +
            "INNER JOIN pstk_policy p ON rhp.FK_POLICY_ID = p.POLICY_ID\n" +
            "WHERE rhp.FK_ROL_ID = ?1 ;", nativeQuery = true)
    List<String> findPermissionsByRoleId(Integer roleId);
    @Query(value = "SELECT p.NAME FROM pucp_stack.pstk_rol_has_policy rhp\n" +
            "INNER JOIN pstk_policy p ON rhp.FK_POLICY_ID = p.POLICY_ID\n" +
            "INNER JOIN pstk_rol r ON rhp.FK_ROL_ID = r.ROL_ID\n" +
            "INNER JOIN pstk_user u ON r.ROL_ID = u.FK_ROL_ID\n" +
            "WHERE u.EMAIL = ?1 ;", nativeQuery = true)
    List<String> findPermissionsByUsername(String email);

}
