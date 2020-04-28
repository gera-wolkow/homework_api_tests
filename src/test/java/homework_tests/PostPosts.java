package homework_tests;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by yuriyryndin on 09.04.2020
 */
public class PostPosts extends BeforeAll {
    static public int newPostData;

    @Test(groups = {"smoke"})
    public static void createNewPost() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("title",postTitle);
        jsonBody.put("body", postBody);
        jsonBody.put("userId", 1);
        int status_code = postPost(jsonBody).getStatusCode();
        System.out.println(status_code);
        Assert.assertEquals(status_code, 201);
    }

    @Test
    public static void createNewPostAndCheckData() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("title",postTitle);
        jsonBody.put("body", postBody);
        jsonBody.put("userId", 1);
        Response response = postPost(jsonBody);
        newPostData = response.path("id");
        System.out.println(newPostData);
        Assert.assertEquals(response.path("title"), postTitle);
        Assert.assertEquals(response.path("body"), postBody);
        Assert.assertEquals((int) response.path("userId"),1);
    }
}
