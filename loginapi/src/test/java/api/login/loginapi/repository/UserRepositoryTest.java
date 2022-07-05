package api.login.loginapi.repository;

import api.login.loginapi.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void 유저삭제() throws Exception{
        //Given
        User user = new User();
        user.setUid(1L);
        user.setId("userA");
        user.setPw("1234");
        user.setNickname("sans");
        userRepository.insertMember(user);
        //When
        //userRepository.deleteMember(user.getUid());
        //Then
    }
}