package ca.humber.chess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class DBConnectivity implements AutoCloseable {
    private Connection con;
    
    public DBConnectivity(DataSource dataSource) throws SQLException {
        con = dataSource.getConnection();
    }

    @Override
    public void close() throws Exception {
        con.close();
    }
    
    public void queryDB() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM players")){
               System.out.println("player_id\tplayer_name\tpassword\temail");
                while (rs.next()) {
                   System.out.println(rs.getInt("player_id") + "\t\t" + rs.getString("player_name") +
                           "\t\t" + rs.getString("password") + "\t\t" + rs.getString("email"));
               }
            }
        }
    }
    
    public void insertInfo() throws SQLException, IOException {
        String query = "INSERT INTO character_skills "
                + "(character_id, skill_id, level_id) VALUES (?,?,?)";
        try (PreparedStatement prepStmt = con.prepareStatement(query)) {
            try (BufferedReader reader = new BufferedReader(new FileReader("character_skills.txt"))) {
                String line;
                while ( (line = reader.readLine()) != null ) {
                    String[] tokens = line.split(" ");
                    prepStmt.setInt(1, Integer.parseInt(tokens[0]));
                    prepStmt.setInt(2, Integer.parseInt(tokens[1]));
                    prepStmt.setInt(3, Integer.parseInt(tokens[2]));
                    prepStmt.executeUpdate();
                }
            }
        }
    }
    
    public int insertGameInstance(int playerID, int levelID) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM players "
                    + "WHERE player_id=" + playerID)) {
                if (rs.next()) {
                    stmt.executeUpdate("INSERT INTO game_instances (player_id, level_id) "
                            + "VALUES (" + playerID + "," + levelID + ")");
                    
                    try (ResultSet res = stmt.executeQuery("SELECT MAX(game_instance_id) "
                            + "FROM game_instances WHERE player_id=" + playerID) ){
                        res.next();
                        return res.getInt(1);
                    }
                } else {
                    throw new RuntimeException("Invalid player");
                }
            }
        }
    }
    
    public void insertCharacterInstance(int characterID, int gameID) throws SQLException{
        try (Statement stmt = con.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM characters "
                    + "WHERE character_id=" + characterID)) {
                if (rs.next()) {
                    stmt.executeUpdate("INSERT INTO character_instances "
                        + "(character_id, game_instance_id) VALUES (" + characterID + "," + gameID + ")");
                } else {
                    throw new RuntimeException("Invalid character");
                }
            }
        }
    }
    
    public void startGame(int playerID, int characterID, int levelID) throws SQLException {
        try {
            con.setAutoCommit(false);
            int gameID = insertGameInstance(playerID, levelID);
            insertCharacterInstance(characterID, gameID);
            con.commit();
        } catch (Exception e) {
            con.rollback();
            System.out.println("Game cannot be started: " + e.getMessage());
        } finally {
            con.setAutoCommit(true);
        }
        
    }
}
