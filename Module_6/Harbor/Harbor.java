/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Harbor;

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

    private Semaphore trafficControl;
    private Storage storage;

    public Harbor(int capacity, int berths) {
        if (capacity <= 0 | berths <= 0) {
            throw new IllegalArgumentException("Capacity or berths amount cannot be less or equals 0");
        }
        storage = new Storage(capacity, 0);
        trafficControl = new Semaphore(berths, true);
    }

    public boolean acceptShip(Ship ship, boolean toLoad) throws InterruptedException {        
        if (ship == null) {
            throw new NullPointerException("Ship cannot be null");
        }
        if (isPossibleToAccept(toLoad)) {
            ship = ship.docking(ship, storage, toLoad);
            ship.start();
            return true;
        } else {
            if (toLoad) {
                System.out.println("Cannot accept ship " + ship.getShipName() + " to load. Cause: harbor storage is empty.");
                return false;
            } else {
                System.out.println("Cannot accept ship " + ship.getShipName() + " to unload. Cause: harbor storage is full.");
                return false;
            }
        }
    }

    private boolean isPossibleToAccept(boolean toLoad) {
        if (toLoad) {
            return storage.isPossibleToTake();
        } else {
            return storage.isPossibleToadd();
        }
    }

    public Semaphore getTrafficControl() {
        return trafficControl;
    }

    public void testClass() throws InterruptedException {
        Harbor harbor = new Harbor(2000, 2);
        harbor.acceptShip(new Ship("Maersk Alabama", harbor.getTrafficControl(), 200, 200), false);
        harbor.acceptShip(new Ship("Maersk Arkansas", harbor.getTrafficControl(), 200, 200), false);
        harbor.acceptShip(new Ship("Maersk Colorado", harbor.getTrafficControl(), 200, 200), false);
        harbor.acceptShip(new Ship("Maersk Washington", harbor.getTrafficControl(), 200, 200), false);
        harbor.acceptShip(new Ship("Maersk New Orlean", harbor.getTrafficControl(), 200, 0), true);
        harbor.acceptShip(new Ship("Maersk North Carolina", harbor.getTrafficControl(), 200, 0), true);
        harbor.acceptShip(new Ship("Maersk New York", harbor.getTrafficControl(), 200, 180), true);
    }
}
