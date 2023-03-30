package com.homeWork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
        String SQL = "CREATE TABLE Boss(" +
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

    public static void addBoss(int id, String name, String lastName, int age, String wealth) {
        String SQL = "INSERT INTO Boss(id,name,age,lastname,age,wealth)" +
                "VALUES(?,?,?,?,?)";
        try (Connection con = Bd.connection();
             PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, lastName);
            statement.setInt(4, age);
            statement.setString(5, wealth);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
