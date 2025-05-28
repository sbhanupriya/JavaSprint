package ormrelationships.onetoone;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    private int did;
    @OneToOne
    @JoinColumn(name = "car-id-fk")
    private Car car;
    public int age;
    public int experience;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "did=" + did +
                ", car=" + car +
                ", age=" + age +
                ", experience=" + experience +
                '}';
    }
}
