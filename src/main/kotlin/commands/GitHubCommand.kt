package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import storgae.Embeds
import storgae.Load

class GitHubCommand {
    fun onSlashCommand(event: SlashCommandEvent) {
        val name = event.getOption("name")?.asString
        val apiJsonResponse = Load().readJsonFromUrl("https://api.github.com/users/$name")
        val githubEmbed = EmbedBuilder()
            .setTitle("Github info about ${apiJsonResponse?.get("login")}")
            .setThumbnail("${apiJsonResponse?.get("avatar_url")}")
            .addField("Name", "${apiJsonResponse?.get("login")}", true)
            .addField("Location", "${apiJsonResponse?.get("location")} ", true)
            .addBlankField(false)
            .addField(
                " General Stats",
                "**Public Repos**\n${apiJsonResponse?.get("public_repos")}\n\n**Followers**\n${apiJsonResponse?.get("followers")}",
                true)
            .addField("Dates", "**Created**\n${apiJsonResponse?.get("created_at")}\n\n**Last Updated**\n${apiJsonResponse?.get("updated_at")}", true)
            .build()
        event.replyEmbeds(githubEmbed).queue()
    }
}