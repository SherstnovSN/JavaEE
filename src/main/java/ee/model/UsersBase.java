package ee.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersBase {

    private List<User> users = new ArrayList<>();

    {
        User sam = new User(1, "Sam");
        User bob = new User(2, "Bob");
        User ann = new User(3, "Ann");
        Collections.addAll(users, sam, bob, ann);
    }

    public List<User> getUsers() {
        return users;
    }

}
