package CSCI5308.GroupFormationTool.Response;

import java.util.ArrayList;

public class Response {
    private long studentID;
    private long questionID;
    private ArrayList responseOption;
    private ArrayList responseValue;

    public Response(){
        setDefault();
    }
    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }

    public ArrayList getResponseOption() {
        return responseOption;
    }

    public void setResponseOption(ArrayList responseOption) {
        this.responseOption = responseOption;
    }

    public ArrayList getResponseValue() {
        return responseValue;
    }

    public void setResponseValue(ArrayList responseValue) {
        this.responseValue = responseValue;
    }

    public boolean delete(IResponsePersistence response) {return response.deleteresponsebyId(studentID);}

    public void setDefault(){
        studentID=-1;
        questionID=-1;
        responseOption=null;
        responseValue= null;
    }
}
