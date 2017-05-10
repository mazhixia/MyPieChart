package com.mzx.pc.myview.btn4;

/**
 * Created by pc on 2017/5/5.
 * 描述：
 * 作者：Mazhixia
 * 手机：
 * 微信：
 * 日期：2017/5/5
 */


public class PieData {

    private String name;
    private float value;
    private float percentage;
    private int color = 0;
    private float angle = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "PieData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", percentage=" + percentage +
                ", color=" + color +
                ", angle=" + angle +
                '}';
    }
}
