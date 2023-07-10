package pe.edu.pucp.msrole.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PSTK_POLICY", schema = "pucp_stack")
public class Permission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "POLICY_ID")
    private Integer permissionId;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
}
