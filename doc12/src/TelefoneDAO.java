import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {

    private List<Telefone> telefones;

    public TelefoneDAO() {
        this.telefones = new ArrayList<>();
    }

    // Método para adicionar um telefone
    public void adicionarTelefone(Telefone telefone) {
        if (telefone != null) {
            telefones.add(telefone);
            System.out.println("Telefone adicionado com sucesso: " + telefone);
        } else {
            System.out.println("Telefone inválido. Não foi possível adicionar.");
        }
    }

    // Método para buscar um telefone por ID
    public Telefone buscarTelefonePorId(int id) {
        for (Telefone telefone : telefones) {
            if (telefone.getId() == id) {
                return telefone;
            }
        }
        System.out.println("Telefone com ID " + id + " não encontrado.");
        return null;
    }

    // Método para atualizar um telefone
    public boolean atualizarTelefone(int id, String novoDdd, String novoNumero) {
        Telefone telefone = buscarTelefonePorId(id);
        if (telefone != null) {
            telefone.ddd = novoDdd;
            telefone.telefone = novoNumero;
            System.out.println("Telefone atualizado com sucesso: " + telefone);
            return true;
        }
        return false;
    }

    // Método para remover um telefone por ID
    public boolean removerTelefone(int id) {
        Telefone telefone = buscarTelefonePorId(id);
        if (telefone != null) {
            telefones.remove(telefone);
            System.out.println("Telefone removido com sucesso: " + telefone);
            return true;
        }
        System.out.println("Telefone com ID " + id + " não encontrado.");
        return false;
    }

    // Método para listar todos os telefones
    public List<Telefone> listarTelefones() {
        if (telefones.isEmpty()) {
            System.out.println("Nenhum telefone encontrado.");
        }
        return telefones;
    }
}
