package com.homeWork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Country {
    private int id;
    private String name;
    private int population;
    private String square;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getWealth() {
        return wealth;
    }

    public void setWealth(String wealth) {
        this.wealth = wealth;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", square='" + square + '\'' +
                ", wealth='" + wealth + '\'' +
                '}';
    }

    public static void createTableCountry() {
        String SQL = "CREATE TABLE country(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50) NOT NULL," +
                "population INTEGER," +
                "square VARCHAR(50) NOT NULL ," +
                "wealth VARCHAR(100) NOT NULL );";
        try (Connection conne = Bd.connection();
             Statement statement = conne.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addCountry(int id,String name, int population, String square, String wealth) {
        String SQL = "INSERT INTO Country(id,name,age,population,square,wealth)" +
                "VALUES(?,?,?,?,?)";
        try (Connection con = Bd.connection();
             PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, population);
            statement.setString(4, square);
            statement.setString(5, wealth);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
