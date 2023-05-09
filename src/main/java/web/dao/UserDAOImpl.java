package web.dao;

import org.springframework.stereotype.Repository;

import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user from User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUserById(Long id) {
        User user = entityManager.find(User.class, id);
        if(user!=null){
            entityManager.remove(user);
        }

    }

    @Override
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
    }
}
