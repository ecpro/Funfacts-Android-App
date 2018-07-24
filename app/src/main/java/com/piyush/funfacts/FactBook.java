package com.piyush.funfacts;

public class FactBook {

    private FunFacts funFacts;
    private ColorWheel colorWheel;

    public FactBook() {
        this.funFacts = new FunFacts();
        this.colorWheel = new ColorWheel();
    }

    public FunFacts getFunFacts() {
        return funFacts;
    }

    public ColorWheel getColorWheel() {
        return colorWheel;
    }
}
