package homework_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by yuriyryndin on 09.04.2020
 */
public class GetComments extends BeforeAll {
    @Test(groups = {"smoke"})
    public static void getAllComments() {
        int status_code = getComments().getStatusCode();
        System.out.println(status_code);
        Assert.assertEquals(status_code, 200);
    }

    @Test(groups = {"smoke"})
    public static void getCommentsForRandomPost() {
        int status_code = getCommentsForPost(postId).getStatusCode();
        System.out.println(status_code);
        Assert.assertEquals(status_code, 200);
    }

    @Test
    public static void getCommentsDataForRandomPost() {
        List<Map<String, Object>> value = getCommentsForPost(postId).path("");
        for (Map<String, Object> map : value) {
            int postData = (int) map.get("postId");
            System.out.println(postData);
            Assert.assertEquals(postData, postId);
        }
    }
}
