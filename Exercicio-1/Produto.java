public class Produto {

    // Atributos privados
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor da classe Produto
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        setPreco(preco); // Usando o método set para garantir a validação
        setQuantidade(quantidade); // Usando o método set para garantir a validação
    }

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        // Garantindo que o preço não seja negativo
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("O preço não pode ser negativo.");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        // Garantindo que a quantidade não seja negativa
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("A quantidade não pode ser negativa.");
        }
    }

    // Método para exibir as informações do produto
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade em estoque: " + quantidade);
    }
}
