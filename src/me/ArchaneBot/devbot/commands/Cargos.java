package me.ArchaneBot.devbot.commands;

import me.ArchaneBot.devbot.main.DevBot;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Cargos extends ListenerAdapter {

    private final Map<Byte, String> cargosMap = new HashMap<>();
    private final Map<String, Map<Byte, String>> guildCargosMapMap = new HashMap<>();
    private final Map<String, Boolean> finalEdicao = new HashMap<>();
    private final Map<String, Member> memberEditingCargos = new HashMap<>();
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        byte cargoIndex = 1;
        char asp = '`';
        String caixa = "```";

        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(DevBot.prefixMap.get(event.getGuild().getId())+ "cargos")){
            event.getChannel().sendMessage("```Selecione um cargo para novos membros:```").queue();
            StringBuilder stringBuilder = new StringBuilder();

            for (Role cargo: event.getGuild().getRoles()) {
                if(!cargo.isPublicRole()){


                    cargosMap.put(cargoIndex, cargo.getName());

                stringBuilder.append(asp).append(cargoIndex).append(" - ").append(cargo.getName()).append(asp).append("\n");
                }

                cargoIndex+=1;

            }

            guildCargosMapMap.put(event.getGuild().getId(), cargosMap);
            finalEdicao.put(event.getGuild().getId(), true);
            memberEditingCargos.put(event.getGuild().getId(), event.getMember());

            event.getChannel().sendMessage(stringBuilder).queue();

        }else {

            if(args[0].matches("^[0-20]{1,3}")
                    && finalEdicao.get(event.getGuild().getId())
                    && event.getMember().equals(memberEditingCargos.get(event.getGuild().getId()))){

                if(!event.getMember().equals(memberEditingCargos.get(event.getGuild().getId()))){
                    return;
                }
                if(event.getJDA().getSelfUser().getId().equals(event.getMember().getId())){
                    return;
                }
                if (guildCargosMapMap.get(event.getGuild().getId()) == null) return;

                event.getChannel().sendMessage("```O cargo selecionado foi @" + guildCargosMapMap.get(event.getGuild().getId()).get(Byte.parseByte(args[0])) + "```").queue();

                finalEdicao.put(event.getGuild().getId(), false);
            }

        }
    }
}


//   for (Role cargo: event.getGuild().getRoles()) {
//
//           if(!cargo.isPublicRole())
//           stringBuilder.append(cargo.getName()).append("\n");
//           }

//          event.getChannel().sendMessage("`" + cargo.getName() + "`").queue();



//           for (Role cargo: event.getGuild().getRoles()) {
//                   if(!cargo.isPublicRole()) {
//                   event.getChannel().sendMessage("`" + cargo.getName() + "`").queue();
//                   }
//                   }