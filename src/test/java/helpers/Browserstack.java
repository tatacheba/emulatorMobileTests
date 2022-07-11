package helpers;

import config.Credentials;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        String url = format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(Credentials.browserstackConfig.user(), Credentials.browserstackConfig.key())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
