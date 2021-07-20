package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.Emoji
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent

class PollCommand : Command("poll", "Start a Poll", mutableListOf("emojis", "opinions")) {
    fun onGuildMessageReceived(event: SlashCommandEvent) {
        val emojis = event.getOption("emojis")?.asString?.split("*")
        val opinions = event.getOption("opinions")?.asString?.split("*")
        val question = event.getOption("question")?.asString
        val pollOptions = mutableListOf<String>()
        if (emojis != null && opinions != null) {
            var index = emojis.size - 1
            while (index >= 0){
                pollOptions.add(emojis[index] + "⠀⠀" + opinions[index])
                index--
            }
        }
        val pollEmbed = EmbedBuilder()
            .setTitle(question)
            .setDescription(pollOptions.joinToString("\n"))
            .setFooter("Asked by " + event.member?.user?.asTag)
            .build()
        event.channel.sendMessageEmbeds(pollEmbed)
            .queue { message -> if (emojis != null) {
                for (emoji in emojis){
                    message.addReaction(emoji).queue()
                }
            }}
        event.reply("Successfully started poll!").setEphemeral(true).queue()
    }
}