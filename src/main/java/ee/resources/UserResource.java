package ee.resources;

import ee.model.User;
import ee.model.UsersBase;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UsersBase usersBase;

    @GET
    public List<User> getUsers() {
        return usersBase.getUsers();
    }

    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") int id) {
        return  usersBase.getUserById(id);
    }

}
