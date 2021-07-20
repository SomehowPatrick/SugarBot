package storgae

import commands.*

class Storage {
    fun commands(): HashMap<String, Command> {
        val commandList = HashMap<String, Command>()
        commandList["help"] = HelpCommand()
        commandList["whois"] = WhoisCommand()
        commandList["warn"] = WarnCommand()
        commandList["feedback"] = FeedbackCommand()
        commandList["role"] = FeedbackCommand()
        commandList["gender"] = GenderCommand()
        commandList["global"] = GlobalCommand()
        commandList["file"] = FileCommand()
        commandList["poll"] = PollCommand()
        commandList["info"] = InfoCommand()
        commandList["lyrics"] = LyricsCommand()
        return commandList
    }
}