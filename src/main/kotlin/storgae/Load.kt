package storgae

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.net.URL
import java.nio.charset.Charset


class Load {
    fun stringFromJson(filename: String, key: String): String {
        val jObject: JSONObject = JSONObject(File(filename).readText());
        return jObject.get(key).toString()
    }

    fun intFromJson(filename: String, key: String): Int {
        val jObject: JSONObject = JSONObject(File(filename).readText());
        return try {
            jObject.get(key).toString().toInt()
        } catch (e: Exception) {
            0
        }
    }

    @Throws(IOException::class, JSONException::class)
    fun readJsonFromUrl(url: String?): JSONObject? {
        val `is`: InputStream = URL(url).openStream()
        return `is`.use { `is` ->
            val rd = BufferedReader(InputStreamReader(`is`, Charset.forName("UTF-8")))
            val jsonText: String = readAll(rd)
            JSONObject(jsonText)
        }
    }

    @Throws(IOException::class)
    private fun readAll(rd: Reader): String {
        val sb = StringBuilder()
        var cp: Int
        while (rd.read().also { cp = it } != -1) {
            sb.append(cp.toChar())
        }
        return sb.toString()
    }

    fun listFromJson(filename: String, key: String): JSONArray? {
        val jObject = JSONObject(File(filename).readText())
        return jObject.getJSONArray(key)
    }
}