package org.hg.commons;

public class SixAxis {
    private int id;
    private double S;
    private double L;
    private double U;
    private double R;
    private double B;
    private double T;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getS() {
        return S;
    }

    public void setS(double s) {
        S = s;
    }

    public double getL() {
        return L;
    }

    public void setL(double l) {
        L = l;
    }

    public double getU() {
        return U;
    }

    public void setU(double u) {
        U = u;
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
        return "SixAxis{" +
                "id=" + id +
                ", S=" + S +
                ", L=" + L +
                ", U=" + U +
                ", R=" + R +
                ", B=" + B +
                ", T=" + T +
                '}';
    }
}
