package com.example.demo.service;

import com.example.demo.domain.entity.Pirate;

import java.util.List;
import java.util.UUID;

public interface PirateService {
    Pirate createPirate(Pirate pirate);

    List<Pirate> getAllPirates();

    Pirate getPirateById(UUID id);

    Pirate updatePirate(UUID id, Pirate pirate);

    Pirate deletePirate(UUID id);
}
