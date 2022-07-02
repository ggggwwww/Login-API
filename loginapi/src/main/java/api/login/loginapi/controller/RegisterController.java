package api.login.loginapi.controller;

<<<<<<< HEAD
import api.login.loginapi.entity.User;
import api.login.loginapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class RegisterController {

    private final UserRepository userRepository;

    @PostMapping("/register")
    String registerUser(@ModelAttribute User user){

        userRepository.insertMember(user);
        log.info("uid={}, id={}, pw={}, nickname={}", user.getUid(), user.getId(), user.getPw(), user.getNickname());
        return "";
    }

    @GetMapping()
    List<User> showAllUsers(){
        log.info("users={}", userRepository.getAll());
        return userRepository.getAll();
    }
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @PostMapping("/register")
    String registerUser(){

        return "";
    }
>>>>>>> origin/master
}
