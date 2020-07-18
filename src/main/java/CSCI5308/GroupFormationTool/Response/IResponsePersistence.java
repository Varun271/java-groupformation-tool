package CSCI5308.GroupFormationTool.Response;

public interface IResponsePersistence {
    public void loadresponsebyId (long id, Response r);
    public boolean deleteresponsebyId ( long id);
}
