
import java.util.*;
import java.util.concurrent.*;
public class AirportSimulation {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        List<Aircraft> aircraftList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int type = random.nextInt(3);
            int fuel = random.nextInt(10) + 1;
            Aircraft aircraft;
            switch (type) {
                case 0: aircraft = new PassengerPlane("P-" + i, fuel); break;
                case 1: aircraft = new CargoPlane("C-" + i, fuel); break;
                default: aircraft = new Helicopter("H-" + i, fuel); break;
            }
            aircraftList.add(aircraft);
            tower.registerAircraft(aircraft);
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            Aircraft a = aircraftList.get(random.nextInt(aircraftList.size()));
            a.consumeFuel();

            if (a.getFuelLevel() == 0) {
                a.send("MAYDAY", tower);
            } else {
                if (random.nextBoolean()) {
                    System.out.println(a.getId() + " requesting landing...");
                    tower.requestLanding(a);
                } else {
                    System.out.println(a.getId() + " requesting takeoff...");
                    tower.requestTakeoff(a);
                }
            }

            if (tower.requestRunway(a)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(a.getId() + " has completed runway operation.");
                tower.releaseRunway();
            }

        }, 0, 1, TimeUnit.SECONDS);
    }
}
