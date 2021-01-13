package ee.cdi;

import ee.ejb.UserPersistenceEJB;
import ee.model.User;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UserAddition {

    @EJB
    private UserPersistenceEJB userPersistence;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addUser() {
        userPersistence.addUser(new User(name));
    }

}
