/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import User.UserList;
import Pet.Pet;
import Pet.Dog;
import Pet.Cat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is
 *
 * @author phaisan
 */
public class UserDB {

    public Connection connection = null;
    public String url = "jdbc:derby:UserDB;create=true";  //url of the DB host
    public String usernameDerby = "admin";  //your DB usernameDerby
    public String passwordDerby = "1234";   //your DB passwordDerby

    public String tableName = "UserDB";
    public Statement statement;
    public ResultSet resultSet;

    //Get and Set for table name
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * The constructor
     *
     */
    public UserDB() {
        establishConnection();
    }

    /**
     * The method to get data into user list
     *
     * @param userList
     */
    public void getData(UserList userList) {
        try {
            if (checkTableExisting(tableName)) {
                getQuery(userList);
            }
        } catch (SQLException ex) {
            System.out.println("Error : getting data");
        }

    }

    /**
     * The method to get data form use list into database
     *
     * @param userList
     */
    public void setData(UserList userList) {
        createTable();
        if (!userList.getUserList().isEmpty()) {
            insertTable(userList);
        }
    }

    /**
     * The method to connect database
     *
     */
    public void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, usernameDerby, passwordDerby);
            statement = connection.createStatement();
            System.out.println(url + " is connected");

        } catch (SQLException ex) {
            System.out.println("Error : connecting database");
        }

    }

    /**
     * The method to create table
     *
     */
    public void createTable() {
        try {
            if (checkTableExisting(tableName)) {
                delectTable(tableName);
            }
            String sqlCreate = "create table " + tableName
                    + "(userName varchar(30), petType varchar(10),petName varchar(30),  "
                    + "fullness int, energy int, excitment int, dayCount int)";
            statement.executeUpdate(sqlCreate);
            System.out.println("Table is created");

        } catch (SQLException ex) {
            System.out.println("Error : creating table");
        }
    }

    /**
     * The method to insert data into database
     *
     * @param userList
     */
    public void insertTable(UserList userList) {
        userList.getUserList().entrySet().forEach((Map.Entry<String, Pet> list) -> {
            try {
                String sqlInsert = String.format("insert into %s values('%s', '%s', '%s', %d, %d, %d, %d)",
                        tableName,
                        list.getKey(),
                        list.getValue().getClass().getSimpleName().toLowerCase(),
                        list.getValue().getName().toLowerCase(),
                        list.getValue().getFullness(),
                        list.getValue().getEnergy(),
                        list.getValue().getExcitement(),
                        list.getValue().getDayCount());

                statement.executeUpdate(sqlInsert);
            } catch (SQLException ex) {
                System.out.println("Error : inserting table");
            }
        });

    }

    /**
     * The method to get query form database
     *
     * @param userList
     */
    public void getQuery(UserList userList) {
        Pet pet;
        try {
            System.out.println("USER DATABASE : Getting data");

            String sqlQuery = "select * from " + this.tableName;
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String userName = resultSet.getString(1).trim().toLowerCase();
                String petType = resultSet.getString(2).trim().toLowerCase();
                String petName = resultSet.getString(3).trim().toLowerCase();
                int fullness = resultSet.getInt(4);
                int energy = resultSet.getInt(5);
                int excitment = resultSet.getInt(6);
                int dayCount = resultSet.getInt(7);
                switch (petType) {
                    case "dog":
                        pet = new Dog(petName, fullness, energy, excitment, dayCount);
                        userList.addUser(userName, pet);
                    case "cat":
                        pet = new Cat(petName, fullness, energy, excitment, dayCount);
                        userList.addUser(userName, pet);
                }
            }

        } catch (SQLException ex) {
            System.out.println("USER DATABASE : Error : getting query");
        }

    }

    private void delectTable(String tableName) throws SQLException {
        System.out.println("USER DATABASE : "+tableName + " needs to be deleted");
        String sqlDropTable = "USER DATABASE : DROP TABLE " + tableName;
        this.statement.executeUpdate(sqlDropTable);
        System.out.println("USER DATABASE : "+tableName + " table is deleted");

    }

    private boolean checkTableExisting(String tableName) throws SQLException {

        System.out.println("USER DATABASE : Checking existing tables");
        this.resultSet = connection.getMetaData().getTables(null, null, null, null);

        while (this.resultSet.next()) {
            String table = this.resultSet.getString("TABLE_NAME");
            if (table.compareToIgnoreCase(tableName) == 0) {
                System.out.println("USER DATABASE : "+table + " founded");
                return true;
            }
        }

        return false;

    }

    /**
     * The method to close connection
     */
    public void closeConnections() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("USER DATABASE : Error : closing");
            }
        }
    }

}
