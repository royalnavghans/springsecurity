package com.example.springsecurity.Controller;

        import com.example.springsecurity.entity.User;
        import com.example.springsecurity.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.access.prepost.PreAuthorize;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/get")
    String method(){
        return "calling from unsecured method";
    }
    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    int method1(){
        return 4;
    }
    @GetMapping("/getBoolean")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    Boolean Method3(){
        return true;
    }



@GetMapping("/getByName/{name}")
public Optional<User> getting(@PathVariable String name){
        return  userService.findByName(name)
;}
    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.create(user);
    }
}
