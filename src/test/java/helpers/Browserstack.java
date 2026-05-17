package helpers;

// import config.web.MobileConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    //private static final MobileConfig config = ConfigFactory.create(MobileConfig.class);

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("bsuser_HRrmko", "x6DRwo1GGHfek7rCVbpV")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }

    public static void authBrowserstack(String[] args) {
        String response = given()
                .auth().basic("bsuser_HRrmko", "x6DRwo1GGHfek7rCVbpV")
                .get("https://api.browserstack.com/app-automate/sessions")
                .then()
                .extract()
                .asString();
        System.out.println(response);
    }
}