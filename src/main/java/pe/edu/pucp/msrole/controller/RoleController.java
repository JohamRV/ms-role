package pe.edu.pucp.msrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pucp.msrole.dao.RoleDao;
import pe.edu.pucp.msrole.entity.Permission;
import pe.edu.pucp.msrole.entity.Role;
import pe.edu.pucp.msrole.entity.RoleHasPermission;
import pe.edu.pucp.msrole.entity.RoleHasPermissionKey;
import pe.edu.pucp.msrole.repository.RoleHasPermissionRepository;
import pe.edu.pucp.msrole.repository.RoleRepository;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleHasPermissionRepository roleHasPermissionRepository;

    @GetMapping(value = "/get-permissions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPermissionByEmail(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "roleId", required = false) Integer roleId){

        if(username != null){
            return new ResponseEntity(roleHasPermissionRepository.findPermissionsByUsername(username), HttpStatus.OK);
        } else if (roleId != null) {
            return new ResponseEntity(roleHasPermissionRepository.findPermissionsByRoleId(roleId), HttpStatus.OK);
        }else{
            Map<String, String> response = new HashMap<>();
            response.put("status", HttpStatus.BAD_REQUEST.getReasonPhrase());
            response.put("message", "Find permission by roleId or username (email).");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRole(@Valid @RequestBody RoleDao roleDao){
        Map<String, String> response = new HashMap<>();
        Role role = roleDao.getRole();
        roleRepository.save(role);
        response.put("status", HttpStatus.CREATED.getReasonPhrase());
        response.put("message", "Role saved successfully.");

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping("/assign-permission/{roleId}")
    public ResponseEntity assignPermissionsToRole(@PathVariable("roleId") String roleId, @RequestBody List<Permission> permissions){
        Map<String, String> response = new HashMap<>();
        RoleHasPermission roleHasPermission = new RoleHasPermission();
        RoleHasPermissionKey roleHasPermissionKey = new RoleHasPermissionKey();

        for(Permission permisssion : permissions){
            roleHasPermissionKey.setRolId(Integer.valueOf(roleId));
            roleHasPermissionKey.setPermissionId(permisssion.getPermissionId());
            roleHasPermission.setRoleHasPermissionKey(roleHasPermissionKey);
            roleHasPermissionRepository.save(roleHasPermission);
        }

        response.put("status", HttpStatus.OK.getReasonPhrase());
        response.put("message", "Permissions assigned successfully to rol "+ roleId +".");
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
