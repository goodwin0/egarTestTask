package com.egar.model.entity;

/**
 * Interface for DB entities.
 * Entities could be updated, deleted.
 */
public interface EntityDB {
    /**
     * @return primary key of entity. Need to delete entities.
     */
    int getId();

    /**
     * method update selected entity.
     */
    void update(EntityDB parameters);
}
