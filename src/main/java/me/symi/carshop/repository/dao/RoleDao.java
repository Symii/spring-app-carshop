package me.symi.carshop.repository.dao;

import me.symi.carshop.entity.Role;

public interface RoleDao {
    Role findRoleByName(String theRoleName);
}
