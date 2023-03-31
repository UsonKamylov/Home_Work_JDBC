package com.homeWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mayor {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String wealth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWealth() {
        return wealth;
    }

    public void setWealth(String wealth) {
        this.wealth = wealth;
    }

    @Override
    public String toString() {
        return "Mayor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", wealth='" + wealth + '\'' +
                '}';
    }
    public static void createTableBoss() {
        String SQL = "CREATE TABLE boss(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "last_Name VARCHAR(50) NOT NULL ," +
                "age INTEGER," +
                "wealth VARCHAR(100) NOT NULL );";
        try (Connection conne = Bd.connection();
             Statement statement = conne.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addBoss( String name, String lastName, int age, String wealth) {
        String SQL = "INSERT INTO boss(name,last_name,age,wealth)" +
                "VALUES(?,?,?,?)";
        try (Connection con = Bd.connection();
             PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setString(4, wealth);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static List<Mayor> getMayor() {
        String SQL = "SELECT * FROM MAYOR";
        List<Mayor> mayors = new ArrayList<>();
        try (Connection con = Bd.connection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Mayor mayor = new Mayor();
                mayor.setId(resultSet.getInt("id"));
                mayor.setName(resultSet.getString("name"));
                mayor.setLastName(resultSet.getString("lastname"));
                mayor.setAge(resultSet.getInt("age"));
                mayor.setWealth(resultSet.getString("wealth"));
                mayors.add(mayor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mayors;
    }





}
