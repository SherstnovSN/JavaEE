package ee.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public User getUserById(int id) {
        Optional<User> user = users.stream().filter(s -> s.getId() == id).findFirst();
        if (user.isPresent()) {
            return user.get();
        } else throw new IllegalArgumentException("No users with such id");
    }

}
