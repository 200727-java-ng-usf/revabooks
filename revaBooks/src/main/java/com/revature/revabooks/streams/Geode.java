package com.revature.revabooks.streams;

public class Geode {
    private String Color;
    private String name;

    public Geode(String color, String name) {
        Color = color;
        this.name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Geode{" +
                "Color='" + Color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
