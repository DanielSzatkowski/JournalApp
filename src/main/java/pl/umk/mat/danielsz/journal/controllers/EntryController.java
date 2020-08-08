package pl.umk.mat.danielsz.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.umk.mat.danielsz.journal.model.Entry;
import pl.umk.mat.danielsz.journal.services.EntryService;

import javax.validation.constraints.NotBlank;

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
    public Entry findOne(@NotBlank String id){
        return entryService.findById(id);
    }

    //TODO get all entries of user

    //TODO creating users entry

    //TODO delete entry of the user

    //TODO patch entry
}
