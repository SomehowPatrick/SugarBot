import listener.OnButtonClick
import listener.OnCommand
import listener.OnMenuSelected
import listener.SwearWordFilter
import net.dv8tion.jda.api.JDABuilder

fun main() {
    val jda = JDABuilder.createDefault("ODYwOTU5MDUyNTg1NjMxNzU1.YOC0mQ.BqRV2EavoS751w5ZgjvXUahovLo")

    jda.addEventListeners(OnCommand())
    jda.addEventListeners(OnButtonClick())
    jda.addEventListeners(OnMenuSelected())
    jda.addEventListeners(SwearWordFilter())
    jda.build()

}