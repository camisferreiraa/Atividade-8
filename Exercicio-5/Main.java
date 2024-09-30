// Interface IMeioTransporte
interface IMeioTransporte {
    void acelerar();
    void frear();
}

// Classe Carro
class Carro implements IMeioTransporte {
    @Override
    public void acelerar() {
        System.out.println("O carro está acelerando.");
    }

    @Override
    public void frear() {
        System.out.println("O carro está freiando.");
    }
}

// Classe Bicicleta
class Bicicleta implements IMeioTransporte {
    @Override
    public void acelerar() {
        System.out.println("A bicicleta está acelerando.");
    }

    @Override
    public void frear() {
        System.out.println("A bicicleta está freiando.");
    }
}

// Classe Trem
class Trem implements IMeioTransporte {
    @Override
    public void acelerar() {
        System.out.println("O trem está acelerando.");
    }

    @Override
    public void frear() {
        System.out.println("O trem está freiando.");
    }
}

// Classe principal para teste
public class Main {
    public static void main(String[] args) {
        // Criando um array de IMeioTransporte
        IMeioTransporte[] meiosTransporte = new IMeioTransporte[3];
        
        // Instanciando os meios de transporte
        meiosTransporte[0] = new Carro();
        meiosTransporte[1] = new Bicicleta();
        meiosTransporte[2] = new Trem();

        // Percorrendo o array e chamando acelerar() e frear() para cada objeto
        for (IMeioTransporte transporte : meiosTransporte) {
            transporte.acelerar();
            transporte.frear();
            System.out.println(); // Linha em branco para melhor formatação
        }
    }
}
