package commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import org.json.JSONException
import storgae.Load
import storgae.Save

class RankCommand {
    fun onSlashCommand(event: SlashCommandEvent) {
        val user = event.getOption("user")?.asUser
        val rank = event.getOption("rank")?.asString
        if(rank == null){
            val userRank = try{
                Load().stringFromJson("D:\\Intelleij Projects\\src\\main\\resources\\badge.json", user?.id!!)
            }catch (e:JSONException){
                "User"
            }
            val rankEmbed = EmbedBuilder()
                .setTitle("Rankinfo")
                .addField("User", user?.asMention, true)
                .addField("Rank", userRank, true)
                .build()
            event.replyEmbeds(rankEmbed).setEphemeral(true).queue()
        }else{
            if(event.member?.id == "608920482284306434"){
                val savedRank = when(rank){
                    "admin" -> "<:admin:865994596260773928> Admin"
                    "mod" -> "<:mod:865994611415318568> Mod"
                    "friend" -> "\uD83E\uDD1D Friend"
                    "bug" -> "<:debugger:866028097760264193> Bughunter"
                    else -> "User"
                }

                Save().toJson("D:\\Intelleij Projects\\src\\main\\resources\\badge.json", user?.id!!, savedRank)
                event.replyEmbeds(EmbedBuilder()
                    .setTitle("Set Users Rank")
                    .addField("User", user.asMention, true)
                    .addField("Rank", savedRank, true)
                    .build()).queue()
            }
        }
    }
}