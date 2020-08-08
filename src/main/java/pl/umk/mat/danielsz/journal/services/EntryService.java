package pl.umk.mat.danielsz.journal.services;

import org.springframework.http.ResponseEntity;
import pl.umk.mat.danielsz.journal.model.Entry;

import java.util.List;

public interface EntryService {
    List<Entry> saveAll(List<Entry> entries);

    void deleteAll(List<Entry> entries);

    Entry findById(String id);

    List<Entry> findAllUsersEntries(String userId);

    Entry save(Entry entry, String userId);

    ResponseEntity<Void> deleteOne(String id);
}
