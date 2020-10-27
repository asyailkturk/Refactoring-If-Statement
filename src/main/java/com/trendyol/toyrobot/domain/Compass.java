package com.trendyol.toyrobot.domain;

import java.awt.*;

public enum Compass {
    NORTH(new Point(0,1)),
    EAST(new Point(1,0)),
    SOUTH(new Point(0,-1)),
    WEST(new Point(-1,0));

public final Point vector;


Compass(Point vector) {
        this.vector = vector;
    }

    public Compass left(){

         int left =ordinal() - 1;
         if (left <0){
             left = values().length - 1;
         }
         return Compass.values()[left];
    }
    public Compass right(){

        int right =ordinal() +  1;
        if (right > values().length){
            right=0;
        }
        return Compass.values()[right];
    }


}
