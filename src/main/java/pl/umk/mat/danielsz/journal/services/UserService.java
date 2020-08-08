package pl.umk.mat.danielsz.journal.services;

import org.springframework.http.ResponseEntity;
import pl.umk.mat.danielsz.journal.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(String id);

    User create(User user);

    ResponseEntity<Void> deleteOne(String id);

    User patch(User user);

    User saveOne(User user);
}
