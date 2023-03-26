package persistence;

import java.util.ArrayList;
import java.util.List;

public interface StorageService<T extends Record> {
    T add(T data);

    default List<T> getAll() {
        return new ArrayList<>();
    };
}
