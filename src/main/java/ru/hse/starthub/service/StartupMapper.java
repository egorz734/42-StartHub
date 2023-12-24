package ru.hse.starthub.service;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.hse.starthub.model.StartupModel;

@Component
@Mapper(componentModel = "spring")
public interface StartupMapper {

    StartupModel dtoToModel(StartupDTO startupDTO);

    StartupDTO modelToDto(StartupModel startupModel);
}
