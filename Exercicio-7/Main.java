// Classe abstrata FormaPagamento
abstract class FormaPagamento {
    // Método abstrato para processar pagamento
    public abstract void processarPagamento(double valor);

    // Método abstrato para validar pagamento
    public abstract boolean validarPagamento();
}

// Classe concreta CartaoCredito
class CartaoCredito extends FormaPagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;

    // Construtor
    public CartaoCredito(String numeroCartao, String nomeTitular, String dataValidade) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
    }

    @Override
    public void processarPagamento(double valor) {
        if (validarPagamento()) {
            System.out.println("Pagamento de R$ " + valor + " processado com cartão de crédito.");
        } else {
            System.out.println("Pagamento com cartão de crédito não pode ser processado. Cartão inválido.");
        }
    }

    @Override
    public boolean validarPagamento() {
        // Simulando a validação do cartão
        return numeroCartao.length() == 16; // Exemplo: validar se o número do cartão tem 16 dígitos
    }
}

// Classe concreta Boleto
class Boleto extends FormaPagamento {
    private String codigoBoleto;

    // Construtor
    public Boleto(String codigoBoleto) {
        this.codigoBoleto = codigoBoleto;
    }

    @Override
    public void processarPagamento(double valor) {
        if (validarPagamento()) {
            System.out.println("Pagamento de R$ " + valor + " processado com boleto.");
        } else {
            System.out.println("Pagamento com boleto não pode ser processado. Boleto inválido.");
        }
    }

    @Override
    public boolean validarPagamento() {
        // Simulando a validação do boleto
        return codigoBoleto.length() == 10; // Exemplo: validar se o código do boleto tem 10 dígitos
    }
}

// Classe concreta Pix
class Pix extends FormaPagamento {
    private String chavePix;

    // Construtor
    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento(double valor) {
        if (validarPagamento()) {
            System.out.println("Pagamento de R$ " + valor + " processado com Pix.");
        } else {
            System.out.println("Pagamento com Pix não pode ser processado. Chave inválida.");
        }
    }

    @Override
    public boolean validarPagamento() {
        // Simulando a validação da chave Pix
        return chavePix.contains("@"); // Exemplo: validar se a chave contém '@'
    }
}

// Classe principal para teste
public class Main {
    public static void main(String[] args) {
        // Criando diferentes formas de pagamento
        FormaPagamento cartao = new CartaoCredito("1234567890123456", "João Silva", "12/25");
        FormaPagamento boleto = new Boleto("1234567890");
        FormaPagamento pix = new Pix("joao@exemplo.com");

        // Processando pagamentos
        cartao.processarPagamento(150.00);
        boleto.processarPagamento(75.00);
        pix.processarPagamento(200.00);
    }
}
