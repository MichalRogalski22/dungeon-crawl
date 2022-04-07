//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private static Player player;
    private static ArrayList<Goblin> goblins = new ArrayList<>();
    private static ArrayList<Ghost> ghosts = new ArrayList<>();
    private static ArrayList<Monster> monsters = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Skeleton> skeletons = new ArrayList<>();

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];

        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                this.cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public static ArrayList<Skeleton> getSkeletons() {
        return skeletons;
    }

    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    public static void setPlayer(Player myPlayer) { player = myPlayer; }

    public static Player getPlayer() {
        return player;
    }

    public static boolean nextMap() {
        Cell cell = player.getCell();
        if (cell.getType() == CellType.STAIRS) {
            return true;
        } else return false;
    }


    public void setGoblinInitial(Goblin goblin){
        goblins.add(goblin);
    }

    public void setGhostInitial(Ghost ghost){
        ghosts.add(ghost);
    }

    public void setMonsterInitial(Monster monster){
        monsters.add(monster);
    }

    public void setItemInitial(Item item) { items.add(item); }

    public void setSkeletonsInitial(Skeleton skeleton) { skeletons.add(skeleton); }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public static ArrayList<Goblin> getGoblins() {
        return goblins;
    }

    public static ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    public static ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public void removeNPC(Drawable npc) {
        if (npc instanceof Goblin){
            goblins.remove(npc);
        }

        if (npc instanceof Ghost){
            ghosts.remove(npc);
        }

        if (npc instanceof Monster){
            monsters.remove(npc);
        }
    }
}
