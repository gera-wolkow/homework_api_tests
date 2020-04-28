package homework_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by yuriyryndin on 08.04.2020
 */
public class GetPosts extends BeforeAll {

    @Test(groups = {"smoke"})
    public static void getAllPosts() {
        int status_code = getPosts().getStatusCode();
        System.out.println(status_code);
        Assert.assertEquals(status_code, 200);
    }

    @Test(groups = {"smoke"})
    public static void getRandomPost() {
        int status_code = getPost(postId).getStatusCode();
        System.out.println(status_code);
        Assert.assertEquals(status_code, 200);
    }

    @Test
    public static void getRandomPostData() {
        int postData = getPost(postId).path("id");
        System.out.println(postData);
        Assert.assertEquals(postData, postId);
    }

    @Test(groups = {"smoke"})
    public static void getCommentsForRandomPost() {
        int status_code = getCommentForPost(postId).getStatusCode();
        System.out.println(status_code);
        Assert.assertEquals(status_code, 200);
    }

    @Test
    public static void getCommentsDataForRandomPost() {
        List<Map<String, Object>> value = getCommentForPost(postId).path("");
        for (Map<String, Object> map : value) {
            int postData = (int) map.get("postId");
            System.out.println(postData);
            Assert.assertEquals(postData, postId);
        }
    }
}
