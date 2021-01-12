package ee.jax_rs;

import ee.ejb.UserPersistanceEJB;
import ee.model.User;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @EJB
    private UserPersistanceEJB userPersistance;

    @GET
    public List<User> getUsers() {
        return userPersistance.getUsers();
    }

}
