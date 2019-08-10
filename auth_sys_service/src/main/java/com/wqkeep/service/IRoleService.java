package com.wqkeep.service;

import com.wqkeep.domain.Permission;
import com.wqkeep.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, List<String> permissionIds);
}
