package api.login.loginapi.service;

import api.login.loginapi.entity.User;
import api.login.loginapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final UserRepository userRepository;

    public User login(String id, String pw){

        return userRepository.findUser(id, pw);
    }
}
