package com.example.coursework.service.route;

import com.example.coursework.model.Platform;
import com.example.coursework.model.Train;
import com.example.coursework.repository.ITrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
@Service
public class TrainServiceImpl implements ITrainService {
    @Autowired
    ITrainRepository repository;
    @Override
    public Train getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Train create(Train train) {
        return repository.save(train);
    }

    @Override
    public Train update(Train train) {
        repository.deleteById(train.getId());
        String id = train.getId();
        Platform platform = train.getPlatform();
        repository.save(train);
        train.setId(id);
        train.setPlatform(platform);

        return train;
    }

    @Override
    public Train delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Train> getAll() {
        return repository.findAll();

    }

}
