package CSCI5308.GroupFormationTool.ResponseTest;

import CSCI5308.GroupFormationTool.Response.IResponsePersistence;
import CSCI5308.GroupFormationTool.Response.Response;

import java.util.ArrayList;

public class ResponseDBMock implements IResponsePersistence {

    public void loadresponsebyId(long id, Response r) {
        r.setStudentID(1);
        r.setQuestionID(1);
        ArrayList options = new ArrayList();
        options.add("First Option");
        ArrayList values = new ArrayList();
        values.add(1);

    }


    public boolean deleteresponsebyId(long id) {
        Response r = new Response();
        r.setStudentID(id);
        r = null;
        return true;
    }


}
