package CSCI5308.GroupFormationTool.Questions;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionManagerDB implements IQuestionBankPersistence {

    @Override
    public boolean insertQuestion(QuestionBank questionBank) {
        {
            String qOption = "";
            String qValue = "";
            for (OptionValue optionValue : questionBank.getOptionValues()) {
                if (StringUtils.isNotEmpty(optionValue.getOption()) && StringUtils.isNotEmpty(optionValue.getValue())) {
                    qOption = qOption + optionValue.getOption() + ",";
                    qValue = qValue + optionValue.getValue() + ",";
                }
            }
            System.out.println(qOption);
            CallStoredProcedure proc = null;
            try {
                proc = new CallStoredProcedure("spInsertQuestion(?, ?, ?, ?, ?)");
                proc.setParameter(1, questionBank.getQuestionTitle());
                proc.setParameter(2, questionBank.getQuestionText());
                proc.setParameter(3, questionBank.getQuestionType());
                proc.setParameter(4, qOption);
                proc.setParameter(5, qValue);
                proc.execute();
            } catch (SQLException e) {
                System.out.println(e);
                // Logging needed
                return false;
            } finally {
                if (null != proc) {
                    proc.cleanup();
                }
            }
            return true;
        }
    }

    @Override
    public QuestionBank getQuestionById(int question_id, QuestionBank questionBank) {
        return null;
    }

    @Override
    public List<QuestionBank> getallQuestions(String orderBy) {
        List<QuestionBank> questions = new ArrayList<QuestionBank>();
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spLoadAllQuestions(?)");
            proc.setParameter(1, orderBy);
            ResultSet results = proc.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    QuestionBank qBank = new QuestionBank();
                    qBank.setQuestionID(results.getInt(1));
                    qBank.setQuestionTitle(results.getString(2));

                    questions.add(qBank);
                }
            }
        } catch (SQLException e) {
            // Logging needed.
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return questions;
    }

    @Override
    public boolean deleteQuestionById(int questionId)
    {
        CallStoredProcedure proc = null;
        try
        {
            proc = new CallStoredProcedure("spDeleteQuestionByID(?)");
            proc.setParameter(1, questionId);
            proc.execute();
        }
        catch (SQLException e)
        {
            // Logging needed
            return false;
        }
        finally
        {
            if (null != proc)
            {
                proc.cleanup();
            }
        }
        return true;
    }
}
