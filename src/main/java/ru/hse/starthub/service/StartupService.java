package ru.hse.starthub.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hse.starthub.model.StartupModel;
import ru.hse.starthub.model.StartupRepository;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class StartupService {

    StartupRepository repository;
    StartupMapper mapper;

    @Autowired
    public StartupService(StartupRepository repository, StartupMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public StartupDTO create(StartupDTO startupDTO) {
        try {
            StartupModel startup = repository.save(mapper.dtoToModel(startupDTO));
            return mapper.modelToDto(startup);
        } catch (Exception e) {
            throw new WebApplicationException("Cannot create startup", Response.Status.BAD_REQUEST);
        }
    }

    public StartupDTO update(Long id, StartupDTO startupDTO) {
        if (repository.findById(id).isEmpty()) {
            throw new WebApplicationException("You are trying to update non-existent startup", Response.Status.BAD_REQUEST);
        }
        startupDTO.setId(id);
        try {
            return mapper.modelToDto(repository.save(mapper.dtoToModel(startupDTO)));
        } catch (Exception e) {
            throw new WebApplicationException("Cannot create startup", Response.Status.BAD_REQUEST);
        }
    }

    public List<StartupDTO> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).map(entity -> mapper.modelToDto(entity)).collect(Collectors.toList());
    }


}
