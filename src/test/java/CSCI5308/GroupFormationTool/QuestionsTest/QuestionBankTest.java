package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionBankPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionBank;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@SuppressWarnings("deprecation")
public class QuestionBankTest {

    @Test
    public void ConstructorTests() {
        QuestionBank questionBank = new QuestionBank();
        Assert.isTrue(questionBank.getQuestionID() == -1);
        Assert.isTrue(questionBank.getQuestionText().isEmpty());
        Assert.isTrue(questionBank.getQuestionTitle().isEmpty());
        Assert.isTrue(questionBank.getQuestionOption().isEmpty());
        Assert.isTrue(questionBank.getQuestionValue().isEmpty());
    }

    @Test
    public void setquestionIDTest() {
        QuestionBank qu = new QuestionBank();
        qu.setQuestionID(10);
        Assert.isTrue(10 == qu.getQuestionID());
    }

    @Test
    public void getIDTest() {
        QuestionBank qu = new QuestionBank();
        qu.setQuestionID(10);
        Assert.isTrue(10 == qu.getQuestionID());
    }

    @Test
    public void getQuestionTextTest() {
        QuestionBank qu = new QuestionBank();
        qu.setQuestionText("My first question");
        Assert.isTrue(qu.getQuestionText().equals("My first question"));
    }

    @Test
    public void setQuestionTextTest() {
        QuestionBank qu = new QuestionBank();
        qu.setQuestionText("My first question");
        Assert.isTrue(qu.getQuestionText().equals("My first question"));
    }

    @Test
    public void getQuestionTitleTest() {
        QuestionBank qu = new QuestionBank();
        qu.setQuestionTitle("Course name survey");
        Assert.isTrue(qu.getQuestionTitle().equals("Course name survey"));
    }

    @Test
    public void setQuestionTitleTest() {
        QuestionBank qu = new QuestionBank();
        qu.setQuestionTitle("Course name survey");
        Assert.isTrue(qu.getQuestionTitle().equals("Course name survey"));
    }

    @Test
    public void setQuestionOptionTest() {
        QuestionBank qu = new QuestionBank();
        ArrayList options = new ArrayList();
        options.add("firstoption");
        qu.setQuestionOption(options);
        Assert.isTrue(qu.getQuestionOption().equals(options));
    }

    @Test
    public void getQuestionOptionTest() {
        QuestionBank qu = new QuestionBank();
        ArrayList options = new ArrayList();
        options.add("firstoption");
        qu.setQuestionOption(options);
        Assert.isTrue(qu.getQuestionOption().equals(options));
    }

    @Test
    public void getQuestionValueTest() {
        QuestionBank qu = new QuestionBank();
        ArrayList values = new ArrayList();
        values.add(1);
        qu.setQuestionValue(values);
        Assert.isTrue(qu.getQuestionValue().equals(values));
    }

    @Test
    public void insertQuestionTest() {
        IQuestionBankPersistence questionDBMock = new QuestionBankDBMock();
        QuestionBank qu = new QuestionBank();
        boolean returned_value = questionDBMock.insertQuestion(qu);
        Assert.isTrue(returned_value);

    }

    @Test
    public void getQuestionbyidTest() {
        IQuestionBankPersistence questionDBMock = new QuestionBankDBMock();
        QuestionBank qu = new QuestionBank();
        qu.setQuestionID(-1);
        QuestionBank qu1 = questionDBMock.getQuestionById(1, qu);
        Assert.isTrue(qu1.getQuestionID() == 1);
        Assert.isTrue(qu1.getQuestionTitle().equals("New question"));
        Assert.isTrue(qu1.getQuestionText().equals("New Question Text"));
    }

    @Test
    public void getallQuestionsTest() {
        IQuestionBankPersistence questionDBMock = new QuestionBankDBMock();
        QuestionBank qu = new QuestionBank();
        List<QuestionBank> list_of_questions = questionDBMock.getallQuestions("questionTitle");
        Assert.isTrue(list_of_questions.size() > 1);
        System.out.println(list_of_questions.get(0).getQuestionID());
        Assert.isTrue(list_of_questions.get(0).getQuestionID() == 1);
        Assert.isTrue(list_of_questions.get(1).getQuestionID() == 2);
    }

    public void deleteQuestionTest() {
        IQuestionBankPersistence questionDBMock = new QuestionBankDBMock();
        QuestionBank qu = new QuestionBank();
        qu.setQuestionID(1);
        qu.setQuestionTitle("New question");
        qu.setQuestionText("New Question Text");
        ArrayList options = new ArrayList();
        options.add("first option");
        qu.setQuestionOption(options);
        qu.setQuestionID(-1);
        QuestionBank qu1 = questionDBMock.getQuestionById(1, qu);
        Assert.isTrue(qu1.getQuestionID() != 1);
    }

}
