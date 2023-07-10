package pe.edu.pucp.msrole.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class RoleHasPermissionKey implements Serializable {

    @Column(name = "FK_ROL_ID")
    private Integer rolId;

    @Column(name = "FK_POLICY_ID")
    private Integer permissionId;

}
