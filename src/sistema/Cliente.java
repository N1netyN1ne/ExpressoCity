package sistema;

public abstract class Cliente {
    //Atributos
    private String nome;
    private String sobrenome;
    private long cpf;
    private String telefone;
    private double saldo;
    private String usuario;
    private String senha;
    
    //Construtores
    public Cliente(){}
    public Cliente(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    public Cliente(String nome, String sobrenome, String telefone){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    public Cliente(String nome, String sobrenome, String telefone, String usuario, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
    }
    public Cliente(String nome, String sobrenome, long cpf, String telefone, String usuario, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    //Getters
    public String getNome(){
        return nome;
    }
    public String getSobrenome(){
        return sobrenome;
    }
    public long getCpf() {
        return cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public double getSaldo(){
        return saldo;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getSenha() {
        return senha;
    }

    //Setters
    public boolean setNome(String nome){
        this.nome = nome;
        return true;
    }
    public boolean setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
        return true;
    }
    public boolean setCpf(int cpf) {
        this.cpf = cpf;
        return true;
    }
    public void setSaldo(double saldo){
        this.saldo += saldo;
    }
    public boolean setTelefone(String telefone) {
        this.telefone = telefone;
        return true;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //Metodos
    @Override
    public String toString() {
        return "---------------------\n"
             + "nome: " + nome + "\n"
                + "sobrenome: " + sobrenome + "\n"
                + "cpf: " + cpf + "\n"
                + "telefone: " + telefone + "\n"
                + "saldo: R$" + saldo;
    }
    public void pagarSaldo(double valor){
        saldo-=valor;
    }
}
