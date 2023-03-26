package businesslogic.api.manager;

import java.util.Set;

public interface Manager<T extends Record> {
    T add(T t);

    void delete(T t);

    Set<T> getAll();
}
