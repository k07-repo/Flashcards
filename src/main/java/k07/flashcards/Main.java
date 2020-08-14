package k07.flashcards;

import com.google.gson.internal.LinkedTreeMap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.google.gson.Gson;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RootWindow window = new RootWindow();
        window.setSize(500, 500);
        window.setVisible(true);
    }
}
