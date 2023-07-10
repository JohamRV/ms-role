package pe.edu.pucp.msrole.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PSTK_ROL_HAS_POLICY", schema = "pucp_stack")
public class RoleHasPermission {

    @EmbeddedId
    RoleHasPermissionKey roleHasPermissionKey;

}
