package pl.umk.mat.danielsz.journal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.umk.mat.danielsz.journal.model.Entry;

public interface EntryRepository extends MongoRepository<Entry, String> {}
