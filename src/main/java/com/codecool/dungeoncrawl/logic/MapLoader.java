//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.ModelLoader;
import com.codecool.dungeoncrawl.NoSQLDatabase.JSONDatabaseManager;
import com.codecool.dungeoncrawl.NoSQLDatabase.JSONextract;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.model.*;


import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;

import java.util.Arrays;
import java.util.Objects;

import java.util.Scanner;

public class MapLoader {
    public static int flag = 0;
    private static Player player;

    static String[] maps = new String[]{"/map.txt", "/map1.txt", "/map2.txt"};


    public MapLoader() {
    }

    public static GameMap loadMap(String playerName) {
        if (flag>3){
            flag=0;
        }
        InputStream is = MapLoader.class.getResourceAsStream(maps[flag]);
        ArrayList<Object> allObjects = JSONDatabaseManager.getSave();
        if (flag==0) {
            if (Objects.equals(JSONextract.getCurrentPlayer().getName(), playerName)) {
                maps = new String[]{"/emptymap.txt", "/emptymap1.txt", "/emptymap2.txt"};
                is = MapLoader.class.getResourceAsStream(maps[JSONextract.getCurrentFlagMap() - 1]);
            }
        } else {
            maps = new String[]{"/map.txt", "/map1.txt", "/map2.txt"};
            is = MapLoader.class.getResourceAsStream(maps[flag]);
        }
        flag++;
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();// /2
        int height = scanner.nextInt();// /2
        scanner.nextLine();
        GameMap map = new GameMap(width, height, CellType.EMPTY);


        for (int y = 0; y < height; ++y) {
            String line = scanner.nextLine();

            for (int x = 0; x < width; ++x) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '!':
                        case '"':
                        case '$':
                        case '%':
                        case '&':
                        case '\'':
                        case '(':
                        case ')':
                        case '*':
                        case '+':
                        case ',':
                        case '-':
                        case '/':
                        case '0':
                            cell.setType(CellType.FLOOR);
                            map.setItemInitial(new Crown(cell));
                            break;
                        case '1':
                            cell.setType(CellType.CASTLE1);
                            break;
                        case '2':
                            cell.setType(CellType.CASTLE2);
                            break;
                        case '3':
                            cell.setType(CellType.CASTLE3);
                            break;
                        case '4':
                            cell.setType(CellType.CASTLE4);
                            break;
                        case '5':
                            cell.setType(CellType.CASTLE5);
                            break;
                        case '6':
                            cell.setType(CellType.CASTLE6);
                            break;
                        case '7':
                            cell.setType(CellType.CASTLE7);
                            break;
                        case '8':
                            cell.setType(CellType.CASTLE8);
                            break;
                        case '9':
                        case ':':
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                        case '?':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'R':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '[':
                        case '\\':
                        case ']':
                        case '^':
                        case '_':
                        case '`':
                        case 'a':
                        case 'c':
                        case 'e':
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            map.setGhostInitial(new Ghost(cell));
                            break;
                        case 'i':
                        case 'j':
                        case 'm':
                            cell.setType(CellType.FLOOR);
                            map.setMonsterInitial(new Monster(cell));
                            break;
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                            cell.setType(CellType.FLOOR);
                            map.setGoblinInitial(new Goblin(cell));
                            break;
                        default:
                            char var10002 = line.charAt(x);
                            throw new RuntimeException("Unrecognized character: '" + var10002 + "'");
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            if (maps[flag-1].equals("/map.txt")){
                                player = new Player(cell, playerName);
                            } else {
                                if (player == null){
                                    flag++;
//                                    JSONDatabaseManager.saveGame();
                                    player = JSONextract.getCurrentPlayer();
                                    player.setTileName();

                                }
                                cell.setCellContent(player);
                                player.setCell(cell);
                            }
                            map.setPlayer(player);
                            break;
                        case 'A':
                            cell.setType(CellType.ARROW);
                            break;
                        case 'B':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 'C':
                            cell.setType(CellType.FLOOR);
                            map.setItemInitial(new Cheese(cell));
                            break;
                        case 'D':
                            cell.setType(CellType.DOORCLOSE);
                            map.setDoorInitial(new Door(cell));
                            break;
                        case 'O':
                            cell.setType(CellType.OAKS);
                            break;
                        case 'P':
                            cell.setType(CellType.PINES);
                            break;
                        case 'Q':
                            cell.setType(CellType.BRIDGESTART);
                            break;
                        case 'S':
                            cell.setType(CellType.FLOOR);
                            map.setItemInitial(new Sword(cell));
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            map.setItemInitial(new Sword1(cell));
                            break;
                        case 'd':
                            cell.setType(CellType.DOOROPEN);
                            break;
                        case 'f':
                            cell.setType(CellType.FIRE);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            map.setItemInitial(new Key(cell));
                            break;
                        case 'q':
                            cell.setType(CellType.FLOOR);
                            map.setItemInitial(new Helmet(cell));
                            break;
                        case 'r':
                            cell.setType(CellType.RIVERBODY);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.setSkeletonInitial(new Skeleton(cell));
                            break;
                        case 't':
                            cell.setType(CellType.STAIRS);
                            break;
                        case 'z':
                            cell.setType(CellType.SKULL);
                            break;
                        case 'l':
                            cell.setType(CellType.BEAR);
                            break;
                    }
                }
            }
        }

        if (Arrays.asList(maps).contains("/emptymap.txt")){
            loadJSONSaveOnMap(map, allObjects);
        }
        return map;
    }


    public static GameMap loadFromDatabase(ModelLoader modelLoader) {
        GameStateModel gameStateModel = modelLoader.getGameStateModel();
        InputStream is = MapLoader.class.getResourceAsStream(gameStateModel.getCurrentMap());


        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();// /2
        int height = scanner.nextInt();// /2
        scanner.nextLine();
        GameMap map = new GameMap(width, height, CellType.EMPTY);

        for (int y = 0; y < height; ++y) {
            String line = scanner.nextLine();

            for (int x = 0; x < width; ++x) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '0':
                            cell.setType(CellType.FLOOR);
                            new Crown(cell);
                            break;
                        case '1':
                            cell.setType(CellType.CASTLE1);
                            break;
                        case '2':
                            cell.setType(CellType.CASTLE2);
                            break;
                        case '3':
                            cell.setType(CellType.CASTLE3);
                            break;
                        case '4':
                            cell.setType(CellType.CASTLE4);
                            break;
                        case '5':
                            cell.setType(CellType.CASTLE5);
                            break;
                        case '6':
                            cell.setType(CellType.CASTLE6);
                            break;
                        case '7':
                            cell.setType(CellType.CASTLE7);
                            break;
                        case '8':
                            cell.setType(CellType.CASTLE8);
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            map.setGhostInitial(new Ghost(cell));
                            break;
                        case 'm':
                            cell.setType(CellType.FLOOR);
                            map.setMonsterInitial(new Monster(cell));
                            break;
                        case 'y':
                            cell.setType(CellType.FLOOR);
                            map.setGoblinInitial(new Goblin(cell));
                            break;
                        default:
                            char var10002 = line.charAt(x);
                            throw new RuntimeException("Unrecognized character: '" + var10002 + "'");
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case '@':
                        case 'A':
                            cell.setType(CellType.ARROW);
                            break;
                        case 'B':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 'D':
                            cell.setType(CellType.DOORCLOSE);
                            map.setDoorInitial(new Door(cell));
                            break;
                        case 'O':
                            cell.setType(CellType.OAKS);
                            break;
                        case 'P':
                            cell.setType(CellType.PINES);
                            break;
                        case 'Q':
                            cell.setType(CellType.BRIDGESTART);
                            break;
                        case 'S':
                        case 'b':
                        case 'd':
                            cell.setType(CellType.DOOROPEN);
                            break;
                        case 'f':
                            cell.setType(CellType.FIRE);
                            break;
                        case 'r':
                            cell.setType(CellType.RIVERBODY);
                            break;
                        case 's':
                        case 't':
                            cell.setType(CellType.STAIRS);
                            break;
                        case 'z':
                            cell.setType(CellType.SKULL);
                            break;
                        case 'l':
                            cell.setType(CellType.BEAR);
                            break;
                    }
                }
            }
        }
        PlayerModel playerModel = modelLoader.getPlayerModel();
        Cell cellForPlayer = map.getCell(playerModel.getX(), playerModel.getY());
        cellForPlayer.setType(CellType.FLOOR);
        player = new Player(cellForPlayer, playerModel.getPlayerName());
        map.setPlayer(player);
        List<OpponentModel> opponentModels = modelLoader.getOpponentModels();
        for (OpponentModel opponentModel : opponentModels) {
            Cell cellForOpponent = map.getCell(opponentModel.getX(), opponentModel.getY());
            cellForOpponent.setType(CellType.FLOOR);

            switch (opponentModel.getOpponentName()) {
                case "goblin":
                    Goblin goblin = new Goblin(cellForOpponent);
                    cellForOpponent.setCellContent(goblin);
                    map.setGoblinInitial(goblin);
                    break;
                case "ghost":
                    Ghost ghost = new Ghost(cellForOpponent);
                    cellForOpponent.setCellContent(ghost);
                    map.setGhostInitial(ghost);
                    break;
                case "monster":
                    Monster monster = new Monster(cellForOpponent);
                    cellForOpponent.setCellContent(monster);
                    map.setMonsterInitial(monster);
                    break;
                case "skeleton":
                    Skeleton skeleton = new Skeleton(cellForOpponent);
                    cellForOpponent.setCellContent(skeleton);
                    map.setSkeletonInitial(skeleton);
                    break;
            }
        }
            List<ItemModel> itemModels = modelLoader.getItemModelList();
            for (ItemModel itemModel : itemModels) {
                Cell cellForItem = map.getCell(itemModel.getX(), itemModel.getY());
                cellForItem.setType(CellType.FLOOR);
                switch (itemModel.getItemName()) {
                    case "cheese":
                        Cheese cheese = new Cheese(cellForItem);
                        map.setItemInitial(cheese);
                        cellForItem.setCellContent(cheese);
                        break;
                    case "crown":
                        Crown crown = new Crown(cellForItem);
                        map.setItemInitial(crown);
                        cellForItem.setCellContent(crown);
                        break;
                    case "helmet":
                        Helmet helmet = new Helmet(cellForItem);
                        map.setItemInitial(helmet);
                        cellForItem.setCellContent(helmet);
                        break;
                    case "key":
                        Key key = new Key(cellForItem);
                        map.setItemInitial(key);
                        cellForItem.setCellContent(key);
                        break;
                    case "sword":
                        Sword sword = new Sword(cellForItem);
                        map.setItemInitial(sword);
                        cellForItem.setCellContent(sword);
                        break;
                    case "sword1":
                        Sword1 sword1 = new Sword1(cellForItem);
                        map.setItemInitial(sword1);
                        cellForItem.setCellContent(sword1);
                        break;
                }


            }
        return map;
                }







    private static void loadJSONSaveOnMap(GameMap map, ArrayList<Object> allObjects){
        for (Object object : allObjects){
            if (object instanceof Actor){
                Cell cellForActor = map.getCell(((Actor) object).getCell().getX(), ((Actor) object).getCell().getY());
                cellForActor.setType(CellType.FLOOR);
                cellForActor.setCellContent((Actor) object);
                ((Actor) object).setCell(cellForActor);

                if (object instanceof Player){
                    ((Player) object).setTileName();
                    GameMap.setPlayer((Player) object);
                }

                if (object instanceof Ghost){
                    map.setGhostInitial((Ghost) object);
                } else if (object instanceof Monster){
                    map.setMonsterInitial((Monster) object);
                } else if (object instanceof Goblin){
                    map.setGoblinInitial(new Goblin(cellForActor));
                }
            }

            if (object instanceof Item){
                Cell cellForActor = map.getCell(((Item) object).getCell().getX(), ((Item) object).getCell().getY());
                cellForActor.setType(CellType.FLOOR);
                cellForActor.setCellContent((Item) object);
                ((Item) object).setCell(cellForActor);
            }

            if (object instanceof Door){
                Cell doorCell = map.getCell(((Door) object).getCell().getX(), ((Door) object).getCell().getY());
                if (((Door) object).isOpen()){
                    doorCell.setType(CellType.DOOROPEN);
                } else {
                    doorCell.setType(CellType.DOORCLOSE);
                }
                doorCell.setCellContent((Door) object);
                ((Door) object).setCell(doorCell);
            }
        }
    }
}

