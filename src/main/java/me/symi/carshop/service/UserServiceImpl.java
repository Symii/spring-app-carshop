package me.symi.carshop.service;

import me.symi.carshop.entity.Customer;
import me.symi.carshop.entity.Role;
import me.symi.carshop.repository.dao.RoleDao;
import me.symi.carshop.security.user.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService{

    private AppService appService;
    private RoleDao roleDao;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(AppService appService, RoleDao roleDao, BCryptPasswordEncoder passwordEncoder) {
        this.appService = appService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Customer findByEmail(String email) {
        return appService.findCustomerByEmail(email);
    }

    @Override
    public void save(WebUser webUser) {
        Customer user = new Customer();

        // assign user details to the user object
        user.setEmail(webUser.getEmail());
        user.setPassword(passwordEncoder.encode(webUser.getPassword()));
        user.setFirstName(webUser.getFirstName());
        user.setLastName(webUser.getLastName());
        user.setEmail(webUser.getEmail());
        user.setAdres(webUser.getAdres());
        user.setPhoneNumber(webUser.getPhoneNumber());
        user.setEnabled(true);

        // give user default role of "employee"
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));

        // save user in the database
        appService.saveCustomer(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer user = appService.findCustomerByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                authorities);
    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role tempRole : roles) {
            SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getName());
            authorities.add(tempAuthority);
        }

        return authorities;
    }

}
