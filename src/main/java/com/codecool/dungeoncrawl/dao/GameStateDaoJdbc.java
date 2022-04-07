package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.model.GameStateModel;
import com.codecool.dungeoncrawl.model.PlayerModel;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameStateDaoJdbc implements GameStateDao {

    private DataSource dataSource;
    private PlayerDaoJdbc playerDaoJdbc;

    public GameStateDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
        this.playerDaoJdbc = new PlayerDaoJdbc(dataSource);
    }

    @Override
    public void add(GameStateModel state) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO game_state (saved_at, current_map, player_name) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, state.getSavedAt());
            statement.setString(2, state.getCurrentMap());
            statement.setString(3, state.getPlayer().getPlayerName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            state.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(GameStateModel state) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE game_state SET saved_at = ?, current_map = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDate(1, state.getSavedAt());
            statement.setString(2, state.getCurrentMap());
            statement.setInt(3, state.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GameStateModel get(String playerName) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT id, saved_at, current_map, player_name FROM game_state WHERE player_name = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, playerName);
            ResultSet game = statement.executeQuery();
            if (!game.next()) {
                return null;
            }
            PlayerModel player = playerDaoJdbc.get(game.getString(4));
            GameStateModel gameState = new GameStateModel(game.getString(3), game.getDate(2), player);
            int id = game.getInt(5);
            gameState.setId(id);
            return gameState;
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading game with player name: " + playerName, e);
        }
    }

    @Override
    public List<GameStateModel> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT id, saved_at, current_map, player_name FROM game_state";
            ResultSet result = conn.createStatement().executeQuery(sql);
            List<GameStateModel> games = new ArrayList<>();
            while (result.next()) {
                PlayerModel player = playerDaoJdbc.get(result.getString(4));
                GameStateModel gameState = new GameStateModel(result.getString(3), result.getDate(2), player);
                gameState.setId(result.getInt(1));
                games.add(gameState);
            }
            return games;
        } catch (SQLException e) {
            throw new RuntimeException("Error while reading all games", e);
        }
    }

    @Override
    public void delete(int id){
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE FROM game_state WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("You cannot delete game with id: " + id, e);
        }
    }
}
