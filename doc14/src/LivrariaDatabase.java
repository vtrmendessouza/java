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

            // Exemplo: Inserir novo autor
            inserirAutor(conexao, "João Silva", "J. Silva", "Brasileiro", Date.valueOf("1980-05-15"), "Biografia curta", "joao.silva@example.com", "Literatura", "Ativo");

            // Exemplo: Consultar dados da tabela Autores
            consultarAutor(conexao);

            // Exemplo: Atualizar dados na tabela Autores
            atualizarAutor(conexao, 1, "Novo Nome do Autor");

            // Exemplo: Deletar autor
            deletarAutor(conexao, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void inserirAutor(Connection conexao, String nomeCompleto, String nomeArtistico, String nacionalidade, Date dataNascimento, String biografia, String emailContato, String areaPrincipal, String status) {
        String insercao = "INSERT INTO Autores (Nome_Completo, Nome_Artistico, Nacionalidade, Data_Nascimento, Biografia, Email_Contato, Area_Principal, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement declaracaoPreparada = conexao.prepareStatement(insercao)) {
            declaracaoPreparada.setString(1, nomeCompleto);
            declaracaoPreparada.setString(2, nomeArtistico);
            declaracaoPreparada.setString(3, nacionalidade);
            declaracaoPreparada.setDate(4, dataNascimento);
            declaracaoPreparada.setString(5, biografia);
            declaracaoPreparada.setString(6, emailContato);
            declaracaoPreparada.setString(7, areaPrincipal);
            declaracaoPreparada.setString(8, status);

            int linhasAfetadas = declaracaoPreparada.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Autor inserido com sucesso.");
            } else {
                System.out.println("Falha ao inserir o autor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void consultarAutor(Connection conexao) {
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

                System.out.printf("Id: %d, Nome Completo: %s, Nome Artístico: %s, Nacionalidade: %s, Data Nascimento: %s, Biografia: %s, Email Contato: %s, Área Principal: %s, Status: %s\n",
                id, nomeCompleto, nomeArtistico, nacionalidade, dataNascimento, biografia, emailContato, areaPrincipal, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarAutor(Connection conexao, int idAutor, String novoNome) {
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

    private static void deletarAutor(Connection conexao, int idAutor) {
        String deletar = "DELETE FROM Autores WHERE Id = ?";

        try (PreparedStatement declaracaoPreparada = conexao.prepareStatement(deletar)) {
            declaracaoPreparada.setInt(1, idAutor);

            int linhasAfetadas = declaracaoPreparada.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Autor deletado com sucesso.");
            } else {
                System.out.println("Nenhum autor encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
