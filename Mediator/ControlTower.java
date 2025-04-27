import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new ConcurrentLinkedQueue<>();
    private Queue<Aircraft> takeoffQueue = new ConcurrentLinkedQueue<>();
    private boolean runwayAvailable = true;
    private List<Aircraft> allAircraft = new ArrayList<>();

    public void registerAircraft(Aircraft a) {
        allAircraft.add(a);
    }

    @Override
    public synchronized void broadcast(String msg, Aircraft sender) {
        System.out.println("[Tower received from " + sender.getId() + "]: " + msg);

        if (msg.equalsIgnoreCase("MAYDAY")) {
            System.out.println("[Tower]: Emergency! Clearing runway for " + sender.getId());
            landingQueue.add(sender);
            allAircraft.forEach(a -> {
                if (a != sender) a.receive("Hold position, emergency in progress!");
            });
            runwayAvailable = true;
        }
    }

    @Override
    public synchronized boolean requestRunway(Aircraft a) {
        if (!runwayAvailable) {
            System.out.println("[Tower]: Runway busy, " + a.getId() + " queued");
            landingQueue.add(a);
            return false;
        }

        // Clear emergency first
        Aircraft next;
        if (!landingQueue.isEmpty()) {
            next = landingQueue.poll();
            System.out.println("[Tower]: " + next.getId() + " cleared to LAND.");
            runwayAvailable = false;
            return a == next;
        }

        if (!takeoffQueue.isEmpty()) {
            next = takeoffQueue.poll();
            System.out.println("[Tower]: " + next.getId() + " cleared to TAKE OFF.");
            runwayAvailable = false;
            return a == next;
        }

        System.out.println("[Tower]: No one waiting. " + a.getId() + " cleared immediately.");
        runwayAvailable = false;
        return true;
    }

    public synchronized void releaseRunway() {
        runwayAvailable = true;
    }

    public void requestLanding(Aircraft a) {
        if (a.getFuelLevel() < 3) {
            System.out.println("[Tower]: " + a.getId() + " low fuel detected, priority landing.");
            landingQueue.add(a);
        } else {
            landingQueue.add(a);
        }
    }

    public void requestTakeoff(Aircraft a) {
        takeoffQueue.add(a);
    }
}
