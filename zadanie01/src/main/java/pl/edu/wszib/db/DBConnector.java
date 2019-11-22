package pl.edu.wszib.db;
import pl.edu.wszib.costume.Costume;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class DBConnector {
        public static Connection connection = null;

        public static void connect() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                DBConnector.connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/kostiumy", "root", "");

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            }
        }

        public static void addCostume(String name, String size, Integer costumeID, Boolean rent) {
            String sql = "INSERT INTO costume (name, size, costumeId, rent) VALUES (?,?,?,?)";
            try {
                PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, size);
                preparedStatement.setInt(3, costumeID);
                preparedStatement.setBoolean(4, rent);
                System.out.println("Dodales nowy kostium");
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static List<Costume> getAllCostumes() {
            List<Costume> userList = new ArrayList<>();
            String sql = "SELECT * FROM costume";

            try {
                PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Costume costume = new Costume();

                    String nameCostumeFromDatabase = resultSet.getString("name");
                    costume.setName(nameCostumeFromDatabase);

                    String sizeCostumeFromDatabase = resultSet.getString("size");
                    costume.setSize(sizeCostumeFromDatabase);

                    int idCostumeFromDatabase = resultSet.getInt("costumeId");
                    costume.setCostumeId(idCostumeFromDatabase);

                    Boolean rentCostumeFromDatabase = resultSet.getBoolean("rent");
                    costume.setRent(rentCostumeFromDatabase);

                    userList.add(costume);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return userList;
        }

        public static void updateCostume(String size, String name) {
            String sql = "UPDATE costume SET size = ?  WHERE name = ? ";
            try {
                PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sql);
                preparedStatement.setString(1,size);
                preparedStatement.setString(2, name);
                System.out.println("zaktualizowana baza");

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void deleteCostume(Integer costumeId) {
            String sql = "DELETE FROM costume  where costumeId = ? ";
            try {
                PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sql);
                preparedStatement.setInt(1,costumeId);
                preparedStatement.executeUpdate();
                System.out.println("Usunieto kostium");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static boolean existCostume(String name) {
            String sql = "SELECT * FROM costume WHERE name = ?";
            try {
                PreparedStatement preparedStatement = DBConnector.connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    System.out.println("Jest");
                }else {
                    System.out.println("Nie ma");
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }

            return true;
        }
    }