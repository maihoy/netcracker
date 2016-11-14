package com.makarevich.beans;

/**
 * Created by j on 10.11.16.
 */
public abstract class Entity {
    protected Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        Entity entity = (Entity) o;

        return getId().equals(entity.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entity(Long id) {
        this.id = id;
    }

    public Entity(){}

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
