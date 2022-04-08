package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.model.*;

import java.util.List;

public class ModelLoader {
    private List<ItemModel> itemModelList;
    private List<OpponentModel> opponentModels;
    private List<DoorModel> doorModels;
    private GameStateModel gameStateModel;
    private DoorModel doorModel;
    private List<ItemModel> playerBackpack;
    private PlayerModel playerModel;


    public ModelLoader(){}


    public List<ItemModel> getItemModelList() {
        return itemModelList;
    }

    public List<OpponentModel> getOpponentModels() {
        return opponentModels;
    }

    public List<DoorModel> getDoorModels() {
        return doorModels;
    }

    public GameStateModel getGameStateModel() {
        return gameStateModel;
    }

    public DoorModel getDoorModel() {
        return doorModel;
    }

    public List<ItemModel> getPlayerBackpack() {
        return playerBackpack;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public void setItemModelList(List<ItemModel> itemModelList) {
        this.itemModelList = itemModelList;
    }

    public void setOpponentModels(List<OpponentModel> opponentModels) {
        this.opponentModels = opponentModels;
    }

    public void setDoorModels(List<DoorModel> doorModels) {
        this.doorModels = doorModels;
    }

    public void setGameStateModel(GameStateModel gameStateModel) {
        this.gameStateModel = gameStateModel;
    }

    public void setDoorModel(DoorModel doorModel) {
        this.doorModel = doorModel;
    }

    public void setPlayerBackpack(List<ItemModel> playerBackpack) {
        this.playerBackpack = playerBackpack;
    }

    public void setPlayerModel(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }
}
