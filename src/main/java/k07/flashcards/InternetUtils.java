package k07.flashcards;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Map;

public class InternetUtils {
    public static CharacterTuple obtainMapForKanji(String inputCharacter) {
        try {
            HttpResponse<String> response = Unirest.get("https://kanjialive-api.p.rapidapi.com/api/public/kanji/" + inputCharacter)
                    .header("x-rapidapi-host", "kanjialive-api.p.rapidapi.com")
                    .header("x-rapidapi-key", "6ef255f0a5mshfa9963dd0198b3cp1b2e23jsn672c1fdff7cf")
                    .asString();

            Gson gson = new Gson();

            //System.out.println(response.toString();
            Map map = gson.fromJson(response.getBody(), Map.class);

            //Separate info
            Map subMap = (LinkedTreeMap)map.get("kanji");
            String character = subMap.get("character").toString();
            String meaning = ((LinkedTreeMap)subMap.get("meaning")).get("english").toString();

            Map onyomi = (LinkedTreeMap)subMap.get("onyomi");
            String onyomiRomaji = onyomi.get("romaji").toString();
            String onyomiKatakana = onyomi.get("katakana").toString();

            Map kunyomi = (LinkedTreeMap)subMap.get("kunyomi");
            String kunyomiRomaji = kunyomi.get("romaji").toString();
            String kunyomiHiragana = kunyomi.get("hiragana").toString();

            CharacterTuple kanji = new CharacterTuple(character, meaning, onyomiRomaji, onyomiKatakana, kunyomiRomaji, kunyomiHiragana);
            return kanji;
        }
        catch (UnirestException e){
            e.printStackTrace();
        }
        return null;
    }
}
