package ar.com.zumma.sparrowplatform.bootstrap;

import ar.com.zumma.sparrowplatform.model.Role;
import ar.com.zumma.sparrowplatform.model.User;
import ar.com.zumma.sparrowplatform.services.RoleService;
import ar.com.zumma.sparrowplatform.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class UserRoleBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private final RoleService roleService;
    private final UserService userService;

    public UserRoleBootstrap(RoleService roleService, UserService userService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        log.debug("Bootstrap User-Role ---------------");

        Optional<User> ouser = userService.findByEmail("administrator@zumma.com.ar");
        if (!ouser.isPresent()) {
            User user = new User();
            user.setFirstName("Administrador");
            user.setEmail("administrator@zumma.com.ar");

            Role role = new Role();
            role.setName("ADMIN");
            role.setDescription("Administrator");
            role.setLevel(1);
            user.getRoles().add(role);
            roleService.save(role);

            role = new Role();
            role.setName("USER");
            role.setDescription("Simple User");
            role.setLevel(10);
            user.getRoles().add(role);
            roleService.save(role);

            userService.save(user);
            log.info(user.toString());

        }
        log.debug(ouser.isPresent() ? ouser.get().toString() : null);
    }
}
