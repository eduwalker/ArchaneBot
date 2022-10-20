package me.ArchaneBot.devbot.events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MemberJoin extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        TextChannel textChannel = event.getGuild().getTextChannelById(1021982141082513438L);
        String userName = event.getUser().getName();


        Member joined = event.getMember();

        Guild guild = event.getGuild();

        guild.addRoleToMember(UserSnowflake.fromId(joined.getId()), guild.getRoleById(1021877429372985454L)).queue();



        textChannel.sendMessage("@"+userName + " spawnou no servidor!").queue();




    }
}






/* REPOSITORIO DE CODIGOS */

// event.getGuild().getTextChannelById(1021982141082513438L).sendMessage(event.getUser().getName() + " entrou no servidor!").queue();