package ru.hse.starthub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.hse.starthub.model.StartupModel;
import ru.hse.starthub.service.StartupDTO;
import ru.hse.starthub.service.StartupService;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("startup")
public class StartupController {

    private final StartupService service;

    @Autowired
    public StartupController(StartupService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public StartupDTO create(@RequestBody StartupDTO startup) {
        return service.create(startup);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StartupDTO update(@PathVariable("id") Long id, @RequestBody StartupDTO startup) {
        return service.update(id, startup);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<StartupDTO> get() {
        return service.getAll();
    }

}
