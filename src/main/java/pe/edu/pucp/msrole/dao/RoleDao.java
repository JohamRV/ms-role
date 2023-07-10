package pe.edu.pucp.msrole.dao;

import lombok.Data;
import org.springframework.stereotype.Component;
import pe.edu.pucp.msrole.entity.Role;

@Data
@Component
public class RoleDao {
    Role role;
}
