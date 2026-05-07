package com.example.demo.service.impl;


import com.example.demo.domain.entity.Pirate;
import com.example.demo.repository.PirateRepository;
import com.example.demo.service.PirateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirateServiceImpl implements PirateService {

    private final PirateRepository pirateRepository;

    @Override
    public Pirate createPirate(Pirate pirate) {
        return pirateRepository.save(pirate);
    }

    @Override
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    @Override
    public Pirate getPirateById(UUID id) {
        return pirateRepository.findById(id).orElse(null);
    }

    @Override
    public Pirate updatePirate(UUID id, Pirate pirate) {

        Pirate existingPirate = pirateRepository.findById(id).orElse(null);

        if (existingPirate == null) {
            return null;
        }

        existingPirate.setName(pirate.getName());
        existingPirate.setBounty(pirate.getBounty());
        existingPirate.setCrew(pirate.getCrew());
        existingPirate.setIsAlive(pirate.getIsAlive());

        return pirateRepository.save(existingPirate);
    }

    @Override
    public Pirate deletePirate(UUID id) {

        Pirate existingPirate = pirateRepository.findById(id).orElse(null);

        if (existingPirate == null) {
            return null;
        }

        pirateRepository.deleteById(id);

        return existingPirate;
    }
}
