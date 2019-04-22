import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = 0;

    void clear() {
        for (int i = 0; i < this.size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++){
            if(uuid.equals(storage[i].toString())){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean flag = false;
        for (int i = 0; i < size - 1; i++){
            if(uuid.equals(storage[i].toString())){
                flag = true;
            }
            if(flag){
                storage[i] = storage[i+1];
            }
        }
        storage[storage.length-1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
