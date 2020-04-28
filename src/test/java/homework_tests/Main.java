package homework_tests;

import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;


/**
 * Created by yuriyryndin on 08.04.2020
 */
public class Main {
    public static final String URL = "http://jsonplaceholder.typicode.com/";

    public static Response getPosts () {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(URL + "posts").then().extract().response();
        return result;
    }

    public static Response getPost (int number) {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(URL + "posts/" + number).then().extract().response();
        return result;
    }

    public static Response getComments () {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(URL + "comments").then().extract().response();
        return result;
    }

    public static Response getCommentForPost (int number) {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(URL + "posts/"+ number + "/comments").then().extract().response();
        return result;
    }

    public static Response getCommentsForPost (int number) {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(URL + "comments?postId=" + number).then().extract().response();
        return result;
    }

    public static Response postPost (JSONObject postData) {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").body(postData.toString()).when().post(URL + "posts").then().extract().response();
        return result;
    }
}
