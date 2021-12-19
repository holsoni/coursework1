package com.example.coursework.service.train;

import com.example.coursework.model.Route;
import com.example.coursework.repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RootServiceImpl implements IRootService {

    @Autowired
    IRouteRepository repository;
    @Override
    public Route getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Route create(Route route) {
        return repository.save(route);
    }

    @Override
    public Route update(Route route) {
        repository.deleteById(route.getId());
        repository.save(route);
        return route;
    }

    @Override
    public Route delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Route> getAll() {
        return repository.findAll();
    }
}
