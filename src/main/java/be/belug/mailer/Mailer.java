package be.belug.mailer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.util.HashMap;

import static be.belug.mailer.ApiKey.API_KEY;
import static java.util.Arrays.asList;

public class Mailer {

    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        HashMap<String, Object> data = new HashMap<>();
        data.put("voornaam", "Kenneth");
        data.put("participants", 1);
        data.put("totaalbedrag", 1000);
        data.put("details", asList(
                //new Detail("1m x 2m expositieruimte", "VERGEET JE AFROKDOEKEN NIET"),
                new Detail("Geen ruimte gereserveerd", "")
        ));
        data.put("broodjes", asList(
                new Broodje("Zaterdag", 1, "pitta", 0),
                new Broodje("Zondag", 1, "martino", 0)
        ));
        data.put("diners", asList(
                new Diner(2, "spaghetti", 25)
        ));
        MailTemplate mailTemplate = new MailTemplate(
                new Sender(),
                new Receiver("Kenneth Westelinck", "kenneth.westelinck@gmail.com"),
                2,
                data);

        ObjectMapper mapper = new ObjectMapper();
        RequestBody body = RequestBody.create(mediaType, mapper.writeValueAsString(mailTemplate));
        Request request = new Request.Builder()
                .addHeader("api-key", API_KEY)
                .url("https://api.sendinblue.com/v3/smtp/email")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response);
    }
}
