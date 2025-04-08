package model.entities;

public class Volunteer extends Person {
    private Character gander;
    private String work;
    private Address address;

    public Character getGander() {
        return this.gander;
    }

    public void setGander(Character gander) {
        this.gander = gander;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
