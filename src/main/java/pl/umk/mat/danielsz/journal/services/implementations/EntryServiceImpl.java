package pl.umk.mat.danielsz.journal.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umk.mat.danielsz.journal.exceptions.NotFoundException;
import pl.umk.mat.danielsz.journal.exceptions.OperationNotAllowedException;
import pl.umk.mat.danielsz.journal.model.Entry;
import pl.umk.mat.danielsz.journal.model.User;
import pl.umk.mat.danielsz.journal.repositories.EntryRepository;
import pl.umk.mat.danielsz.journal.services.EntryService;
import pl.umk.mat.danielsz.journal.services.UserService;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {
    private final EntryRepository entryRepository;
    private final UserService userService;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository, UserService userService) {
        this.entryRepository = entryRepository;
        this.userService = userService;
    }

    @Override
    public List<Entry> saveAll(List<Entry> entries) {
        return entryRepository.saveAll(entries);
    }

    @Override
    public void deleteAll(List<Entry> entries) {
        if(entries != null){
            entryRepository.deleteAll(entries);
        }
    }

    @Override
    public Entry findById(String id) {
        return entryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Repository not found!"));
    }

    @Override
    public List<Entry> findAllUsersEntries(String userId) {
        User user = userService.findOne(userId);

        return user.getEntries();
    }

    public Entry saveOne(@NotNull Entry entry){
        return entryRepository.save(entry);
    }

    @Override
    public Entry save(Entry entry, String userId) {
        Entry addedEntry = saveOne(entry);

        User user = userService.findOne(userId);
        List<Entry> userEntries = user.getEntries();
        userEntries.add(entry);
        user.setEntries(userEntries);

        userService.saveOne(user);

        return addedEntry;
    }
}
