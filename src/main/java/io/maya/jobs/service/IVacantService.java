package io.maya.jobs.service;

import io.maya.jobs.model.Vacant;

import java.util.List;

public interface IVacantService {
    List<Vacant> getAll();

    Vacant getById(Integer id);

    void save(Vacant vacant);

    void deleteById(Integer id);
}
