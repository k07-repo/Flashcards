package k07.flashcards.utils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import k07.flashcards.tuples.CharacterTuple;
import k07.flashcards.tuples.ExampleTuple;

import java.util.ArrayList;
import java.util.Map;

public class InternetUtils {
    public static CharacterTuple obtainMapForKanji(char inputCharacter, String apiKey) {
        try {
            HttpResponse<String> response = Unirest.get("https://kanjialive-api.p.rapidapi.com/api/public/kanji/" + inputCharacter)
                    .header("x-rapidapi-host", "kanjialive-api.p.rapidapi.com")
                    .header("x-rapidapi-key", apiKey)
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

            String imageUrl = ((LinkedTreeMap)subMap.get("video")).get("poster").toString();
            Object o = ((LinkedTreeMap)map.get("references")).get("grade");
            int grade;
            if(o == null) {
                grade = 0;
            }
            else {
                grade = (int)((double)((LinkedTreeMap)map.get("references")).get("grade")); //casting straight to int doesn't work
            }

            Map strokes = (LinkedTreeMap)subMap.get("strokes");
            ArrayList<String> strokeURLs = (ArrayList<String>)strokes.get("images");

            ArrayList<LinkedTreeMap> examples = (ArrayList<LinkedTreeMap>)map.get("examples");
            ArrayList<ExampleTuple> exampleList = new ArrayList<>();
            for(int k = 0; k < Math.min(3, examples.size()); k++) {
                LinkedTreeMap current = examples.get(k);
                String exampleJapanese = current.get("japanese").toString();
                String exampleMeaning = ((LinkedTreeMap)current.get("meaning")).get("english").toString();
                exampleList.add(new ExampleTuple(exampleJapanese, exampleMeaning));
            }

            CharacterTuple kanji = new CharacterTuple(character, meaning, onyomiRomaji, onyomiKatakana, kunyomiRomaji, kunyomiHiragana, strokeURLs, imageUrl, exampleList, grade);
            return kanji;
        }
        catch (UnirestException e){
            e.printStackTrace();
        }
        return null;
    }
}
