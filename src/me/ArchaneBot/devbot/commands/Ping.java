package me.ArchaneBot.devbot.commands;

import me.ArchaneBot.devbot.main.DevBot;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Ping extends ListenerAdapter {


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        TextChannel textChannel = (TextChannel) event.getChannel();

        if(args[0].equalsIgnoreCase(DevBot.prefixMap.get(event.getGuild().getId())+"ping")){
            textChannel.sendMessage("```INI\n[Minha conexão divina esta em "+ DevBot.jda.getGatewayPing() + "ms]```").queue();
        }
    }
}
