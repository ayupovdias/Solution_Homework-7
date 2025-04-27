class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[PassengerPlane " + id + " received]: " + msg);
    }
}

class CargoPlane extends Aircraft {
    public CargoPlane(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[CargoPlane " + id + " received]: " + msg);
    }
}

class Helicopter extends Aircraft {
    public Helicopter(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[Helicopter " + id + " received]: " + msg);
    }
}
