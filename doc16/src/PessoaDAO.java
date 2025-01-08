import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private List<Pessoa> pessoas;

    public PessoaDAO() {
        this.pessoas = new ArrayList<>();
    }

    // Método para adicionar uma pessoa
    public void adicionarPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            pessoas.add(pessoa);
            System.out.println("Pessoa adicionada com sucesso: " + pessoa);
        } else {
            System.out.println("Pessoa inválida. Não foi possível adicionar.");
        }
    }

    // Método para buscar uma pessoa por ID
    public Pessoa buscarPessoaPorId(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        System.out.println("Pessoa com ID " + id + " não encontrada.");
        return null;
    }

    // Método para atualizar uma pessoa
    public boolean atualizarPessoa(int id, String novoNome, ArrayList<Telefone> novosTelefones, String novoEmail) {
        Pessoa pessoa = buscarPessoaPorId(id);
        if (pessoa != null) {
            pessoa.setNome(novoNome);
            pessoa.getTelefones().clear();
            pessoa.getTelefones().addAll(novosTelefones);
            pessoa.setEmail(novoEmail);
            System.out.println("Pessoa atualizada com sucesso: " + pessoa);
            return true;
        }
        return false;
    }

    // Método para remover uma pessoa por ID
    public boolean removerPessoa(int id) {
        Pessoa pessoa = buscarPessoaPorId(id);
        if (pessoa != null) {
            pessoas.remove(pessoa);
            System.out.println("Pessoa removida com sucesso: " + pessoa);
            return true;
        }
        System.out.println("Pessoa com ID " + id + " não encontrada.");
        return false;
    }

    // Método para listar todas as pessoas
    public List<Pessoa> listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa encontrada.");
        }
        return pessoas;
    }
}
