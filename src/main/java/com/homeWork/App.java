package com.homeWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
//        Bd.connection().close();
//        City.createTableCity();
//        Country.createTableCountry();
//        Mayor.createTableBoss();
        City.addCitis(1,"New York",23244550,"321000 km","1500000 mlrd $");
        City.addCitis(2,"Paris",244550,"221000 km","50000000 mlrd $");
        City.addCitis(3,"London",2454550,"121000 km","7500000 mlrd $");
//        Country.addCountry(11,"America",450000000,"850000 km","97000000000 mld $");
//        Country.addCountry(12,"France",470000000,"840000 km","93000000000 mld $");
//        Country.addCountry(13,"Anglia",460000000,"830000 km","91000000000 mld $");
//        Mayor.addBoss(21,"Asan","Taiirov",24,"70000000 mlrd $");
//        Mayor.addBoss(22,"Bakyt","Latibov",22,"75000000 mlrd $");
//        Mayor.addBoss(23,"Uson","Kamylov",23,"60000000 mlrd $");


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
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setPopulation(resultSet.getInt("population"));
                country.setSquare(resultSet.getString("square"));
                country.setWealth(resultSet.getString("wealth"));
                Mayor mayor = new Mayor();
                mayor.setId(resultSet.getInt("id"));
                mayor.setName(resultSet.getString("name"));
                mayor.setLastName(resultSet.getString("lastname"));
                mayor.setAge(resultSet.getInt("age"));
                city.setWealth(resultSet.getString("wealth"));

                cities.add(city);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }

    public static List<Country> getCountry() {
        String SQL = "SELECT * FROM COUTREIS";
        List<Country> countries = new ArrayList<>();
        try (Connection con = Bd.connection();
             Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setPopulation(resultSet.getInt("population"));
                country.setSquare(resultSet.getString("square"));
                country.setWealth(resultSet.getString("wealth"));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countries;
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

    public static void foundCityByID(int id) {
        String SQL = "SELECT  FROM STUDENTS WHERE id = ? ";
        try (Connection connection = Bd.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void getById (int id){
        String SQL = "SELECT * FROM CITIES WHERE id = ?";
        try (Connection con = Bd.connection();
             Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()){
                System.out.println(rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getInt("population") + " "
                        + rs.getInt("count_of_region") + " "
                        + rs.getString("country_name"));
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }

    }
    public static void deleteStudentByID(int id) {
        String SQL = "SELECT city_id FROM SITIES WHERE id  ";
        try (Connection connection = Bd.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
         } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


}
