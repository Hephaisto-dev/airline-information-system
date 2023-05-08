package businesslogic.impl;

import businesslogic.api.common.PersistantDataContainer;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import persistence.api.StorageService;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
class ManagerImplTest {
    @Mock
    private Record record;
    @Mock
    private PersistantDataContainer<Record> persistentDataContainer;
    @Mock
    private StorageService<Record> storageService;
    private ManagerImpl<PersistantDataContainer<Record>, Record> manager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(persistentDataContainer.getId()).thenReturn("id");
        when(persistentDataContainer.getData()).thenReturn(record);
        when(storageService.getAll()).thenReturn(Collections.singleton(record));
        manager = new ManagerImpl<>(storageService) {
            @Override
            protected PersistantDataContainer<Record> createPersistantDataContainer(Record record) {
                return persistentDataContainer;
            }
        };
        manager.add(persistentDataContainer);
    }

    @Test
    void addDuplicateReturnNull() {
        assertThat(manager.add(persistentDataContainer))
                .as("Duplicate should return null")
                .isEqualTo(null);
    }

    @Test
    void addReturnAddedObject() {
        manager.remove(persistentDataContainer);
        assertThat(manager.add(persistentDataContainer))
                .as("Should return added object")
                .isEqualTo(persistentDataContainer);
    }

    @Test
    void getAll() {
        assertThat(manager.getAll().contains(persistentDataContainer))
                .as("Should contain object")
                .isTrue();
    }

    @Test
    void getById() {
        assertThat(manager.getById("id"))
                .as("Should return object")
                .isEqualTo(persistentDataContainer);
    }

    @Test
    void remove() {
        when(storageService.remove(any())).thenReturn(true);
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(manager.remove(persistentDataContainer))
                    .as("Should return true")
                    .isEqualTo(true);
            softly.assertThat(manager.getAll().contains(persistentDataContainer))
                    .as("Should not contain object")
                    .isFalse();
        });
    }
}