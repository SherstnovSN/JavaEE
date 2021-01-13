package ee.ejb;

import ee.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserPersistanceEJB {

    @PersistenceContext(unitName = "javaee_datasource")
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return entityManager.createQuery("select entity from User entity").getResultList();
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public void addUser(User user) {
        entityManager.persist(user);
    }

}
