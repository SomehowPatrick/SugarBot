package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.Emoji
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.components.Button
import storgae.Embeds

class WarnCommand:Command("warn", "Warns a user", mutableListOf("User", "Reason")) {
    fun onSlashCommand(event: SlashCommandEvent) {
        val user = event.getOption("user")?.asMember
        val reason = event.getOption("reason")?.asString
        val warnEmbed = EmbedBuilder()
            .setTitle("Warn user?")
            .setDescription("Sure?")
            .build()
        if(event.member?.hasPermission(Permission.KICK_MEMBERS) == true){
            event.replyEmbeds(warnEmbed)
                .addActionRow(Button.danger(event.member?.user?.name + "-delete", Emoji.fromMarkdown("\uD83D\uDDD1")))
                .addActionRow(Button.success(event.member?.user?.name + "-warn-${user?.user?.name}-reason:$reason" , Emoji.fromMarkdown("<:greenCheck:834853041756569610>")))
                .queue()
        }else{
            event.replyEmbeds(Embeds().permissionDenied(Permission.KICK_MEMBERS))
                .addActionRow(Button.danger(event.member?.user?.name + "-delete", Emoji.fromMarkdown("\uD83D\uDDD1️")))
                .queue()
        }
    }
}