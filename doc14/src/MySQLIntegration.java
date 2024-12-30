import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLIntegration {

    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/testdb"; // Substitua "testdb" pelo nome do seu banco de dados
    private static final String USER = "root"; // Substitua "root" pelo seu usuário do MySQL
    private static final String PASSWORD = "password"; // Substitua "password" pela sua senha do MySQL

    public static void main(String[] args) {
        // Teste de conexão
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão bem-sucedida com o banco de dados!");

            // Exemplo de inserção de dados
            insertData(connection, "John Doe", 30);

            // Exemplo de leitura de dados
            readData(connection);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Método para inserir dados
    private static void insertData(Connection connection, String name, int age) {
        String query = "INSERT INTO users (name, age) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Dados inseridos com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados: " + e.getMessage());
        }
    }

    // Método para ler dados
    private static void readData(Connection connection) {
        String query = "SELECT * FROM users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Nome: " + name + ", Idade: " + age);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ler dados: " + e.getMessage());
        }
    }
}
