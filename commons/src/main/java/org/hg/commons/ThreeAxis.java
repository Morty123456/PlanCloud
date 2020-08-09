package org.hg.commons;

public class ThreeAxis {
    private int id;
    private double R;
    private double B;
    private double T;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getT() {
        return T;
    }

    public void setT(double t) {
        T = t;
    }

    @Override
    public String toString() {
        return "ThreeAxis{" +
                "id=" + id +
                ", R=" + R +
                ", B=" + B +
                ", T=" + T +
                '}';
    }
}
