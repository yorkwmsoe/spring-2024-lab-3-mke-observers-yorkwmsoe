/*
 * Course:     SWE 2410
 * Assignment: MKETour
 * Author:     Dr. Yoder and YOUR NAME HERE
 */
package mketour.actors;

import javafx.scene.image.Image;
import mketour.CityMap;

/**
 * Simplification (!) of the Milwaukee County Transit System.
 * A Mobile Entity that drives in a fixed rectangular loop.
 * Although the buses start off of the loop, they quickly find it.
 */
public class Bus extends MobileEntity {
    private static final Image BUS_IMAGE =
            new Image(CityMap.class.getResource("img/bus.png").toString());

    /** x coordinates of the bus's route */
    public static final int LEFT_EDGE = 100;
    public static final int RIGHT_EDGE = 600;

    /** y coordinates of the bus's route */
    public static final int TOP_EDGE = 50;
    public static final int BOTTOM_EDGE = 400;

    public Bus(CityMap cityMap) {
        super(cityMap, BUS_IMAGE);
        setName("Bus "+ MobileEntity.instanceCount);
    }

    /**
     * Take one simulation step forward, towards or continuing to follow the loop.
     */
    @Override
    protected void step() {
        super.step();
        checkBounds(LEFT_EDGE, RIGHT_EDGE, TOP_EDGE, BOTTOM_EDGE);
    }
}
