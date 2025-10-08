import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final HttpClient client = HttpClient.newHttpClient();
    public void fetchQuestions(int amount, String difficulty, String type) {
        String url = "https://opentdb.com/api.php?amount=" + amount + "&difficulty" + difficulty + "&type" + type;
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();
        HttpResponse<String> resp = null;
        try{
            resp= client.send(req, HttpResponse.BodyHandlers.ofString());
        }catch(Exception e){
            System.out.println("Richiesta fallita: " + e.getMessage());
        }


        Gson gson = new Gson();
        APIResponse apiResponse = gson.fromJson(resp.body(), APIResponse.class);
        if(apiResponse.response_code != 0){
            System.out.println("Errore:" + apiResponse.response_code);
            return;
        }

            for(APIQuestion question : apiResponse.results){
            System.out.println(question.question);
            System.out.println(question.correct_answer + "\n");
        }
    }
}
