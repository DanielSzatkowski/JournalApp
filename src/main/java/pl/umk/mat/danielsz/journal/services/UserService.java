package pl.umk.mat.danielsz.journal.services;

import pl.umk.mat.danielsz.journal.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
