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
        for (int i = 0; i < storageSize - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                storageSize--;
                if (storageSize - i + 1 >= 0) {
                    System.arraycopy(storage, i + 1, storage, i + 1 - 1, storageSize - i + 1);
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
