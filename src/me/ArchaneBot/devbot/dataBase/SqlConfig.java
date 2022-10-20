package me.ArchaneBot.devbot.dataBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

public class SqlConfig {


//                            Classe feita para criar um arquivo no local indicado

    public static  File databaseFile = new File("C:\\Users\\dudz_\\OneDrive\\Documents\\BotDiscord\\DbArchane\\Archane.db"); // Indica o local a ser criado


    public static void createFilesTable() throws IOException, SQLException {  // Metodo de criacao do arquivo

    if(Files.notExists(databaseFile.toPath())){
        Files.createFile(databaseFile.toPath());

        CRUD.createTable();

        }
    }
}
