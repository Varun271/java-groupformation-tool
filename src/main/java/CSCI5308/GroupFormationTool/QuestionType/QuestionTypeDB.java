package CSCI5308.GroupFormationTool.QuestionType;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionTypeDB implements IQuestionTypePersistence {

    public void loadQuestionTypeByID(long id, QuestionType question) {
        CallStoredProcedure proc=null;
        {
            try
            {
                proc = new CallStoredProcedure("spLoadQuestionTypeByID(?)"); //change called procedure
                proc.setParameter(1,id);
                ResultSet rs = proc.executeWithResults();
                if(null != rs)
                {
                    while (rs.next())
                    {
                            String questiontype= rs.getString(2);
                            question.setId(id);
                            question.setQuestionType(questiontype);
                    }
                }

            }
            catch (SQLException e)
            {
                //Logging Required;
            }
            finally
            {
                if(null != proc)
                {
                    proc.cleanup();
                }
            }
        }

    }


    public boolean delete(long id)
    {
        CallStoredProcedure proc = null;
        {
            try
            {
                proc = new CallStoredProcedure("spDeleteQuestionType(?)"); //change called procedure
                proc.setParameter(1, id);
                proc.execute();
            }
            catch (SQLException e)
            {
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
}
