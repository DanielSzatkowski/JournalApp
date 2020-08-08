package pl.umk.mat.danielsz.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.umk.mat.danielsz.journal.model.Entry;
import pl.umk.mat.danielsz.journal.services.EntryService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/entries")
public class EntryController {
    private EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Entry findOne(@PathVariable("id") @NotBlank String id){
        return entryService.findById(id);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Entry> getAllEntriesOfUser(@PathVariable("id") @NotBlank String userId){
        return entryService.findAllUsersEntries(userId);
    }

    @PostMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Entry createOne(@RequestBody @NotNull Entry entry, @PathVariable("id") String userId){
        return entryService.save(entry, userId);
    }

    //TODO delete entry of the user

    //TODO patch entry
}
