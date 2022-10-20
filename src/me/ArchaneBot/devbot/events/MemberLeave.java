package me.ArchaneBot.devbot.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MemberLeave extends ListenerAdapter {

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        TextChannel textChannel = event.getGuild().getTextChannelById(1021983903084449802L);
        String userName = event.getUser().getName();

        textChannel.sendMessage("@"+userName + " saiu do servidor!").queue();
    }
}








/* REPOSITORIOS DE CODIGOS */

//event.getGuild().getTextChannelById(1021983903084449802L).sendMessage(event.getUser().getName() + " saiu do servidor!").queue();

