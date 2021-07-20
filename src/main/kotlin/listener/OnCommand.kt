package listener

import commands.*
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.CommandData
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData

class OnCommand : ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.channel.name == "\uD83C\uDF0E︙global" && !event.author.isBot) {
            GlobalChat().onGuildMessageReceived(event)
        }
        val guild = event.guild
        if (event.message.contentRaw.startsWith("?reload")) {
            if (event.author.id != "608920482284306434") {
                event.message.addReaction("<:MoNOpoly:865637415611138118>").queue()
                return
            } else {
                guild.upsertCommand("help", "helps you")
                    .addOption(OptionType.STRING, "command", "the command", true)
                    .queue()
                guild.upsertCommand("whois", "info about somebody")
                    .addOption(OptionType.USER, "user", "the user to stalk", true)
                    .queue()
                guild.upsertCommand("warn", "warns an user")
                    .addOption(OptionType.USER, "user", "user to warn", true)
                    .addOption(OptionType.STRING, "reason", "why is the user warned?", true)
                    .queue()
                guild.upsertCommand("role", "Info about a role")
                    .addOption(OptionType.ROLE, "role", "the role", true)
                    .queue()
                guild.upsertCommand(FileCommand().name, FileCommand().description)
                    .addOption(OptionType.STRING, "filename", "Good Luck", true)
                    .queue()
                guild.upsertCommand("rank", "Set the Rank of an User")
                    .addOption(OptionType.USER, "user", "The User", true)
                    .addOption(OptionType.STRING, "rank", "The Rank to add", false)
                    .queue()
                guild.upsertCommand("poll", "Start a Poll")
                    .addOption(OptionType.STRING, "question", "The Question", true)
                    .addOption(OptionType.STRING, "emojis", "Emojis to Choose From. Split with :", true)
                    .addOption(OptionType.STRING, "opinions", "Opinion too the Emoji Split with :", true)
                    .queue()
                guild.upsertCommand("lyrics", "Searches the Internet for the Lyrics of an Song")
                    .addOption(OptionType.STRING, "query", "The Query to Search in the Internet", true)
                    .queue()
                guild.upsertCommand("github", "Get Information about a github User")
                    .addOption(OptionType.STRING, "name", "Name from the Account", true)
                    .queue()
                guild.upsertCommand("color", "Infos about an hex value")
                    .addOption(OptionType.STRING, "hex", "Hex value to display", true)
                    .queue()
                event.message.reply("Successfully updated Commands").queue()
            }
        } else if (event.message.contentRaw.startsWith("?start")) {
            guild.updateCommands()
                .addCommands(
                    mutableListOf(
                        CommandData("global", "Create Globalchat Channel"),
                        CommandData("gender", "Choose Gender"),
                        CommandData("role", "Info about a role"),
                        CommandData("feedback", "Send feedback"),
                        CommandData("info", "info about Bot"),
                        CommandData("warn", "warns an user"),
                        CommandData("whois", "info about somebody"),
                        CommandData("help", "helps you"),
                        CommandData("rank", "Set the Rank of an User"),
                        CommandData("poll", "Start a Poll"),
                        CommandData("lyrics", "Searches the Internet for the Lyrics of an Song"),
                        CommandData("github", "Get Information about a github User"),
                        CommandData("redpanda", "Send a cute random red panda pic"),
                        CommandData("color", "Infos about an hex value"),
                        CommandData("meme", "Random Meme")
                    )
                )
                .queue()
            event.message.reply("Successfully added Commands").queue()
        }
    }

    override fun onSlashCommand(event: SlashCommandEvent) {
        when (event.name) {
            "help" -> {
                HelpCommand().onSlashCommand(event)
                return
            }
            "whois" -> {
                WhoisCommand().onSlashCommand(event)
                return
            }
            "warn" -> {
                WarnCommand().onSlashCommand(event)
                return
            }
            "feedback" -> {
                FeedbackCommand().onSlashCommand(event)
                return
            }
            "role" -> {
                RoleCommand().onSlashCommand(event)
                return
            }
            "gender" -> {
                GenderCommand().onSlashCommand(event)
                return
            }
            "global" -> {
                GlobalCommand().onSlashCommand(event)
                return
            }
            "rank" -> {
                RankCommand().onSlashCommand(event)
                return
            }
            "file" -> {
                FileCommand().onSlashCommand(event)
                return
            }
            "poll" -> {
                PollCommand().onGuildMessageReceived(event)
                return
            }
            "info" -> {
                InfoCommand().onSlashCommand(event)
                return
            }
            "lyrics" -> {
                LyricsCommand().onSlashCommand(event)
                return
            }
            "github" -> {
                GitHubCommand().onSlashCommand(event)
                return
            }
            "redpanda" -> {
                RedPandaCommand().onSlashCommand(event)
                return
            }
            "color" -> {
                ColorCommand().onSlashCommand(event)
                return
            }
            "meme" -> {
                MemeCommand().onSlashCommand(event)
                return
            }
        }
    }
}