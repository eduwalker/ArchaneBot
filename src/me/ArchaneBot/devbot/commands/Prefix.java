package me.ArchaneBot.devbot.commands;

import me.ArchaneBot.devbot.dataBase.CRUD;
import me.ArchaneBot.devbot.main.DevBot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class Prefix  extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        TextChannel textChannel = (TextChannel) event.getChannel();

        if (args[0].equalsIgnoreCase(DevBot.prefixMap.get(event.getGuild().getId()) + "help")) {
            textChannel.sendMessage("`O comando de magias para este servidor é: [ " + DevBot.prefixMap.get(event.getGuild().getId()) + " ]`").queue();
        }



        if (args[0].equalsIgnoreCase(DevBot.prefixMap.get(event.getGuild().getId()) + "setprefix")) {
            if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) { //MANAGE_SERVER
                textChannel.sendMessage("`Apenas Magos Supremos podem alterar o prefixo de comando deste MageBOT`").queue();
                return;
            }
        }


        if (args[0].equalsIgnoreCase(DevBot.prefixMap.get(event.getGuild().getId()) + "setprefix")) {
            DevBot.prefixMap.replace(event.getGuild().getId(), args[1].charAt(0));
            try {
                CRUD.update(event.getGuild().getId(), args[1].charAt(0));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            textChannel.sendMessage("`Saudações Mago Supremo! O comando de magias foi alterado para: [ " + DevBot.prefixMap.get(event.getGuild().getId()) + " ]`").queue();
        }



    }
}

