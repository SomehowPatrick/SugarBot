package listener

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class OnButtonClick : ListenerAdapter() {
    override fun onButtonClick(event: ButtonClickEvent) {
        if (event.button?.id == event.member?.user?.name + "-delete") {
            event.message?.delete()?.queue()
            return
        } else if (event.button?.id?.startsWith(event.member?.user?.name + "-warn") == true) {
            val splitId = event.button?.id?.split("-")
            val warnedEmbed = EmbedBuilder()
                .setTitle("Warned User")
                .setTitle("Warned " + splitId?.get(2))
                .addField("Member", splitId?.get(2), true)
                .addField("Reason", splitId?.joinToString("-")?.split("-reason:")?.get(1), true)
                .setColor(Color.RED)
                .build()
            event.editButton(null).queue()
            event.message?.editMessageEmbeds(warnedEmbed)?.queue()
            return
        }else if(event.button?.id == "next-feedback"){
            val feedbackOneEmbed = EmbedBuilder()
                .setTitle("Thats what Gamer200 think")
                .setImage("https://some-random-api.ml/canvas/youtube-comment?avatar=https://i.imgur.com/VI6Vh88.png&comment=Nice%20bot&username=Gamer200")
                .build()
            event.message?.editMessageEmbeds(feedbackOneEmbed)?.queue()
            event.editButton(null).queue()
        }
    }
}