package persistence.entity;

import jdbc.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class MyPersistenceContext implements PersistenceContext {
    private Map<Class<?>, Map<Long, Object>> entities = new HashMap<>();

    @Override
    public <T> T getEntity(Class<T> clazz, Long id) {
        Map<Long, Object> entityMap = entities.getOrDefault(clazz, new HashMap<>());
        return (T) entityMap.get(id);
    }

    @Override
    public void addEntity(Long id, Object entity) {
        entityPersister.insert(entity);
        entities.put(entity., entity);
    }

    @Override
    public void removeEntity(Object entity) {
        entities.values().remove(entity);
    }
}
