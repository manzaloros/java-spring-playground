package com.galvanize.demo;

import static java.lang.Integer.*;

public class MathService {
    private int x = 0;
    private int y = 0;
    private int result = 0;

    public String add() {
        result = this.x + this.y;
        return this.x + " + " + this.y + " = " + result;
    }

    public String multiply() {
        result = this.x * this.y;
        return this.x + " * " + this.y + " = " + result;
    }

    public MathService(String x, String y) {
        this.x = parseInt(x);
        this.y = parseInt(y);
    }
}
