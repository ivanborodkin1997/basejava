import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int storageSize;

    void clear() {
        Arrays.fill(storage, 0, storageSize, null);
    }

    void save(Resume resume) {
        storage[storageSize] = resume;
        storageSize++;
    }

    Resume get(String uuid) {
        for (Resume resume : Arrays.copyOf(storage, storageSize)) {
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                storageSize--;
                break;
            }
        }

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                for (int k = i + 1; k < storage.length; k++) {
                    storage[k - 1] = storage[k];
                }
                storage[storage.length - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, storageSize);
    }

    int size() {
        return storageSize;
    }

}
