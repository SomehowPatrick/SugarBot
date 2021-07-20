package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.components.Button

class RoleCommand : Command("role", "Info about a role", mutableListOf("role")) {
    fun onSlashCommand(event: SlashCommandEvent) {
        val role = event.getOption("role")?.asRole
        val roleEmbed = EmbedBuilder()
            .setColor(role?.color)
            .setTitle("Info about ${role?.asMention}")
            .addField("Permissions", role?.permissions?.joinToString("\n"), false)
            .addField("Id", role?.id, false)
            .build()
        event.replyEmbeds(roleEmbed)
            .addActionRow(Button.danger(event.member?.user?.name + "-delete", "\uD83D\uDDD1️"))
            .queue()
    }
}