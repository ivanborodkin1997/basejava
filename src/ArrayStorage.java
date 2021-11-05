import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int storageSize;

    void clear() {
        for (int i = 0; i <= storage.length; i++) {
            if (storage[i] == null) {
                Arrays.fill(storage, 0, i, null);
                break;
            }
        }
    }

    void save(Resume resume) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = resume;
                storageSize++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume[] resumes = getAll();

        for (Resume resume : resumes) {
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
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            }
        }
        return Arrays.copyOf(storage, count);
    }

    int size() {
        return storageSize;
    }

}
