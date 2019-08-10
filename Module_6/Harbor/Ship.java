/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Harbor;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ArtSCactus
 */
public class Ship extends Thread {

    private final int capacity;
    private int containers;
    private String name;
    private Semaphore trafficControl;

    public Ship(String name, Semaphore trafficControl, int capacity, int containers) {
        if (name == null | trafficControl == null) {
            throw new NullPointerException("Ship name and semaphore cannot be null");
        }
        if (capacity <= 0 | containers < 0) {
            throw new IllegalArgumentException("Capacity cannot be less or equals 0, amount of containers cannot be less than 0");
        }
        if (capacity < containers) {
            throw new IllegalArgumentException("Capacity cannot be less than containers");
        }
        this.capacity = capacity;
        this.containers = containers;
        this.name = name;
        this.trafficControl = trafficControl;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getContainersAmount() {
        return containers;
    }

    private int load(int containers) {
        int rest = containers - (capacity - this.containers);
        this.containers += capacity - this.containers;
        return rest;
    }

    private int unload(int containers) {
        if (containers > this.containers) {
            int transporting = this.containers;
            this.containers = 0;
            return transporting;
        } else {
            this.containers -= containers;
            return containers;

        }
    }

    public Ship docking(Ship ship, Storage storage, boolean onLoad) throws InterruptedException {
        if (onLoad) {
            return new Ship(ship.name, ship.trafficControl, ship.capacity, ship.containers) {
                @Override
                public void run() {
                    if (trafficControl.availablePermits() == 0) {
                        System.out.println("All berths are busy. " + name + " is waiting for permission. Ships in queque " + trafficControl.getQueueLength());
                    } else {
                        System.out.println(name + " is waiting for permission");
                    }
                    try {
                        trafficControl.acquire();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(name + " got a permission");
                    System.out.println(name + " has started loading");
                    load(storage.takeFromStorage(getFreeSpace()));
                    System.out.println(name + " has finished loading. Ship status: " + ship.containers + "/" + capacity + ". Storage status: " + storage.getStorageStatus());
                    trafficControl.release();
                }
            };
        } else {
            return new Ship(ship.name, ship.trafficControl, ship.capacity, ship.containers) {
                @Override
                public void run() {
                    if (trafficControl.availablePermits() == 0) {
                        System.out.println("All berths are busy. " + name + " is waiting for permission. Ships in queque " + trafficControl.getQueueLength());
                    } else {
                        try {
                            trafficControl.acquire();
                        } catch (InterruptedException ex) {
                            System.out.println("Ship docking has been interrupted.");
                        }
                        System.out.println(name + " has got a permission. Docking to the free berth.");
                    }
                    System.out.println(name + " got a permission");
                    System.out.println(name + " has started unloading");
                    storage.addToStorage(unload(storage.getFreeSpace()));
                    System.out.println(name + " has finished unloading. Ship status: " + ship.containers + "/" + capacity + ". Storage status: " + storage.getStorageStatus());
                    trafficControl.release();
                }
            };

        }
    }

    public String getShipName() {
        return name;
    }
    public int getFreeSpace(){
        return capacity-containers;
    }
    @Override
    public void run() {
        System.out.println("The ship is on way to the harbor.");
    }
}
