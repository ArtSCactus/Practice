/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Car;

/**
 * Task condition: 2. Создать объект класса Автомобиль, используя классы Колесо,
 * Двигатель. Методы: ехать, заправляться, менять колесо, вывести на консоль
 * марку автомобиля.
 *
 * @author ArtSCactus
 */
public class Car {

    private Wheel[] wheels;
    private Engine engine;
    private String carMark;
    private int fuel;
    private boolean moves;

    /**
     *
     * @param wheels
     * @param engine
     * @param carMark
     * @param fuel
     * @throws IllegalArgumentException
     */
    public Car(Engine engine, String carMark, int fuel, Wheel... wheels) throws IllegalArgumentException {
        this.wheels = wheels;
        this.engine = engine;
        if (carMark == null) {
            this.carMark = "Self-made";
        } else {
            this.carMark = carMark;
        }
        if (fuel < 0) {
            throw new IllegalArgumentException("Fuel cannot be less than 0");
        } else {
            this.fuel = fuel;
        }
    }

    /**
     *
     * @param fuel
     * @throws IllegalArgumentException
     */
    public void refill(int fuel) throws IllegalArgumentException {
        if (fuel < 0) {
            throw new IllegalArgumentException("Fuel cannot be less than 0");
        }
        if (fuel == 0) {
            this.fuel = fuel;
        } else {
            this.fuel += fuel;
        }
        System.out.println("Car was successfully refilled, current amount of fuel: " + this.fuel);

    }

    public void move(boolean moving) {
        if (fuel == 0) {
            System.out.println("No fuel, needs refill");
            return;
        }
        if (!engine.isOK()) {
            System.out.println("Engine are damaged, should be repaired");
            return;
        }
        for (Wheel wheel : wheels) {
            if (!wheel.isOK() | wheel == null) {
                System.out.println("Wheel are damaged or missing, should be replaced or repaired");
                return;
            }
        }
        if (moving == true) {
            moves = true;
            System.out.println("Car have started to move");
        } else {
            moves = false;
            System.out.println("Car have stopped it's moving");
        }
    }

    /**
     *
     * @param wheelNumber
     * @param wheel
     */
    public void replaceWheel(int wheelNumber, Wheel wheel) {
        if (wheelNumber < 0 | wheelNumber > wheels.length) {
            throw new IllegalArgumentException("No such wheel number");
        }
        wheels[wheelNumber] = wheel;
        System.out.println("Wheel successfully replaced");
    }

    public void printCarMark() {
        System.out.println(carMark);
    }

    /**
     *
     * @return
     */
    public boolean isMoving() {
        return moves;
    }

    public static void testClass() {
        Car car = new Car(new Engine(true, true, 100), "BMW", 15, new Wheel(63.5, Wheel.SeasonType.SUMMER, true),
                new Wheel(63.5, Wheel.SeasonType.SUMMER, true), new Wheel(63.5, Wheel.SeasonType.SUMMER, true),
                new Wheel(63.5, Wheel.SeasonType.SUMMER, true));
        System.out.print("Car mark: ");
        car.printCarMark();
        System.out.println("Car is moving: " + car.isMoving());
        car.move(true);
        System.out.println("Car is moving: " + car.isMoving());
        car.replaceWheel(0, new Wheel(63.5, Wheel.SeasonType.WINTER, true));
        car.replaceWheel(1, new Wheel(63.5, Wheel.SeasonType.WINTER, true));
        car.replaceWheel(2, new Wheel(63.5, Wheel.SeasonType.WINTER, true));
        car.replaceWheel(3, new Wheel(63.5, Wheel.SeasonType.WINTER, true));
        car.refill(15);
    }
}
