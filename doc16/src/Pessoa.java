import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

public class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private ArrayList <Telefone> telefones = new ArrayList();
    private String email;

    public Pessoa(int id, String nome, String telefone, String email) {
        setId(id);
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String strTelefones = "";
        
        if (!telefones.isEmpty()) {
            for (Telefone telefone : telefones) {
                strTelefones += telefone.toString() + ", ";
            }
        }

        return "ID: " + id + ", Nome: " + nome + ", Telefones: " +  StringUtils.removeEnd(strTelefones, ", ") + ", Email: " + email;
    }
}
