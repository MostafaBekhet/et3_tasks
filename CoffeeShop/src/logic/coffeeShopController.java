package logic;

import java.sql.*;

public class coffeeShopController {

    private Connection connection;
    private Statement statement;
    private PreparedStatement pst;
    private ResultSet resultSet;

    private void openConnection() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb" , "root" , "root");

            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean authenticateAdmin(String name , String password) {

        this.openConnection();
        try {
            this.resultSet = this.statement.executeQuery("select * from admin");

            while(this.resultSet.next()) {
                if(name.equals(this.resultSet.getString("name"))
                        && password.equals(this.resultSet.getString("password")))
                    return true;
            }

            this.connection.close();

            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addBeverage(int id, String name, int price, int categoryId, int i) {
        this.openConnection();
        try {
            this.pst = connection.prepareStatement("insert into beverage(id, name, price, beverage_category_idbeverage_category, beverage_category_id)" +
                    "values(?,?,?,?,?)");

            pst.setString(1 , String.valueOf(id));
            pst.setString(2 , name);
            pst.setString(3 , String.valueOf(price));
            pst.setString(4 , String.valueOf(categoryId));
            pst.setString(5 , String.valueOf(categoryId));

            pst.executeUpdate();

            this.connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet getBeverageTabel() {
        this.openConnection();
        try {
            this.pst = connection.prepareStatement("select * from beverage");
            this.resultSet = pst.executeQuery();

            return this.resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
