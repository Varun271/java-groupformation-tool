package CSCI5308.GroupFormationTool.Response;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResponseDB implements IResponsePersistence {

    public void loadresponsebyId (long id, Response r) {
        CallStoredProcedure proc= null;
        {
            try
            {
                proc = new CallStoredProcedure("spLoadResponse(?)");
                proc.setParameter(1,id);
                ResultSet rs = proc.executeWithResults();
                if(rs != null){
                    while (rs.next()){
                        long Id = rs.getLong(1);
                        long qusId = rs.getLong(2);
                        ArrayList optionarray = new ArrayList();
                        optionarray= (ArrayList) rs.getArray("3");
                        ArrayList valuesarray = new ArrayList();
                        valuesarray= (ArrayList) rs.getArray(4);

                        r.setStudentID(id);
                        r.setQuestionID(qusId);
                        r.setResponseOption(optionarray);
                        r.setResponseValue(valuesarray);
                    }
                }
            } catch (SQLException e)
            {
                //logging
            }
            finally
            {
                proc.cleanup();
            }

        }

    }


    public boolean deleteresponsebyId (long id)
    {
        CallStoredProcedure proc=null;
        {
            try
            {
                proc= new CallStoredProcedure("spDeleteResponse(?)");
                proc.setParameter(1,id);
                proc.execute();
            } catch (SQLException e)
            {
                return  false;
            } finally
            {
                proc.cleanup();

            }
        }
        return true;
    }

}
