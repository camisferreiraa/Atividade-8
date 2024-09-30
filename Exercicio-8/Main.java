import java.util.ArrayList;
import java.util.List;

// Classe base Funcionario
abstract class Funcionario {
    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();
    public abstract double calcularBonus();

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}

// Classe Gerente
class Gerente extends Funcionario {
    public Gerente(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase; // Salário fixo para Gerente
    }

    @Override
    public double calcularBonus() {
        return salarioBase * 0.20; // 20% do salário base
    }
}

// Classe Desenvolvedor
class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + 1000; // Salário base + bônus fixo
    }

    @Override
    public double calcularBonus() {
        return salarioBase * 0.10; // 10% do salário base
    }
}

// Classe Estagiario
class Estagiario extends Funcionario {
    public Estagiario(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase * 0.80; // Salário reduzido para estagiário
    }

    @Override
    public double calcularBonus() {
        return 0; // Estagiários não recebem bônus
    }
}

// Classe para gerenciar funcionários
class GestorFuncionarios {
    private List<Funcionario> funcionarios;

    public GestorFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void calcularFolhaPagamento() {
        double totalSalarios = 0;
        double totalBonus = 0;

        for (Funcionario funcionario : funcionarios) {
            double salario = funcionario.calcularSalario();
            double bonus = funcionario.calcularBonus();
            totalSalarios += salario;
            totalBonus += bonus;

            System.out.println(funcionario.getNome() + ": Salário = R$ " + salario + ", Bônus = R$ " + bonus);
        }

        System.out.println("Total de Salários: R$ " + totalSalarios);
        System.out.println("Total de Bônus: R$ " + totalBonus);
    }

    public void promoverFuncionario(Funcionario funcionario, String novoTipo) {
        if (funcionario instanceof Estagiario && novoTipo.equals("Desenvolvedor")) {
            funcionario = new Desenvolvedor(funcionario.getNome(), funcionario.getSalarioBase());
            System.out.println(funcionario.getNome() + " foi promovido para Desenvolvedor.");
        } else if (funcionario instanceof Desenvolvedor && novoTipo.equals("Gerente")) {
            funcionario = new Gerente(funcionario.getNome(), funcionario.getSalarioBase());
            System.out.println(funcionario.getNome() + " foi promovido para Gerente.");
        } else {
            System.out.println("Promoção não permitida.");
        }
    }
}

// Classe principal para teste
public class Main {
    public static void main(String[] args) {
        GestorFuncionarios gestor = new GestorFuncionarios();

        Funcionario gerente = new Gerente("Carlos", 5000);
        Funcionario desenvolvedor = new Desenvolvedor("Ana", 4000);
        Funcionario estagiario = new Estagiario("Lucas", 1500);

        gestor.adicionarFuncionario(gerente);
        gestor.adicionarFuncionario(desenvolvedor);
        gestor.adicionarFuncionario(estagiario);

        // Calculando folha de pagamento
        gestor.calcularFolhaPagamento();

        // Promovendo um funcionário
        gestor.promoverFuncionario(estagiario, "Desenvolvedor");
        gestor.adicionarFuncionario(estagiario); // Adicionando novamente após a promoção
        gestor.calcularFolhaPagamento();
    }
}
