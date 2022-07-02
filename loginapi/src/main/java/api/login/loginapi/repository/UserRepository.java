package api.login.loginapi.repository;

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


}
