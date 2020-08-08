package pl.umk.mat.danielsz.journal.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umk.mat.danielsz.journal.model.Entry;
import pl.umk.mat.danielsz.journal.repositories.EntryRepository;
import pl.umk.mat.danielsz.journal.services.EntryService;

import java.util.List;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {
    private final EntryRepository entryRepository;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @Override
    public List<Entry> saveAll(List<Entry> entries) {
        return entryRepository.saveAll(entries);
    }

    @Override
    public void deleteAll(List<Entry> entries) {
        entryRepository.deleteAll(entries);
    }
}
