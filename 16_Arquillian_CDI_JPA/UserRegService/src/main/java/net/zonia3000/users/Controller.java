package net.zonia3000.users;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@RequestScoped
public class Controller {

    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Transactional
    public User addNewUser(String username) {
        if (isUsernameAvailable(username)) {
            User user = new User(username);
            em.persist(user);
            return user;
        }
        return null;
    }

    private boolean isUsernameAvailable(String username) {
        return getUser(username) == null;
    }

    public User getUser(String username) {
        TypedQuery<User> query = em.createNamedQuery("User.findByUsername", User.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }
}
