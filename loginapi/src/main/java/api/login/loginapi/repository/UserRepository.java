package api.login.loginapi.repository;

<<<<<<< HEAD
import api.login.loginapi.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    @Transactional
    public void insertMember(User user){

        em.persist(user);
    }

    public List getAll(){

        List result = em.createQuery("select id from User")
                .getResultList();

        return result;
    }

    public void deleteMember(User user){
        em.remove(user);
    }
=======
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class UserRepository {

    EntityManager em = new EntityManagerFactory() {
        @Override
        public EntityManager createEntityManager() {
            return null;
        }
    };


>>>>>>> origin/master
}
