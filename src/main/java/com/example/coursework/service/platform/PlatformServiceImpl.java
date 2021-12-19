package com.example.coursework.service.platform;

import com.example.coursework.model.Platform;
import com.example.coursework.model.Train;
import com.example.coursework.repository.IPlatformRepository;
import com.example.coursework.repository.ITrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements IPlatformService {
    @Autowired
    IPlatformRepository repository;
    @Override
    public Platform getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Platform create(Platform platform) {
        return repository.save(platform);
    }

    @Override
    public Platform update(Platform platform) {
        repository.save(platform);
        return platform;
    }

    @Override
    public Platform delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Platform> getAll() {
        return repository.findAll();
    }

}
