package homework_tests;

import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by yuriyryndin on 08.04.2020
 */
public class beforeAll extends Main{
    public static int postId;
    public static String postTitle;
    public static String postBody;

    @BeforeSuite
    public void healthCheck (){
        Response result;
        result = given().contentType("application/json").when().get(https_url).then().extract().response();
        Assert.assertEquals(result.getStatusCode(), 200);
    }

    @BeforeClass
    public void generateRandomDataForTest (){
        //here should be method that generates random data but I will use hardcode
        postId = 15;
        System.out.println(postId);
        postTitle = "qui est esse";
        System.out.println(postTitle);
        postBody = "delectus reiciendis molestiae occaecati non minima eveniet qui voluptatibus\\naccusamus in eum beatae sit\\nvel qui neque voluptates ut commodi qui incidunt\\nut animi commodi";
        System.out.println(postBody);
    }
}
