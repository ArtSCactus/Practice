/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Harbor;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ArtSCactus
 */
public class Ship extends Thread {

    /**
     * Contains capacity of current ship. Cannot be 0 or less than 0. Cannot be
     * 0 or less than 0.
     */
    private final int capacity;
    /**
     * Contains current amount of containers. Cannot be less than 0.
     */
    private int containers;
    /**
     * Contains name of current ship. Cannot be null.
     */
    private String name;
    /**
     * Contains traffic control that uses the port to which the ship is heading.
     * Cannot be null.
     */
    private Semaphore trafficControl;

    /**
     * Constructs the ship.
     *
     * @param name - name of current ship
     * @param trafficControl - traffic control that uses the port to which the
     * ship is heading
     * @param capacity - maximal amount of containers for current ship
     * @param containers - contains amount of containers for current ship
     * @throws NullPointerException if name or trafficControl are null
     * @throws IllegalArgumentException if capacity or containers less than 0 or
     * if capacity equals 0. Also can be throwed if capacity are less than
     * containers.
     */
    public Ship(String name, Semaphore trafficControl, int capacity, int containers) throws NullPointerException, IllegalArgumentException {
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

    /**
     * Returns capacity of this ship.
     *
     * @return (int) capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Return amount of containers on this ship at this monent.
     *
     * @return (int) containers
     */
    public int getContainersAmount() {
        return containers;
    }

    /**
     * Loads the ship. If incomming amount of containers more than ship can
     * take, it will be returned as rest.
     *
     * @param containers containers that will be loaded on this ship
     * @return (int) rest of containers
     */
    private int load(int containers) {
        int rest = containers - (capacity - this.containers);
        this.containers += capacity - this.containers;
        return rest;
    }

    /**
     * Loads the ship. If incomming amount of containers more than ship can
     * give, it will return all containers that ship have.
     *
     * @param containers containers that will be loaded on this ship
     * @return containers from ship
     */
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

    /**
     * Allows to dock current ship and load or unload it to the harbor's
     * storage. Reorganaizes current object of Ship and overrides nethod run for
     * it depends on the purpose of the visit.
     *
     * Example of using:      <code>
     * Ship someShip = new Ship("Name", harbor's trafficControl, 200(capacity), 0 (containers));
     * ship = ship.docking(ship.getShipName(),  harbor.getTrafficControl(), ship.getCapacity(), ship.getContainers);
     * </code>
     *
     * @param ship - current ship
     * @param storage - access to harbor's storage
     * @param onLoad - true to load this ship. False to unload
     * @return same object, but with overrided <code>run()</code> method for
     * current situation.
     * @throws InterruptedException
     * @throws NullPointerException if ship or storage are null
     */
    public Ship docking(Ship ship, Storage storage, boolean onLoad) throws InterruptedException {
        if (ship == null | storage == null) {
            throw new NullPointerException("Ship or storage cannot be null");
        }
        if (onLoad) {
            //Returns same object, but with overrided tun() method,that will load the ship
            return new Ship(ship.name, ship.trafficControl, ship.capacity, ship.containers) {
                @Override
                public void run() {
                    //Checking available berths to dock to it.
                    if (trafficControl.availablePermits() == 0) {
                        System.out.println("All berths are busy. " + name
                                + " is waiting for permission. Ships in queque "
                                + trafficControl.getQueueLength());
                    } else {
                        System.out.println(name + " is waiting for permission");
                    }
                    try {
                        trafficControl.acquire();
                    } catch (InterruptedException ex) {
                        System.out.println("Ship docking has been interrupted.");

                    }
                    //Reporting situation and loading.
                    System.out.println(name + " got a permission");
                    System.out.println(name + " has started loading");
                    load(storage.takeFromStorage(getFreeSpace()));
                    System.out.println(name + " has finished loading. Ship status: "
                            + ship.containers + "/" + capacity + ". Storage status: "
                            + storage.getStorageStatus());
                    trafficControl.release();
                }
            };
        } else {
            //Returns same object, but with overrided run() method,that will unload the ship
            return new Ship(ship.name, ship.trafficControl, ship.capacity, ship.containers) {
                @Override
                public void run() {
                    //Checking available berths to dock to it.
                    if (trafficControl.availablePermits() == 0) {
                        System.out.println("All berths are busy. " + name
                                + " is waiting for permission. Ships in queque "
                                + trafficControl.getQueueLength());
                    } else {
                        try {
                            trafficControl.acquire();
                        } catch (InterruptedException ex) {
                            System.out.println("Ship docking has been interrupted.");
                        }
                        System.out.println(name + " has got a permission. Docking to the free berth.");
                    }
                    //Reporting situation and loading.
                    System.out.println(name + " got a permission");
                    System.out.println(name + " has started unloading");
                    storage.addToStorage(unload(storage.getFreeSpace()));
                    System.out.println(name + " has finished unloading. Ship status: "
                            + ship.containers + "/" + capacity + ". Storage status: "
                            + storage.getStorageStatus());
                    trafficControl.release();
                }
            };

        }
    }

    /**
     * Returns name of current ship.
     *
     * @return (String) name
     */
    public String getShipName() {
        return name;
    }

    /**
     * Returns available space for containers on this ship.
     *
     * @return amount of free space <code>capacity-containers</code>
     */
    public int getFreeSpace() {
        return capacity - containers;
    }

    /**
     * Runs current thread.
     *
     */
    @Override
    public void run() {
        System.out.println(name + " is on way to the harbor.");
    }
}
