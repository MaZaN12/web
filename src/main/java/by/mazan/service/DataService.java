package by.mazan.service;
import by.mazan.dataBase.DataProvider;
import by.mazan.dataBase.UserProvider;
import by.mazan.dataBase.DemoEntity;
import by.mazan.exception.DeleteException;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.List;

public class DataService {
    private final DataProvider dataProvider;
//    private final Gson gson;

    public DataService() {
        dataProvider = new DataProvider();
//        gson = new Gson();
    }

    public List<DemoEntity> getAllEntitiesForResponse() {
        return dataProvider.getAllEntities();
    }

//    public void addEntity(String entityString) throws SQLException {
//        dataProvider.addEntity(gson.fromJson(entityString, DemoEntity.class));
//    }
    public void addEntity(DemoEntity entity) throws SQLException {
    dataProvider.addEntity(entity);
}

    public void deleteEntity(String id) throws DeleteException{
        try {
            dataProvider.deleteEntityById(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw new DeleteException(400, "Invalid id value");
        }
        }

    public boolean checkUsers(String name, String password){
        UserProvider userProvider = new UserProvider();
        return userProvider.checkProfile(name,password);
    }

}

