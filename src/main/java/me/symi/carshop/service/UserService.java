package me.symi.carshop.service;

import me.symi.carshop.entity.Customer;
import me.symi.carshop.security.user.WebUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Customer findByEmail(String userName);

    void save(WebUser webUser);

}
