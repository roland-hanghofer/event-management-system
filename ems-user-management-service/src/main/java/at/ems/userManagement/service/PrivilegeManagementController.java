package at.ems.userManagement.service;

import at.ems.domain.userManagement.Privilege;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/privileges")
public interface PrivilegeManagementController {

    @GetMapping()
    ResponseEntity<Collection<Privilege>> getPrivileges();

    @GetMapping("/forRole/{roleName}")
    ResponseEntity<Collection<Privilege>> getPrivilegesForRole(@PathVariable("roleName") String roleName);

    @PostMapping("/add")
    ResponseEntity<?> addPrivilege(@RequestBody Privilege newPrivilege);

    @GetMapping("/delete/{name}")
    ResponseEntity<?> deletePrivilege(@PathVariable("name") String name);
}
