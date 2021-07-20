package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import storgae.Load
import java.awt.Color

class RedPandaCommand {
    fun onSlashCommand(event: SlashCommandEvent) {
        val pictureUrl = Load().readJsonFromUrl("https://some-random-api.ml/img/red_panda")?.get("link")?.toString()
        val redPandaEmbed = EmbedBuilder()
            .setColor(Color.red)
            .setImage(pictureUrl)
            .setTitle("Panda")
            .build()
        event.replyEmbeds(redPandaEmbed).queue()
    }
}