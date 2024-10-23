public class Building {

    private String address;
    private String owner;
    private static int numBuildings = 0;

    public Building() {
        this.address = "";
        this.owner = "";
        Building.numBuildings++;
    }

    public Building(String address, String owner) {
        this.address = address;
        this.owner = owner;
        Building.numBuildings++;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String newOwner){
        this.owner = newOwner;
    }

    @Override
    public String toString() {
        return this.address + " occupied by " + this.owner;
    }

    public static int getNumBuildings() { return Building.numBuildings; }

    public boolean equals(Building anotherBuilding) {
        return this.getAddress().equals(anotherBuilding.getAddress());
    }
}
