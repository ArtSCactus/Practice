/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Harbor;

/**
 *
 * @author ArtSCactus
 */
public class Storage {

    /**
     * Contains amount of containers ate this moment.
     *
     */
    private int storage;
    /**
     * Contains maximal amount of containers.
     *
     */
    private final int capacity;

    /**
     * Constructs new storage.
     *
     * @param capacity
     * @param storage
     * @throws IllegalArgumentException if storage or capacity less than 0, or
     * capacity equals 0, or storage are bigger than capacity.
     */
    public Storage(int capacity, int storage) throws IllegalArgumentException {
        if (storage < 0 | capacity <= 0) {
            throw new IllegalArgumentException("Storage or capacity cannot be less than 0");
        }
        if (storage > capacity) {
            throw new IllegalArgumentException("Storage cannot be bigger than capacity");
        }
        this.capacity = capacity;
        this.storage = storage;
    }

    /**
     * Returns containers form this storage. If requested containres are more
     * than this storage has, will be returned all containers that this sorage
     * has.
     *
     *
     * @param containers
     * @return containers
     */
    public int takeFromStorage(int containers) throws IllegalArgumentException {
        if (containers < 0) {
            throw new IllegalArgumentException("Containers cannot be less than 0");
        }
        if (containers > storage) {
            int transporting = storage;
            storage = 0;
            return transporting;
        }
        storage -= containers;
        return containers;
    }

    /**
     * Adding to the storage new containers. If storage cannot take all
     * containers, it will take as much as ше can ю
     *
     * @param containers
     * @return rest of containers, that cannot be plaeced to the storage.
     */
    public int addToStorage(int containers) {
        if (containers + storage > capacity) {
            storage += capacity - storage;
            return containers - (capacity - storage);
        } else {
            storage += containers;
            return 0;
        }
    }

    /**
     * Returns in a row port congestion informationю
     *
     * @return storage+"/"+capacity
     */
    public String getStorageStatus() {
        return storage + "/" + capacity;
    }

    /**
     * Returns true if storage has atleast 1 free space.
     *
     * @return true/false
     */
    public boolean isPossibleToadd() {
        if (capacity == storage) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns available space in this storage, that can be filled by
     * containers.
     *
     * @return amount of free space
     */
    public int getFreeSpace() {
        return capacity - storage;
    }

    /**
     * Returns true if storage has atleast 1 container. False otherwise.
     *
     * @return true/false
     */
    public boolean isPossibleToTake() {
        if (storage == 0) {
            return false;
        } else {
            return true;
        }
    }
}
