package api.login.loginapi.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid", nullable = false)
    private Long uid;

    @Column(name = "id", nullable = false, length = 8)
    private String id;

    @Column(name = "password", nullable = false, length = 14)
    private String pw;

    @Column(name = "nickname", length = 8)
    private String nickname;
}