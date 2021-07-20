package commands

import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent

class GlobalCommand : Command("global", "Create Globalchat Channel", mutableListOf()) {
    fun onSlashCommand(event: SlashCommandEvent) {
        if(event.member?.hasPermission(Permission.ADMINISTRATOR)!!){
            event.guild?.createTextChannel("\uD83C\uDF0E︙global")?.queue{channel -> event.reply("Added " + channel.asMention).queue()}
        }
    }
}