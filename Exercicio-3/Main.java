// Classe base
abstract class Funcionario {
    // Atributos protegidos
    protected String nome;
    protected double salario;

    // Construtor da classe Funcionario
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Método abstrato para calcular bônus
    public abstract double calcularBonus();

    // Método para exibir informações do funcionário
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: R$ " + salario);
        System.out.println("Bônus: R$ " + calcularBonus());
    }
}

// Subclasse Gerente
class Gerente extends Funcionario {
    // Construtor da classe Gerente
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    // Implementação do método calcularBonus
    @Override
    public double calcularBonus() {
        return salario * 0.20; // 20% do salário
    }
}

// Subclasse Desenvolvedor
class Desenvolvedor extends Funcionario {
    // Construtor da classe Desenvolvedor
    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    // Implementação do método calcularBonus
    @Override
    public double calcularBonus() {
        return salario * 0.10; // 10% do salário
    }
}

// Classe principal para teste
public class Main {
    public static void main(String[] args) {
        Funcionario gerente = new Gerente("Alice", 5000);
        Funcionario desenvolvedor = new Desenvolvedor("Bob", 4000);

        System.out.println("Informações do Gerente:");
        gerente.exibirInfo();

        System.out.println("\nInformações do Desenvolvedor:");
        desenvolvedor.exibirInfo();
    }
}
