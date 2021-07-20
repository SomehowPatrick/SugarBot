package commands

import net.dv8tion.jda.api.entities.Emoji
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.components.selections.SelectOption
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu
import java.util.*

class FeedbackCommand:Command("feedback", "Send a Feedback", mutableListOf()) {
    fun onSlashCommand(event:SlashCommandEvent){
        val menu = SelectionMenu.create(event.member?.user?.id + "-like-menu")
            .setPlaceholder("Answer")
            .setRequiredRange(1,1)
            .addOption("Yes", "I do", "I do", Emoji.fromEmote("greenCheck", 834853041756569610, false))
            .addOption("No", "I don't", "I don't", Emoji.fromEmote("redCross", 834849757070491698, false))
            .addOption("Maybe", "Make Bot better!", "Make Bot better!", Emoji.fromEmote("yellowcheck", 862026025453486090, false))
            .addOption("Please Select", "pls")
            .setDefaultOptions(Arrays.asList(SelectOption.of("Please Select", "pls")))
            .setDisabled(false)
            .build()
        event.reply("Do you enjoy the bot?")
            .addActionRow(menu).queue()
    }
}