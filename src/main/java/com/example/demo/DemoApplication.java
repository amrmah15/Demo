import com.example.demo.controler.Studentcontroler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.*;

@SpringBootApplication
public class demoApplication {
   @Autowired
   private Studentcontroler studentcontroler;

    static void main(String[] args) {




        // بيانات الاتصال بقاعدة البيانات (غيرها حسب بيئتك)
        String jdbcURL = "jdbc:mysql://localhost:3306/books"; // books = schema name
        String username = "root";   // يوزر قاعدة البيانات
        String password = "your_password"; // باسورد قاعدة البيانات

        try {
            // تحميل Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // إنشاء اتصال
            Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("✅ Connected to database!");

            // -------- INSERT --------
            String insertQuery = "INSERT INTO books (id, name, authorname) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, 1);
            insertStmt.setString(2, "Java Programming");
            insertStmt.setString(3, "John Doe");
            insertStmt.executeUpdate();
            System.out.println("📚 Book inserted!");

            // -------- SELECT --------
            String selectQuery = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("authorname");
                System.out.println(id + " - " + name + " by " + author);
            }

            // -------- UPDATE --------
            String updateQuery = "UPDATE books SET name=? WHERE id=?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, "Advanced Java");
            updateStmt.setInt(2, 1);
            updateStmt.executeUpdate();
            System.out.println("✏️ Book updated!");

            // -------- DELETE --------
            String deleteQuery = "DELETE FROM books WHERE id=?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, 1);
            deleteStmt.executeUpdate();
            System.out.println("❌ Book deleted!");

            // غلق الاتصال
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     //   SpringApplication.run(demoApplication .class, args);

	}
    @Bean
    public CommandLineRunner getComamLine() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Studentcontroler studentcontroler;


            }
        };
    }

void main() {
}






