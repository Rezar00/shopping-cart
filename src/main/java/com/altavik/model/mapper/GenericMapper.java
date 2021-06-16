package com.altavik.model.mapper;

import java.util.List;

public interface GenericMapper<Entity, Dto> {
    Entity modelToEntity(Dto model);

    Dto entityToModel(Entity entity);

    List<Entity> modelsToEntities(List<Dto> modelList);

    List<Dto> entitiesToModels(List<Entity> entityList);
}
