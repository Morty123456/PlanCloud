package org.hg.commons;

public class ThreeAxis {
    private int id;
    private double r;
    private double b;
    private double t;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "ThreeAxis{" +
                "id=" + id +
                ", r=" + r +
                ", b=" + b +
                ", t=" + t +
                '}';
    }
}
