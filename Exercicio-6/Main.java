import java.util.ArrayList;
import java.util.List;

// Classe abstrata Animal
abstract class Animal {
    // Método abstrato
    public abstract void emitirSom();
}

// Subclasse Cachorro
class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("O cachorro faz: Au Au!");
    }
}

// Subclasse Gato
class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("O gato faz: Miau!");
    }
}

// Subclasse Vaca
class Vaca extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("A vaca faz: Moo!");
    }
}

// Classe principal para teste
public class Main {
    public static void main(String[] args) {
        // Criando uma lista de animais
        List<Animal> animais = new ArrayList<>();

        // Adicionando instâncias de cada subclasse
        animais.add(new Cachorro());
        animais.add(new Gato());
        animais.add(new Vaca());

        // Iterando sobre a lista e invocando emitirSom() para cada animal
        for (Animal animal : animais) {
            animal.emitirSom();
        }
    }
}
