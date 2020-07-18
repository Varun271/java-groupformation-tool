package CSCI5308.GroupFormationTool.QuestionsTest;

import CSCI5308.GroupFormationTool.Questions.IQuestionBankPersistence;
import CSCI5308.GroupFormationTool.Questions.QuestionBank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionBankDBMock implements IQuestionBankPersistence {
    public boolean insertQuestion(QuestionBank questionBank) {
        ArrayList options = new ArrayList();
        options.add("firstoption");
        ArrayList values = new ArrayList();
        values.add(1);
        questionBank.setQuestionText("How are the course contents");
        questionBank.setQuestionTitle("Ratings");
        questionBank.setQuestionOption(options);
        questionBank.setQuestionValue(values);
        return true;
    }

    public QuestionBank getQuestionById(int question_id, QuestionBank qu) {
        qu.setQuestionID(1);
        qu.setQuestionTitle("New question");
        qu.setQuestionText("New Question Text");
        ArrayList options = new ArrayList();
        options.add("first option");
        qu.setQuestionOption(options);
        return qu;
    }

    @Override
    public List<QuestionBank> getallQuestions(String orderBy) {
        List<QuestionBank> questionBank = new ArrayList<>();
        List<Integer> qIds = new ArrayList<>();
        QuestionBank qu = new QuestionBank();
        QuestionBank qu1 = new QuestionBank();
        qu.setQuestionID(1);
        qu.setQuestionTitle("New question");
        qu.setQuestionText("New Question Text");
        ArrayList options = new ArrayList();
        options.add("first option");
        qu.setQuestionOption(options);

        qIds.add(qu.getQuestionID());
        questionBank.add(qu);

        qu1.setQuestionID(2);
        qu1.setQuestionTitle("New second question");
        qu1.setQuestionText("New second Question Text");
        ArrayList options2 = new ArrayList();
        options2.add("first option");
        qu1.setQuestionOption(options2);
        qIds.add(qu1.getQuestionID());
        questionBank.add(qu1);

        Collections.sort(qIds);
        return questionBank;
    }

    public boolean deleteQuestionById(int question_id) {
        QuestionBank qBank = new QuestionBank();
        qBank.setQuestionID(1);
        qBank.setQuestionTitle("New Question");
        qBank.setQuestionText("New Question Text");
        qBank = null;
        return true;
    }

    public List<QuestionBank> getallQuestions() {
        List<QuestionBank> questionBank = new ArrayList<>();
        QuestionBank qu = new QuestionBank();
        QuestionBank qu1 = new QuestionBank();
        qu.setQuestionID(1);
        qu.setQuestionTitle("New question");
        qu.setQuestionText("New Question Text");
        ArrayList options = new ArrayList();
        options.add("first option");
        qu.setQuestionOption(options);

        questionBank.add(qu);

        qu1.setQuestionID(2);
        qu1.setQuestionTitle("New second question");
        qu1.setQuestionText("New second Question Text");
        ArrayList options2 = new ArrayList();
        options2.add("first option");
        qu1.setQuestionOption(options2);
        questionBank.add(qu1);
        return questionBank;
    }
}


