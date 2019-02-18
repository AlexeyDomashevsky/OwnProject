package entity;

import java.util.Objects;

public class Hotel {
    private String name;
    private double reviewScore;

    public Hotel() {
    }

    public Hotel(String name, double reviewScore) {
        this.name = name;
        this.reviewScore = reviewScore;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", reviewScore=" + reviewScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return Double.compare(hotel.getReviewScore(), getReviewScore()) == 0 &&
                getName().equals(hotel.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getReviewScore());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(double reviewScore) {
        this.reviewScore = reviewScore;
    }
}
