package com.example.coursework.service.cancelledTrain;

import com.example.coursework.model.CancelledTrain;
import com.example.coursework.model.Train;
import com.example.coursework.repository.ICTrainRepository;
import com.example.coursework.repository.ITrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelledTrainServiceImpl implements ICancelledTrainService {
    @Autowired
    ICTrainRepository repository;
    @Override
    public CancelledTrain getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CancelledTrain create(CancelledTrain train) {
        return repository.save(train);
    }

    @Override
    public CancelledTrain update(CancelledTrain train) {

        repository.save(train);

        return train;
    }

    @Override
    public CancelledTrain delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<CancelledTrain> getAll() {
        return repository.findAll();

    }
    public void deleteAll(){
        repository.deleteAll();
    }
}
