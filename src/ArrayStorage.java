import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int size = size();
        storage[size] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++){
            if(storage[i].toString() == uuid){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] storageTemp = new Resume[10000];
        int j = 0;
        for (int i = 0; i < size(); i++){
            if(storage[i].toString() != uuid){
                storageTemp[j] = storage[i];
                j++;
            }
        }
        storage = storageTemp;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        return Arrays.copyOf(storage, size);
    }

    int size() {
        int size = 0;
        for (Resume r: storage) {
            if (r != null) {
                size++;
            }
        }
        return size;
    }
}
