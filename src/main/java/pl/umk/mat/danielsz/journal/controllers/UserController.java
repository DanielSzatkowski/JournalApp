package pl.umk.mat.danielsz.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.umk.mat.danielsz.journal.model.User;
import pl.umk.mat.danielsz.journal.services.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public User findOne(@PathVariable("id") String id){
        return userService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public User create(@RequestBody @NotNull User user){
        return userService.create(user);
    }

    //usuwanie usera
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        return userService.deleteOne(id);
    }

    //patchowanie usera
    @PatchMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public User patch(@PathVariable String id, @RequestBody @NotNull @Valid User user){
        return userService.patch(user);
    }

    //dodawanie entries do usera

    //usuwanie entry usera

    //patchowanie entry usera
}
