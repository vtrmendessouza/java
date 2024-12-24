public class Telefone {
    public static int contador;
    int id;
    private String ddd;
    private String telefone;

    public int getId() {
        return id;
    }

    public String getDdd() {
        return ddd;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public Telefone(String ddd, String telefone) {
        contador++;
        id = contador;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "ID: " + id + " (" + ddd + ") " + telefone;
    }
}