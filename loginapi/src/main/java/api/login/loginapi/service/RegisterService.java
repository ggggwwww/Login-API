package api.login.loginapi.service;

import api.login.loginapi.entity.User;
import api.login.loginapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;

    @Transactional
    public void registerUser(User user) {
        valDupId(user);
        userRepository.insertMember(user);
        log.info("user: uid={}, id={}, password={}, nickname={}",
                user.getUid(), user.getId(), user.getPw(), user.getNickname());


    }

    public void valDupId(User user){//ID 중복 검증
        List<User> userList = userRepository.getById(user.getId());
        if (!userList.isEmpty()){
            log.info("중복된 id");
            throw new IllegalStateException("Already exists member!");

        }
    }

    public List<User> showUsers() {
        //log.info("users={}", userRepository.getAll());

        return userRepository.getAll();
    }

    public List<User> showOne(String id) {

        log.info("{}", userRepository.getById(id));
        return userRepository.getById(id);
    }

    @Transactional
    public void deleteUser(Long uid) {
        userRepository.deleteMember(uid);
        //log.info("{}번 유저가 삭제되었습니다!", user.getUid());
    }
}
