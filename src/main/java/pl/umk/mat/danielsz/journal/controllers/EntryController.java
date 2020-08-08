package pl.umk.mat.danielsz.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.umk.mat.danielsz.journal.model.Entry;
import pl.umk.mat.danielsz.journal.model.User;
import pl.umk.mat.danielsz.journal.services.EntryService;

import javax.validation.Valid;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable @NotBlank String id){
        entryService.deleteOne(id);

        return new  ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Entry patchOne(@RequestBody @NotNull @Valid Entry entry){
        return entryService.patchOne(entry);
    }
}
