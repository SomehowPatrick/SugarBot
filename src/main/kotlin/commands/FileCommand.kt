package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import java.io.File

class FileCommand : Command("file", "Gets Text of an File on my Device!", mutableListOf("filename")) {
    fun onSlashCommand(event: SlashCommandEvent) {
        val filename = event.getOption("filename")?.asString
        val file = File("D:\\Intelleij Projects\\src\\main\\$filename")
        val fileEmbed = EmbedBuilder()
        if (file.isDirectory) {
            val content = mutableListOf<String>()
            file.walk().forEach { f ->
                if(f.isDirectory){
                    content.add("\n"+f.name)
                }else{
                    content.add(" ⠀⠀" + f.name)
                }
            }
            fileEmbed
                .addField("Name", file.name, true)
                .addField("Type", "Folder", true)
                .addBlankField(false)
                .addField("Content", content.joinToString("\n"), true)
        } else {
            val content = if("```${file.extension}\n${file.readText()}```".length >= 1024){
                "To Long"
            }else{
                "```${file.extension}\n${file.readText()}```"
            }
            fileEmbed
                .setTitle("Fileinfo")
                .addField("Name", file.name, true)
                .addField("Type", file.extension.toUpperCase(), true)
                .addField("Content", content, false)
                .addField("Bytes", "````${file.readBytes()}```", false)
        }
        event.replyEmbeds(fileEmbed.build()).queue()
    }
}