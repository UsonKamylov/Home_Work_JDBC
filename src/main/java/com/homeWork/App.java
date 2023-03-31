package com.homeWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException {
//        Bd.connection().close();
//        createTableCity();
//        Country.createTableCountry();
//        Mayor.createTableBoss();
//        addCitis("New York", 23244550, "321000 km", "1500000 mlrd $");
//        addCitis("Paris", 244550, "221000 km", "50000000 mlrd $");
//        addCitis( "London", 2454550, "121000 km", "7500000 mlrd $");
//        addCountry("America",450000000,"850000 km","97000000000 mld $");
//        addCountry("France",470000000,"840000 km","93000000000 mld $");
//        addCountry("Anglia",460000000,"830000 km","91000000000 mld $");
//        addBoss("Asan","Taiirov",24,"70000000 mlrd $");
//        addBoss("Bakyt","Latibov",22,"75000000 mlrd $");
//        addBoss("Uson","Kamylov",23,"60000000 mlrd $");
        getById(1);


    }


    public static void getById(int id) {
        String SQL = "SELECT * FROM cities WHERE id = ?";
        try (Connection con = Bd.connection();
             PreparedStatement statement = con.prepareStatement(SQL)) {
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
        rs.next();
                System.out.println(rs.getInt("id") + " "
                        + rs.getString("name") + " "
                        + rs.getInt("population") + " "
                        + rs.getString("square")+" "
                        + rs.getString("wealth"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
