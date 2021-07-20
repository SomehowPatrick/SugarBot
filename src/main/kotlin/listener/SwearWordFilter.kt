package listener

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import storgae.Embeds
import util.SwearWords

class SwearWordFilter:ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if(event.channel.name == ""){
            return
        }
        if(SwearWords().contains(event.message.contentRaw.toLowerCase())){
            event.message.delete().queue()
            var member = event.member
            if (member != null) {
                event.channel.sendMessageEmbeds(Embeds().warn(member.asMention, "Swearing words")).queue()
            }
        }
    }
}