package listener

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import storgae.Embeds
import util.SwearWords

class GlobalChat {
    fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if(SwearWords().contains(event.message.contentRaw.toLowerCase())){
            event.message.delete().queue()
            val member = event.member
            if (member != null) {
                return
            }
        }
        for (guild in event.jda.guildCache) {
            val globalChannel = guild.textChannels.find { channel -> channel.name == "\uD83C\uDF0E︙global" }
            if(event.message.attachments.size != 0){
                globalChannel?.sendMessageEmbeds(Embeds().globalChat(event.message.contentRaw, event.message.member!!, event.guild).setImage(event.message.attachments[0].url).build())?.queue()
            }else{
                globalChannel
                    ?.sendMessageEmbeds(Embeds().globalChat(event.message.contentRaw, event.message.member!!, event.guild).build())
                    ?.queue()
            }
        }
        event.message.delete().queue()
    }
}