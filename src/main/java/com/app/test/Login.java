import java.sql.*;
import java.util.Scanner; 

public class Login {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String userDB = "root";
        String dbcode = "87Sq4d5@x02s.5sd";
        String message ="";
        try (Connection conn = DriverManager.getConnection(url, userDB, dbcode)) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = scanner.nextLine();
            
            System.out.print("Entrez votre mot de passe : ");
            String password = scanner.nextLine();
            
            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            
            try (PreparedStatement stmt = conn.prepareStatement(query)) { 
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    message= "Connexion réussie !";
                } else {
                    message= "Échec de connexion.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}