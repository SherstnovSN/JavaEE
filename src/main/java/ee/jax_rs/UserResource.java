package ee.jax_rs;

import ee.ejb.UserPersistenceEJB;
import ee.model.User;
import ee.validation.ValidUser;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @EJB
    private UserPersistenceEJB userPersistence;

    @GET
    public List<User> getUsers() {
        return userPersistence.getUsers();
    }

    @GET
    @Path("{id}")
    public User getUserById(@PathParam("id") int id) {
        return userPersistence.getUserById(id);
    }

    @POST
    @Path("add")
    public void addUser(@ValidUser JsonObject json) {
        String name = json.getString("name");
        userPersistence.addUser(new User(name));
    }

}
