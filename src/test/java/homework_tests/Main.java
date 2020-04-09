package homework_tests;

import com.jayway.restassured.response.Response;
import org.json.simple.JSONObject;

import static com.jayway.restassured.RestAssured.given;


/**
 * Created by yuriyryndin on 08.04.2020
 */
public class Main {
    static String https_url = "http://jsonplaceholder.typicode.com/";

    public static Response getPosts () {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(https_url + "posts").then().extract().response();
        return result;
    }

    public static Response getPost (int number) {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(https_url + "posts/" + number).then().extract().response();
        return result;
    }

    public static Response getComments () {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(https_url + "comments").then().extract().response();
        return result;
    }

    public static Response getCommentForPost (int number) {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(https_url + "posts/"+ number + "/comments").then().extract().response();
        return result;
    }

    public static Response getCommentsForPost (int number) {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").when().get(https_url + "comments?postId=" + number).then().extract().response();
        return result;
    }

    public static Response postPost (JSONObject postData) {
        Response result;
        result = given().contentType("application/json; charset=UTF-8").body(postData.toString()).when().post(https_url + "posts").then().extract().response();
        return result;
    }
}
