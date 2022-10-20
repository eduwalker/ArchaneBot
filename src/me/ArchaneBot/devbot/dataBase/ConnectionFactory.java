package me.ArchaneBot.devbot.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConect() throws SQLException {

        String url = "jdbc:sqlite:C:\\Users\\dudz_\\OneDrive\\Documents\\BotDiscord\\DbArchane\\Archane.db";

       try{
           return DriverManager.getConnection(url);
       }catch (SQLException sqlException){
           sqlException.printStackTrace();
       }
       return null;


    }
}
