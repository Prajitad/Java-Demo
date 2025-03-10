package com.prajita.demo.config;


import com.prajita.demo.entity.Role;
import com.prajita.demo.entity.User;
import com.prajita.demo.repo.RoleRepo;
import com.prajita.demo.repo.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class Dataloader {

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;


    @PostConstruct
    public void init() {
        if(roleRepo.count() == 0) {
            Role admin = new Role();
            admin.setName("ROLE_ADMIN");
            Role user = new Role();
            user.setName("ROLE_USER");
            roleRepo.save(admin);
            roleRepo.save(user);
            User adminUser = new User();
            adminUser.setName("admin");
            adminUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
            adminUser.setUsername("admin");
            adminUser.setRole(admin);

            User roleUser = new User();
            roleUser.setName("user");
            roleUser.setPassword(new BCryptPasswordEncoder().
                    encode("user"));
            roleUser.setUsername("user");
            roleUser.setRole(user);

            userRepo.save(adminUser);
            userRepo.save(roleUser);
        }


    }
}