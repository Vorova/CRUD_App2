package com.vorova.dao;

import com.vorova.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    private final EntityManagerFactory emf;

    @Autowired
    public UserDaoImp(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<User> allUsers() {
        String sql = "from User";
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery(sql).getResultList();
    }

    @Override
    public void add(User user) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.persist(user);
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = emf.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void edit(User user) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.refresh(user);
    }

    @Override
    public User getById(long id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(User.class, id);
    }
}
