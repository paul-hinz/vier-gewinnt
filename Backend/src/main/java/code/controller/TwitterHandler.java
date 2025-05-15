package code.controller;



import io.github.cdimascio.dotenv.Dotenv;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Der TwitterHandler stellt mithilfe der .env Datei eine Verbindung zur TwitterAPI her, um einen Tweet auf X (ehemals Twitter) zu veröffentlichen
 *
 */
public class TwitterHandler {
    private static final String apiKey;
    private static final String apiKeySecret;
    private static final String accessToken;
    private static final String accessTokenSecret;

    private static final String SIGNATURE_METHOD = "HMAC-SHA1";
    private static final String OAUTH_VERSION = "1.0";
    private static final String sendTweetEndpoint = "https://api.twitter.com/2/tweets";

    static {
        final Dotenv dotenv = Dotenv.configure().load();
        apiKey = dotenv.get("API_KEY");
        apiKeySecret = dotenv.get("API_KEY_SECRET");
        accessToken = dotenv.get("ACCESS_TOKEN");
        accessTokenSecret = dotenv.get("ACCESS_TOKEN_SECRET");
    }

    /**
     * Sendet die übergebene Nachricht an Twitter
     *
     * @param gameData verfasster Tweet
     * @return true = erfolgreich veröffentlicht
     * @throws JSONException
     */
    public static boolean postResult(String gameData) throws JSONException {
        HttpClient httpClient = HttpClient.newHttpClient();
        String authHeader = generateAuthorizationHeader();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(new JSONObject().put("text", gameData).toString())) // The body of the request as a query string
                .uri(URI.create(sendTweetEndpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", authHeader)
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            return response.statusCode() == 201;
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }

    private static String generateAuthorizationHeader() {
        String randomNonce = String.format("%06d", new SecureRandom().nextInt(1000000000));
        String timestamp = String.valueOf(Instant.now().getEpochSecond());

        StringBuilder signatureBuilder = new StringBuilder()
                .append("POST&")
                .append(URLEncoder.encode(sendTweetEndpoint, StandardCharsets.UTF_8))
                .append("&")
                .append(encodeParameter("oauth_consumer_key", apiKey))
                .append(encodeParameter("oauth_nonce", randomNonce))
                .append(encodeParameter("oauth_signature_method", SIGNATURE_METHOD))
                .append(encodeParameter("oauth_timestamp", timestamp))
                .append(encodeParameter("oauth_token", accessToken))
                .append(encodeParameter("oauth_version", OAUTH_VERSION));
        signatureBuilder.delete(signatureBuilder.length() - 3, signatureBuilder.length());  //delete last encoded "&"
        String signatureBase = signatureBuilder.toString();

        String signingKey = URLEncoder.encode(apiKeySecret, StandardCharsets.UTF_8) + "&" +
                URLEncoder.encode(accessTokenSecret, StandardCharsets.UTF_8);

        String header = new StringBuilder("OAuth ")
                .append("oauth_consumer_key=\"").append(apiKey).append("\",")
                .append("oauth_token=\"").append(accessToken).append("\",")
                .append("oauth_signature_method=\"").append(SIGNATURE_METHOD).append("\",")
                .append("oauth_timestamp=\"").append(timestamp).append("\",")
                .append("oauth_nonce=\"").append(randomNonce).append("\",")
                .append("oauth_version=\"").append(OAUTH_VERSION).append("\",")
                .append("oauth_signature=\"")
                .append(URLEncoder.encode(generateHmacSha1Signature(signatureBase, signingKey), StandardCharsets.UTF_8))
                .append("\"").toString();

        return header;
    }

    public static String generateHmacSha1Signature(String data, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            byte[] hmacBytes = mac.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(hmacBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String encodeParameter(String key, String value) {
        return URLEncoder.encode(key + "=" + value + "&", StandardCharsets.UTF_8);
    }
}

