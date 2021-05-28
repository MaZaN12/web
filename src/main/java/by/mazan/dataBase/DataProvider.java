package by.mazan.dataBase;

import by.mazan.exception.DeleteException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static String sql = null;

    private static Connection connection = null;
    private static PreparedStatement statement = null;


    private final List<DemoEntity> entities = new ArrayList<>();

    public DataProvider(){
        try{
            Class.forName(JDBC_DRIVER);   //Registering JDBC driver
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);   //Creating database connection
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public List<DemoEntity> getAllEntities() {
        // TODO: реализовать получение всех записей через слой БД
        try {
            sql = "SELECT * FROM users";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            entities.clear();
            while (resultSet.next()){
                DemoEntity demoEntity = new DemoEntity();
                demoEntity.setId(resultSet.getInt("id"));
                demoEntity.setName(resultSet.getString("name"));
                demoEntity.setSpecialty(resultSet.getString("specialty"));
                demoEntity.setSalary(resultSet.getInt("salary"));
                entities.add(demoEntity);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return entities;
    }

    public void addEntity(DemoEntity entity) throws SQLException {
        // TODO: реализовать добавление записи в слое БД
        sql = "INSERT INTO users (name, specialty, salary) VALUES (?, ?, ?)";
        statement = connection.prepareStatement(sql);

        statement.setString(1, entity.getName());
        statement.setString(2, entity.getSpecialty());
        statement.setInt(3, entity.getSalary());
        statement.execute();
    }

    public void deleteEntityById(int id) throws DeleteException {
        // TODO: реализовать удаление через слой БД
        List<Integer> list = new ArrayList<>();
        try{
            sql = "SELECT * FROM users";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                list.add(resultSet.getInt("id"));
            }

            if (!list.contains(id)){
                throw new DeleteException(404, "Id not found");
            }

            sql = "DELETE FROM users WHERE ID = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException  e){
            throw new DeleteException(404, "Id not found");
        }

    }

    @Override
    protected void finalize() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


