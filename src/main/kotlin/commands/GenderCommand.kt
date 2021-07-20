package commands

import net.dv8tion.jda.api.entities.Emoji
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.components.selections.SelectOption
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu
import java.util.*

class GenderCommand:Command("gender", "Choose your Gender", mutableListOf()) {
    fun onSlashCommand(event: SlashCommandEvent) {
        val genderMenu = SelectionMenu.create("gender_menu")
            .setPlaceholder("Answer")
            .setRequiredRange(1,1)
            .addOption("Female", "♀️", Emoji.fromMarkdown("♀️"))
            .addOption("Male", "♂️", Emoji.fromMarkdown("♂️"))
            .addOption("No Binary", "⚧", Emoji.fromMarkdown("⚧"))
            .addOption("None", "\uD83D\uDEAB", Emoji.fromMarkdown("\uD83D\uDEAB"))
            .setDefaultOptions(Arrays.asList(SelectOption.of("No set", "\uD83D\uDEAB")))
            .setDisabled(false)
            .build()
        event.reply("Choose your Gender")
            .addActionRow(genderMenu)
            .queue()
    }
}