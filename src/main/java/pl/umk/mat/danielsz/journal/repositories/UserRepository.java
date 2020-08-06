package pl.umk.mat.danielsz.journal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.umk.mat.danielsz.journal.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
