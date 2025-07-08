import java.sql.*;
import java.util.Scanner;

public class Logind{

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";  
        String userDB = "root";
        String passDB = "784dss";

        try (Connection conn = DriverManager.getConnection(url, userDB, pass);
             Statement stmt = conn.createStatement()) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = scanner.nextLine();
            System.out.print("Entrez votre mot de passe : ");
            String password = scanner.nextLine();

           
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
 
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Connexion réussie !");
            } else {
                System.out.println("Échec de connexion.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}