package com.metacoding.web_project.useraccount;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@RequiredArgsConstructor
@Repository
public class UserAccountRepository {
    private final EntityManager em;

    public UserAccount findByUsername(String name) {
        String sql = """
                select u from UserAccount u join fetch u.user where u.user.username=:username
                """;
        Query query = em.createQuery(sql);
        query.setParameter("username", name);
        return (UserAccount) query.getSingleResult();
    }

    public UserAccount findById(Integer userId){
        String sql  = """
                select u from UserAccount u join fetch u.user where u.user.id=:userId
                """;
        Query query = em.createQuery(sql);
        query.setParameter("userId", userId);
        query.setMaxResults(1);
        return (UserAccount) query.getSingleResult();
    }
}
