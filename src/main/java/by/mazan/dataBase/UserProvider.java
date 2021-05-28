package by.mazan.dataBase;

import java.sql.*;

public class UserProvider {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection = null;
    private static Statement statement = null;

    public UserProvider(){
        try{
            Class.forName(JDBC_DRIVER);   //Registering JDBC driver
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);   //Creating database connection
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public boolean checkProfile(String name, String password) {
        try{
            String sql = "SELECT * FROM profile";
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                if (resultSet.getString("name").equals(name) && resultSet.getString("password").equals(password)){
                    return true;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
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
