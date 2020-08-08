package pl.umk.mat.danielsz.journal.services;

import pl.umk.mat.danielsz.journal.model.Entry;

import java.util.List;

public interface EntryService {
    List<Entry> saveAll(List<Entry> entries);

    void deleteAll(List<Entry> entries);

    Entry findById(String id);

    List<Entry> findAllUsersEntries(String userId);

    Entry save(Entry entry, String userId);
}
