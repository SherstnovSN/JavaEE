package ee.jax_rs;

import ee.ejb.UserPersistanceEJB;
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
    private UserPersistanceEJB userPersistance;

    @GET
    public List<User> getUsers() {
        return userPersistance.getUsers();
    }

    @GET
    @Path("{id}")
    public User getUserById(@PathParam("id") int id) {
        return userPersistance.getUserById(id);
    }

    @POST
    @Path("add")
    public void addUser(@ValidUser JsonObject json) {
        String name = json.getString("name");
        userPersistance.addUser(new User(name));
    }

}
