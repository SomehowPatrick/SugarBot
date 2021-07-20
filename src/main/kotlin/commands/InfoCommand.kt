package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.Emoji
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.components.Button
import java.awt.Color

class InfoCommand : Command("info", "Info about the bot", mutableListOf()) {
    fun onSlashCommand(event: SlashCommandEvent) {
        val infoEmbed = EmbedBuilder()
            .setTitle("That's Me")
            .setColor(Color.MAGENTA)
            .addField("Language", "<:kotlin:866687347113066506>", true)
            .addBlankField(true)
            .addField("Developer", "[AureumApes](https://github.com/AureumApes) is an 14 years old transsexual Hobby-Developer. She likes to work with Kotlin and BrainFuck.", true)
            .addBlankField(false)
            .addField("Source", "Currently no reposirory.\nUse /file instead!", true)
            .build()
        event.replyEmbeds(infoEmbed)
            .addActionRow(Button.primary("next-feedback", "▶️"))
            .queue()
    }
}