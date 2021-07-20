package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import storgae.Load

class LyricsCommand : Command("lyrics", "Searches the Internet for the Lyrics of an Song", mutableListOf("query")) {
    fun onSlashCommand(event: SlashCommandEvent) {
        val query = event.getOption("query")?.asString?.replace(" ", "%20")
        val jsonResponse = Load().readJsonFromUrl("https://some-random-api.ml/lyrics?title=$query")
        val title = jsonResponse?.get("title").toString()
        val lyrics = jsonResponse?.get("lyrics").toString()
        val lyricsEmbed = EmbedBuilder()
            .setTitle(title)
            .setAuthor(jsonResponse?.get("author").toString())
            .setDescription(lyrics)
            .build()
        event.replyEmbeds(lyricsEmbed).queue()
    }
}