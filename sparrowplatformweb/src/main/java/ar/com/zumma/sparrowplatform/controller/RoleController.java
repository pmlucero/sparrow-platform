package ar.com.zumma.sparrowplatform.controller;

import ar.com.zumma.sparrowplatform.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping({"", "/", "/roles"})
    public String getRolePage(Model model) {
        log.debug("Getting role page");
        model.addAttribute("roles", roleService.findAll());
        return "roles";
    }
}
