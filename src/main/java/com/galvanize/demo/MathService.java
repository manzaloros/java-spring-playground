package com.galvanize.demo;

import java.util.List;

import static java.lang.Integer.*;

public class MathService {
    private int x = 0;
    private int y = 0;
    private int result = 0;

    public String add() {
        result = this.x + this.y;
        return this.x + " + " + this.y + " = " + result;
    }

    public String add(List<String> nums) {
        StringBuilder response = new StringBuilder();
        int result = 0;
        int size = nums.size();

        for (String number : nums) {
            result += Integer.parseInt(number);
        }

        for (int i = 0; i < size; i += 1) {
            String num = nums.get(i);
            if (i != size - 1) {
                response.append(num).append(" + ");
            } else {
                response.append(num).append(" = ").append(result);
            }
        }

        return response.toString();
    }

    public String multiply() {
        result = this.x * this.y;
        return this.x + " * " + this.y + " = " + result;
    }

    public String subtract() {
        result = this.x - this.y;
        return this.x + " - " + this.y + " = " + result;
    }

    public String divide() {
        result = this.x / this.y;
        return this.x + " / " + this.y + " = " + result;
    }

    public MathService() {}

    public MathService(String x, String y) {
        this.x = parseInt(x);
        this.y = parseInt(y);
    }
}
