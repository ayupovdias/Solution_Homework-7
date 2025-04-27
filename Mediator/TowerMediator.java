public interface TowerMediator {
    void broadcast(String msf, Aircraft sender);
    boolean requestRunway(Aircraft a);
}
