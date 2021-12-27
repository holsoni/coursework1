package com.example.coursework.service.departuredTrain;

import com.example.coursework.model.DeparturedTrain;
import com.example.coursework.model.Train;
import com.example.coursework.repository.IDTrainRepository;
import com.example.coursework.repository.ITrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeparturedTrainServiceImpl implements IDeparturedTrainService {
    @Autowired
    IDTrainRepository repository;
    @Override
    public DeparturedTrain getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DeparturedTrain create(DeparturedTrain train) {
        return repository.save(train);
    }

    @Override
    public DeparturedTrain update(DeparturedTrain train) {

        repository.save(train);

        return train;
    }

    @Override
    public DeparturedTrain delete(String id) {
        repository.deleteById(id);

        return null;
    }

    @Override
    public List<DeparturedTrain> getAll() {
        return repository.findAll();

    }

    public void deleteAll(){
        repository.deleteAll();
    }
}
