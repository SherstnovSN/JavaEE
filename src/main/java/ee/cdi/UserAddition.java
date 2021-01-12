package ee.cdi;

import ee.ejb.UserPersistanceEJB;
import ee.model.User;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UserAddition {

    @EJB
    private UserPersistanceEJB userPersistance;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addUser() {
        userPersistance.addUser(new User(name));
    }

}
