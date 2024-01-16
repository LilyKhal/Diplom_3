package api;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String LOGIN_USER_URL = "/api/auth/login";
    private static final String INFO_USER_URL = "/api/auth/user";

    public Response login(UserCred userCred) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userCred)
                .when()
                .post(LOGIN_USER_URL);
    }
    public Response delete(String token) {
        return given()
                .header("Content-type","application/json")
                .and()
                .header("Authorization", token)
                .when()
                .delete(INFO_USER_URL);

    }
}