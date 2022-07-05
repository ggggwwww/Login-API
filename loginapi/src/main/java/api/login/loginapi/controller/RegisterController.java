package api.login.loginapi.controller;

import api.login.loginapi.entity.User;
import api.login.loginapi.service.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class RegisterController {

    //private final UserRepository userRepository;
    private final RegisterService registerService;

    @PostMapping("/register")
    String registerUser(@ModelAttribute User user) {
        registerService.registerUser(user);
        return "register clear\nUser inform:\nid="+user.getId()+" nickname="+user.getNickname();
    }

    @GetMapping()
    List<User> showAllUsers() {

        return registerService.showUsers();
    }

    @GetMapping("/{userId}")
    List<User> showOneUser(@PathVariable("userId") String id){

        return registerService.showOne(id);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable("id") Long uid){

        registerService.deleteUser(uid);
        return "";
    }

}
