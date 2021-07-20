package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.components.Button
import storgae.Storage

class HelpCommand : Command("help", "Send an Help Message!", mutableListOf("Command")) {
    fun onSlashCommand(event: SlashCommandEvent) {
        val command = event.getOption("command")?.asString?.toLowerCase()
        val commands = mutableListOf<String>("help", "whois", "warn", "feedback", "role", "gender", "global", "file", "poll", "info", "lyrics")
        val description = if(command in commands){
            Storage().commands()[command]?.description
        }else{
            "Invalid Command!"
        }
        val name = if(command in commands){
            Storage().commands()[command]?.name
        }else{
            "Invalid Command!"
        }
        val args = if(command in commands){
            Storage().commands()[command]?.args
        }else{
            mutableListOf("Invalid Command!")
        }
        val helpEmbed = EmbedBuilder()
            .setTitle("Help")
            .addField("Name", name, false)
            .addField("Description", description, false)
            .addField("Arguments [" + Storage().commands()[command]?.args?.size + "]", args?.joinToString("\n"), false)
            .build()
        event.replyEmbeds(helpEmbed).addActionRow(Button.danger(event.member?.user?.name + "-delete", "\uD83D\uDDD1️")).queue()
    }
}