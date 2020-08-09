package pl.umk.mat.danielsz.journal.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.umk.mat.danielsz.journal.exceptions.NotFoundException;
import pl.umk.mat.danielsz.journal.exceptions.OperationNotAllowedException;
import pl.umk.mat.danielsz.journal.model.Entry;
import pl.umk.mat.danielsz.journal.model.User;
import pl.umk.mat.danielsz.journal.repositories.UserRepository;
import pl.umk.mat.danielsz.journal.services.EntryService;
import pl.umk.mat.danielsz.journal.services.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EntryService entryService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EntryService entryService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.entryService = entryService;
        this.modelMapper = modelMapper;
    }

    private User mapUserDto(User oldUser, User newUser) {
        modelMapper.map(newUser, oldUser);

        return oldUser;
    }

    public User saveOne(User user){
        return userRepository.save(user);
    }

    @Override
    public User findOneByEntriesIn(String id) {
        return userRepository.findOneByEntriesIn(id)
                .orElseThrow(() -> new OperationNotAllowedException("Cannot find that entry!"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Specified User does not exist!"));
    }

    @Override
    public User create(User user) {
        if(user == null){
            throw new OperationNotAllowedException("User is not specified!");
        }

        if(user != null && this.existsById(user.getId())){
            throw new OperationNotAllowedException("Specified user already exists!");
        }

        if(user.getEntries() != null && user.getEntries().size() > 0){
            List<Entry> entries = user.getEntries();
            List<Entry> allEntries = entryService.saveAll(entries);

            user.setEntries(allEntries);
        }

        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<Void> deleteOne(String id) {
        if(!existsById(id)){
            throw new OperationNotAllowedException("User doesn't exists!");
        }

        User user = findOne(id);

        entryService.deleteAll(user.getEntries());
        userRepository.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @Override
    public User patch(User user) {
        if(user.getId() == null){
            throw new OperationNotAllowedException("User id cannot be null!");
        }

        if(!existsById(user.getId())){
            throw new OperationNotAllowedException("User doesn't exist!");
        }

        User oldUser = findOne(user.getId());
        User patchedUser = mapUserDto(oldUser, user);

        return userRepository.save(patchedUser);
    }

    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }
}
