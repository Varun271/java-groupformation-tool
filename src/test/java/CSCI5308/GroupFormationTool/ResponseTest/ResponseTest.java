package CSCI5308.GroupFormationTool.ResponseTest;

import CSCI5308.GroupFormationTool.Response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@SuppressWarnings("deprecation")

public class ResponseTest {

    @Test
    public void ConstructorTest() {
        Response r = new Response();
        Assert.isTrue(r.getQuestionID() == -1);
        Assert.isTrue(r.getStudentID() == -1);
        Assert.isTrue(r.getResponseValue() == null);
        Assert.isTrue(r.getResponseOption() == null);
    }

    @Test
    public void getStudentIDTest() {
        Response r = new Response();
        r.setStudentID(10);
        Assert.isTrue(10 == r.getStudentID());
    }

    @Test
    public void setStudentIDTest() {
        Response r = new Response();
        r.setStudentID(10);
        Assert.isTrue(10 == r.getStudentID());
    }

    @Test
    public void getQuestionIDTest() {
        Response r = new Response();
        r.setQuestionID(1);
        Assert.isTrue(1 == r.getQuestionID());
    }

    @Test
    public void setQuestionIDTest() {
        Response r = new Response();
        r.setQuestionID(1);
        Assert.isTrue(1 == r.getQuestionID());
    }

    @Test
    public void getResponseOptionTest() {
        Response r = new Response();
        ArrayList option = new ArrayList();
        option.add("first option");

        //Check empty list
        assertThat(option.isEmpty());

        r.setResponseOption(option);
        Assert.isTrue(r.getResponseOption().equals(option));
    }

    @Test
    public void setResponseOptionTest() {
        Response r = new Response();
        ArrayList res_option = new ArrayList();

        //Check empty list
        assertThat(res_option.isEmpty());

        res_option.add("first option");
        r.setResponseOption(res_option);
        Assert.isTrue(r.getResponseOption().equals(res_option));
    }

    @Test
    public void setResponseValueTest() {
        Response r = new Response();
        ArrayList res_value = new ArrayList();

        //Check empty list
        assertThat(res_value.isEmpty());

        res_value.add("1");
        r.setResponseValue(res_value);
        Assert.isTrue(r.getResponseValue().equals(res_value));
    }

    @Test
    public void getResponseValueTest() {
        Response r = new Response();
        ArrayList res_value = new ArrayList();

        //Check empty list
        assertThat(res_value.isEmpty());

        res_value.add("1");
        r.setResponseValue(res_value);
        Assert.isTrue(r.getResponseValue().equals(res_value));
    }

}
