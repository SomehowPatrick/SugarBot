package listener

import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import storgae.Save
import java.io.File

class OnMenuSelected : ListenerAdapter() {
    override fun onSelectionMenu(event: SelectionMenuEvent) {
        if (event.selectionMenu?.id == event.member?.id + "-like-menu") {
            File("D:\\Intelleij Projects\\src\\main\\resources\\feedback.txt").appendText(
                "\n" +
                        event.member?.user?.name + ": " +
                        (event.selectedOptions?.get(0)?.label +
                                ", " +
                                event.selectedOptions?.get(0)?.value)
            )
            event.editMessage("Thanks for sending Feedback " + event.member?.asMention).queue()
            event.editSelectionMenu(null).queue()
        }else if(event.selectionMenu?.id == "gender_menu"){
            event.editMessage("Gender set to **" + event.selectedOptions?.get(0)?.value+ "**").queue()
            val memberId = event.member?.id
            val gender = event.selectedOptions?.get(0)?.value
            if (memberId != null) {
                if (gender != null) {
                    Save().toJson("D:\\Intelleij Projects\\src\\main\\resources\\gender.json", memberId, gender)
                }
            }
            event.editSelectionMenu(null).queue()
        }
    }
}