// Exceção personalizada para descontos inválidos
class DescontoInvalidoException extends Exception {
    public DescontoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

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

    // Método para aplicar um desconto ao preço
    public void aplicarDesconto(double porcentagem) throws DescontoInvalidoException {
        // Validação do desconto
        if (porcentagem < 0 || porcentagem > 50) {
            throw new DescontoInvalidoException("O desconto deve ser entre 0% e 50%");
        }

        // Calculando o desconto e aplicando ao preço
        double valorDesconto = (preco * porcentagem) / 100;
        preco -= valorDesconto;

        System.out.println("Desconto de " + porcentagem + "% aplicado. Novo preço: R$ " + preco);
    }

    // Método para exibir as informações do produto
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade em estoque: " + quantidade);
    }
}
