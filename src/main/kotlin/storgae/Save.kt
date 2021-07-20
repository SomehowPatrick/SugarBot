package storgae

import org.json.JSONObject;
import java.io.File

class Save {
    fun toJson(filename:String, key:String, value:String){
        val jObject:JSONObject = JSONObject(File(filename).readText());
        jObject.put(key, value);
        File(filename).writeText(jObject.toString())
    }

    fun toJson(filename:String, key:String, value:Int){
        val jObject:JSONObject = JSONObject(File(filename).readText());
        jObject.put(key,value)
        File(filename).writeText(jObject.toString())
    }

    fun toJson(filename:String, key:String, secondKey:String, value:String){
        val jObject:JSONObject = JSONObject(File(filename).readText());
        jObject.getJSONObject(key).put(secondKey, value)
        File(filename).writeText(jObject.toString())
    }

    fun toJson(filename:String, key:String, secondKey:String, value:Int){
        val jObject:JSONObject = JSONObject(File(filename).readText());
        jObject.getJSONObject(key).put(secondKey, value)
        File(filename).writeText(jObject.toString())
    }

    fun toJsonList(filename:String, key:String, value:String){
        val jObject:JSONObject = JSONObject(File(filename).readText());
        jObject.append(key, value)
        File(filename).writeText(jObject.toString())
    }

    fun toJsonList(filename:String, key:String, value:Int){
        val jObject:JSONObject = JSONObject(File(filename).readText());
        jObject.append(key, value)
        File(filename).writeText(jObject.toString())
    }

    fun toJsonList(filename:String, key:String, value:Any){
        val jObject:JSONObject = JSONObject(File(filename).readText());
        jObject.append(key, value)
        File(filename).writeText(jObject.toString())
    }
}