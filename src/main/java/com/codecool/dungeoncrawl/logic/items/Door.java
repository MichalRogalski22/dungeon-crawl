package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public class Door implements Drawable {

    private Cell cell;
    private boolean isOpen;

    public Door(Cell cell) {
        this.cell = cell;
        this.isOpen = false;
    }

    @Override
    public String getTileName() {
        return "door";
    }
}
