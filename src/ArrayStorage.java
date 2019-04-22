import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    int size = size();

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

        for (int i = 0; i < size; i++){

            if(uuid.equals(storage[i].toString())){
                storage[i] = null;
            }

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

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
