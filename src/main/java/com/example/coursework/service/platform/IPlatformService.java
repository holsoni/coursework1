package com.example.coursework.service.platform;

import com.example.coursework.model.Platform;

import java.util.List;

public interface IPlatformService {

    Platform getById(String id);
    Platform create(Platform platform);
    Platform update(Platform platform);
    Platform delete(String id);
    List<Platform> getAll();
}
