package storgae

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.entities.*
import org.json.JSONException
import java.awt.Color

class Embeds {
    fun permissionDenied(permission: Permission): MessageEmbed {
        return EmbedBuilder()
            .setColor(Color.RED)
            .setDescription("You dont have the Permission $permission")
            .setTitle("Permission Denied!")
            .build()
    }
    fun warn(member:String, reason:String): MessageEmbed {
        return EmbedBuilder()
            .setColor(Color.RED)
            .setTitle("Warned Member")
            .addField("Member", member, true)
            .addField("Reason", reason, true)
            .build()
    }
    fun globalChat(message:String, sender: Member, guild: Guild, ): EmbedBuilder {
        val color = if(sender.roles.size <= 0){
            Color.GRAY
        }else{
            sender.roles[0].color
        }
        val badge =
            try {
                Load().stringFromJson("D:\\Intelleij Projects\\src\\main\\resources\\badge.json", sender.id)
            }catch(e:JSONException){
                "User"
            }

        return EmbedBuilder()
            .setTitle(badge)
            .setAuthor("«" + sender.user.name + "»", "https://github.com/AureumApes", sender.user.avatarUrl)
            // .setThumbnail(sender.user.avatarUrl)
            .setDescription("$message\n\n⠀")
            .addField("Links", "[Developer](https://github.com/AureumApes)", false)
            .setColor(color)
            .setFooter("Name: ${guild.name}︙Id: ${guild.id}", guild.iconUrl)

    }
}