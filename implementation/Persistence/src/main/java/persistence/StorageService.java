package persistence;

import java.util.List;

public interface StorageService<T> {
    T add(T customerData);

    List<T> getAll();
}
