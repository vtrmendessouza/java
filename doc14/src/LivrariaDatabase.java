import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class LivrariaDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/Livraria";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conectado ao banco de dados!");

            // Exemplo: Consultar dados da tabela Autores
            consultarAutores(conexao);

            // Exemplo: Atualizar dados na tabela Autores
            atualizarNomeAutor(conexao, 1, "Novo Nome do Autor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void consultarAutores(Connection conexao) {
        String consulta = "SELECT * FROM Autores";

        try (Statement declaracao = conexao.createStatement();
             ResultSet resultados = declaracao.executeQuery(consulta)) {

            while (resultados.next()) {
                int id = resultados.getInt("Id");
                String nomeCompleto = resultados.getString("Nome_Completo");
                String nomeArtistico = resultados.getString("Nome_Artistico");
                String nacionalidade = resultados.getString("Nacionalidade");
                Date dataNascimento = resultados.getDate("Data_Nascimento");
                String biografia = resultados.getString("Biografia");
                String emailContato = resultados.getString("Email_Contato");
                String areaPrincipal = resultados.getString("Area_Principal");
                String status = resultados.getString("Status");

                System.out.printf("Id: %d, Nome Completo: %s, Nome Artístico: %s, Nacionalidade: %s, Data Nascimento: %s, Biografia: %s, Email Contato: %s, Área Principal: %s, Status: %s\\n",
                id, nomeCompleto, nomeArtistico, nacionalidade, dataNascimento, biografia, emailContato, areaPrincipal, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarNomeAutor(Connection conexao, int idAutor, String novoNome) {
        String atualizacao = "UPDATE Autores SET Nome_Completo = ? WHERE Id = ?";

        try (PreparedStatement declaracaoPreparada = conexao.prepareStatement(atualizacao)) {
            declaracaoPreparada.setString(1, novoNome);
            declaracaoPreparada.setInt(2, idAutor);

            int linhasAfetadas = declaracaoPreparada.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Nome do autor atualizado com sucesso.");
            } else {
                System.out.println("Nenhum autor encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
