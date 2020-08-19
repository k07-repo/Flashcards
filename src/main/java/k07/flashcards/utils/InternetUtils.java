package k07.flashcards.utils;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import k07.flashcards.tuples.CharacterTuple;
import k07.flashcards.tuples.ExampleTuple;

import java.awt.*;
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
            Map map = gson.fromJson(response.getBody(), Map.class);

            //The response key structure can be used to derive what happened
            if(map.containsKey("message")) {
                //Error occured, likely bad API key
                DialogUtils.displayErrorMessage("An error occured, check your API key.");
            }
            else if(map.containsKey("error")) {
                //Error occured, kanji not found
                DialogUtils.displayErrorMessage("Invalid or unsupported kanji!");
            }
            else if(map.containsKey("kanji")) {
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
        }
        catch (UnirestException e) {
            //Error with the request
            DialogUtils.displayErrorMessage("Couldn't connect to API!\nCheck your internet connection.");
        }

        return null;
    }
}
