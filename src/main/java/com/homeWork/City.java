package com.homeWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class City {
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
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", square='" + square + '\'' +
                ", wealth='" + wealth + '\'' +
                '}';
    }

    public static void createTableCity() {
        String SQL = "CREATE TABLE sities(" +
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




    public static void addCitis(int id, String name, int population, String square, String wealth) {
        String SQL = "INSERT INTO Cities(id,name,age,population,square,wealth)" +
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




    public static List<City> getCity() {
        String SQL = "SELECT * FROM CITIES";
        List<City> cities = new ArrayList<>();
        try (Connection con = Bd.connection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
               City city = new City();
               city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setPopulation(resultSet.getInt("population"));
                city.setSquare(resultSet.getString("square"));
                city.setWealth(resultSet.getString("wealth"));
                cities.add(city);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }



}

