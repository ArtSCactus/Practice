/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Harbor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров,
 * находящихся в текущий момент в порту и на корабле, должно быть
 * неотрицательным и превышающим заданную грузоподъемность судна и вместимость
 * порта. В порту работает несколько причалов. У одного причала может стоять
 * один корабль. Корабль может загружаться у причала или разгружаться.
 *
 * @author ArtSCactus
 * @version 1.0
 */
public class Harbor {

    /**
     * Needs to control ships thread.
     *
     */
    private Semaphore trafficControl;
    /**
     * Harbor's main storage.
     *
     */
    private Storage storage;
    /**
     * Queue of ships, that was comming to load and has been denied by harbor.
     *
     */
    private Queue<Ship> waitingToUnloadShips = new LinkedList<>();
    /**
     * Queue of ships, that was comming to unload and has been denied by harbor.
     *
     */
    private Queue<Ship> waitingToLoadShips = new LinkedList<>();

    /**
     * Constructs the harbor. Default storage value are 0.
     *
     * @param capacity - maximal containers amount.
     * @param berths - number of berts(threads) that can work at the same time.
     * @throws IllegalArgumentException if capacity or berths less or equals 0
     */
    public Harbor(int capacity, int berths) throws IllegalArgumentException{
        if (capacity <= 0 | berths <= 0) {
            throw new IllegalArgumentException("Capacity or berths amount cannot be less or equals 0");
        }
        storage = new Storage(capacity, 0);
        trafficControl = new Semaphore(berths, true);
    }

    /**
     * Accepting ship to the berth and docking it. If flag toLoad are true,
     * tcurrent ship will be loading at this berth. Unloding otherwise.
     *
     * Can reject docking of current ship. For example: ship may arrive to
     * unload cargo, but harbor's storage are full.In this case ship docking
     * will be rejected and ship will be ordered to the
     * <code>waitingToUnloadShips</code> queue. Same case will be if ship would
     * arrive to the harbor to load, but harbor's storage are empty.
     *
     *
     * @param ship - current ship, that docking to the berth
     * @param toLoad - flag, that shows aim of the visit.
     * @return true if ship was successfully docked and loaded/unloaded. False
     * otherwise.
     * @throws InterruptedException
     * @throws NullPointerException if ship are null
     */
    public boolean acceptShip(Ship ship, boolean toLoad) throws InterruptedException {
        if (ship == null) {
            throw new NullPointerException("Ship cannot be null");
        }
        //Checking is possible to accept current ship to load/unload in this harbor
        if (isPossibleToAccept(toLoad)) {
            //If it possible - docking and starting the load/unload 
            ship = ship.docking(ship, storage, toLoad);
            ship.start();
            return true;
        } else {
            //Otherwise showing the reason of reject and ordering to queue.
            if (toLoad) {
                System.out.println("Cannot accept ship " + ship.getShipName() + " to load. Cause: harbor storage is empty.");
                waitingToLoadShips.add(ship);
                return false;
            } else {
                System.out.println("Cannot accept ship " + ship.getShipName() + " to unload. Cause: harbor storage is full.");
                waitingToUnloadShips.add(ship);
                return false;
            }
        }
    }
/**Returns true if storage has opportunity to take more cargo or to give cargo.
 * 
 * @param toLoad - aim of visit (action flag)
 * @return true if it possible. False otherwise
 */
    private boolean isPossibleToAccept(boolean toLoad) {
        if (toLoad) {
            return storage.isPossibleToTake();
        } else {
            return storage.isPossibleToadd();
        }
    }
/**Returns trafiic control to the ships.
 * 
 * @return trafficControl
 */
    public Semaphore getTrafficControl() {
        return trafficControl;
    }
/**Method to test harbor's functional.
 * 
 * @throws InterruptedException 
 */
    public void testClass() throws InterruptedException {
        Harbor harbor = new Harbor(2000, 2);
        harbor.acceptShip(new Ship("Maersk Alabama", harbor.getTrafficControl(), 200, 200), false);
        harbor.acceptShip(new Ship("Maersk Arkansas", harbor.getTrafficControl(), 200, 200), false);
        harbor.acceptShip(new Ship("Maersk Colorado", harbor.getTrafficControl(), 200, 200), false);
        harbor.acceptShip(new Ship("Maersk Washington", harbor.getTrafficControl(), 200, 200), false);
        harbor.acceptShip(new Ship("Maersk New Orlean", harbor.getTrafficControl(), 200, 0), true);
        harbor.acceptShip(new Ship("Maersk North Carolina", harbor.getTrafficControl(), 200, 0), true);
        harbor.acceptShip(new Ship("Maersk New York", harbor.getTrafficControl(), 200, 180), true);
        System.out.println("Is waiting to load now: " + waitingToLoadShips.size());
    }
}
