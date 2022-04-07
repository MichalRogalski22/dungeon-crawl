//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.Door;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;

public class GameMap {
    private int id;
    private int width;
    private int height;
    private Cell[][] cells;
    private static Player player;
    private ArrayList<Goblin> goblins = new ArrayList<>();
    private ArrayList<Ghost> ghosts = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();
    private ArrayList<Skeleton> skeletons = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Door> doors = new ArrayList<>();

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

    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
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

    public void setSkeletonInitial(Skeleton skeleton){
        skeletons.add(skeleton);
    }

    public void setDoorInitial(Door door){
        doors.add(door);
    }

    public void setItemInitial(Item item){
        items.add(item);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<Goblin> getGoblins() {
        return goblins;
    }

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public ArrayList<Skeleton> getSkeletons() {
        return skeletons;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Door> getDoors() {
        return doors;
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

        if (npc instanceof Skeleton){
            skeletons.remove(npc);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
