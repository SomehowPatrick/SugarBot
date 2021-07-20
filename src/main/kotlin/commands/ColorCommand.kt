package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import storgae.Load
import java.awt.Color

class ColorCommand {
    fun onSlashCommand(event: SlashCommandEvent) {
        val hexValue = event.getOption("hex")?.asString
        val imageUrl = "https://some-random-api.ml/canvas/colorviewer?hex=$hexValue"
        val rgbJson = Load().readJsonFromUrl("https://some-random-api.ml/canvas/rgb?hex=$hexValue")
        val colorEmbed = EmbedBuilder()
            .setThumbnail(imageUrl)
            .setTitle("Color $hexValue")
            .addField("R G B", "(" + rgbJson?.get("r") + "," + rgbJson?.get("g") + "," + rgbJson?.get("b") + ")", true)
            .build()
        event.replyEmbeds(colorEmbed).queue()
    }
}