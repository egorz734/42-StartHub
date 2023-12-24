package ru.hse.starthub.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartupDTO {

    private Long id;
    private String name;
    private String description;
    private String owner;
}
