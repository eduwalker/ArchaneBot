package me.ArchaneBot.devbot.main;

import kotlin.text.Charsets;
import me.ArchaneBot.devbot.commands.Cargos;
import me.ArchaneBot.devbot.commands.Prefix;
import me.ArchaneBot.devbot.dataBase.CRUD;
import me.ArchaneBot.devbot.dataBase.SqlConfig;
import me.ArchaneBot.devbot.events.MemberJoin;
import me.ArchaneBot.devbot.commands.Ping;
import me.ArchaneBot.devbot.events.MemberLeave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.logging.log4j.core.util.IOUtils;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class DevBot {
    public static JDA jda;
    public  static Map<Long, String> mapGuildName = new HashMap<>();
    public  static Map<String, Character> prefixMap = new HashMap<>();
    public  static Map<String, String> autoCargoMap = new HashMap<>();
    public  static Map<Long, Long> joinChannelMap = new HashMap<>();
    public  static Map<Long, Long> leaveChannelMap = new HashMap<>();


    public static void main(String[] args) throws LoginException, InterruptedException, IOException, SQLException {

        SqlConfig.createFilesTable();


  /*                EXEMPLO DE ATRIBUICAO SIMPLES
        JDA jda = JDABuilder.create("MTAyMTUzNjczNTA0MzI1NjQyMA.GDvjHz.bc7_5xGsHrntFNm5HIHcDEVTLZGj74n25yFIM4",
         GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGES).build();*/





         jda = JDABuilder.create(System.getenv("BOT_TOKEN"),
                EnumSet.allOf(GatewayIntent.class)).build();

//        Lista de eventos adicionados
        jda.addEventListener(new Ping());
        jda.addEventListener(new MemberJoin());
        jda.addEventListener(new MemberLeave());
        jda.addEventListener(new Prefix());
        jda.addEventListener(new Cargos());


        int cont = 0;
//          For para mostrar os servidores que possuem o Archane.bot
        for (Guild guild: jda.awaitReady().getGuilds()) {
            mapGuildName.put(guild.getIdLong(), guild.getName());

            System.out.println("\n"+mapGuildName.get(guild.getIdLong()));
        }



//          For para definir um prefixo usado como comando nos servidores
        for (Guild guild: jda.awaitReady().getGuilds()) {

            CRUD.insert(guild.getId(), '!');
        }

        for (Guild guild: jda.awaitReady().getGuilds()) {

            CRUD.select(guild.getId());
        }

    }
}
