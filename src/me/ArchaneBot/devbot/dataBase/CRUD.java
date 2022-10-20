package me.ArchaneBot.devbot.dataBase;

import me.ArchaneBot.devbot.main.DevBot;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {


//                                       Metodo para criar uma tabela "Table" dentro de um arquivo .db (Database)
    public static void createTable() throws SQLException {

        String sql = """
        create table tb_guild 
        (id integer primary key autoincrement  not null unique,
        guild_id text not null unique,
        prefix text not null,
        autocargo text
        )""";

        PreparedStatement statement = ConnectionFactory.getConect().prepareStatement(sql);
        statement.executeUpdate();
        statement.close();
        ConnectionFactory.getConect().close();

    }



//                                       Metodo para inserir na tabela "Table" informacoes captadas (Database)
    public  static void insert(String guildId, char prefix) throws SQLException {
        String sql = """
            insert or ignore into tb_guild values (null, ?, ?, null)
                    """;

        PreparedStatement statement = ConnectionFactory.getConect().prepareStatement(sql);
        statement.setString(1, guildId);
        statement.setString(2, String.valueOf(prefix));


        statement.executeUpdate();
        statement.close();
        ConnectionFactory.getConect().close();
    }




    public static void select(String guildId) throws SQLException {

        String sql = """
          select * from tb_guild where guild_id = ?
        """;

        PreparedStatement statement = ConnectionFactory.getConect().prepareStatement(sql);
        statement.setString(1, guildId);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            DevBot.prefixMap.put(guildId, resultSet.getString("prefix").charAt(0));
            DevBot.autoCargoMap.put(guildId, resultSet.getString("autocargo"));
        }
        statement.close();
        ConnectionFactory.getConect().close();
    }





    public static void update(String guildId, char newPrefix) throws SQLException {

        String sql = """
        update tb_guild set prefix = ? where guild_id= ?
        """.formatted(newPrefix, guildId);

        PreparedStatement statement = ConnectionFactory.getConect().prepareStatement(sql);
        statement.setString(1, String.valueOf(newPrefix));
        statement.setString(2, guildId);

        statement.executeUpdate();
        statement.close();
        ConnectionFactory.getConect().close();
        }

}

