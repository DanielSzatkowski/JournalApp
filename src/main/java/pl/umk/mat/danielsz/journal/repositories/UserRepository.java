package pl.umk.mat.danielsz.journal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.umk.mat.danielsz.journal.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findOneByEntriesIn();
}
