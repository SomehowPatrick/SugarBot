package util

class SwearWords {
    fun contains(message:String): Boolean {
        val swearWords = Regex("(fuck|asshole|bitch)")
        if(swearWords.containsMatchIn(message.toLowerCase())){
            return true
        }
        return false
    }
}