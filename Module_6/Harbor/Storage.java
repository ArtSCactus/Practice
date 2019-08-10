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

    private int storage;
    private final int capacity;

    public Storage(int capacity, int storage) {
        if (storage < 0 | capacity < 0) {
            throw new IllegalArgumentException("Storage or capacity cannot be less than 0");
        }
        if (storage > capacity) {
            throw new IllegalArgumentException("Storage cannot be bigger than capacity");
        }
        this.capacity = capacity;
        this.storage = storage;
    }

    public int takeFromStorage(int containers) {
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

    public int addToStorage(int containers) {
        if (containers + storage > capacity) {
            storage += capacity - storage;
            return containers - (capacity - storage);
        } else {
            storage += containers;
            return 0;
        }
    }

    public String getStorageStatus() {
        return  storage + "/" + capacity;
    }

    public boolean isPossibleToadd() {
        if (capacity == storage) {
            return false;
        } else {
            return true;
        }
    }
public int getFreeSpace(){
    return capacity-storage;
}
    public boolean isPossibleToTake() {
        if (storage == 0) {
            return false;
        } else {
            return true;
        }
    }
}
