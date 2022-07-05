package api.login.loginapi.repository;


import api.login.loginapi.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepository {
    private final EntityManager em;

    public void insertMember(User user) {

        em.persist(user);
    }

    public List<User> getAll() {

        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    public List<User> getById(String id) {

        String jpql = "select u from User as u where u.id = :id";

        return em.createQuery(jpql, User.class)
                .setParameter("id", id)
                .getResultList();
    }

    public void deleteMember(Long uid) {

        String jpql = "delete from User as u where u.uid = :uid";
        Query query = em.createQuery(jpql, User.class)
                .setParameter("uid", uid);

        query.executeUpdate();

        //em.remove(user);
    }


    public User findUser(String id, String pw) {
        String jpql = "select u from User as u where u.id = :id and u.pw = :pw";

        return em.createQuery(jpql, User.class)
                .setParameter("id", id)
                .setParameter("pw", pw)
                .getSingleResult();
    }

}
