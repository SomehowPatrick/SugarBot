package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import storgae.Load
import java.awt.Image

class MemeCommand {
    fun onSlashCommand(event: SlashCommandEvent) {
        val memeJson = Load().readJsonFromUrl("https://some-random-api.ml/meme")
        val imageUrl = memeJson?.get("image")?.toString()
        val memeEmbed = EmbedBuilder()
            .setImage(imageUrl)
            .setTitle(memeJson?.getString("caption"))
            .build()
        event.replyEmbeds(memeEmbed).queue()
    }
}