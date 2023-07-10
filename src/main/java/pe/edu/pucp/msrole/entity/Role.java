package pe.edu.pucp.msrole.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "PSTK_ROL", schema = "pucp_stack")
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ROL_ID")
    private Integer rolId;

    @Basic
    @Column(name = "NAME")
    @NotNull(message = "The name must not be null.")
    @NotBlank(message = "The name must not be empty.")
    private String rolName;

    @Basic
    @Column(name = "DESCRIPTION")
    private String description;

}
