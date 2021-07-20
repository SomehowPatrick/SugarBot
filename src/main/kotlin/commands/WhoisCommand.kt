package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import org.json.JSONException
import storgae.Load

class WhoisCommand : Command("whois", "Stalk a User", mutableListOf("User")) {
    fun onSlashCommand(event: SlashCommandEvent) {
        val user = event.getOption("user")?.asMember
        var gender = try {
            user?.id?.let { Load().stringFromJson("D:\\Intelleij Projects\\src\\main\\resources\\gender.json", it)}
        }catch (e:JSONException){
            "\uD83D\uDEAB"
        }
        if(user?.user?.isBot == true){
            gender = "\uD83E\uDD16"
        }
            val userInfo = EmbedBuilder()
                .setTitle("Info about " + user?.user?.name)
                .addField("Dates", "**Joined**\n${user?.timeJoined}\n**Created**\n${user?.user?.timeCreated}", true)
                .addField("Permissions", user?.permissions?.joinToString("\n"), false)
                .addField("Gender", gender, false)
                .build()
            event.replyEmbeds(userInfo).queue()
        }
    }