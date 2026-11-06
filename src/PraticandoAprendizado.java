import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

interface OperandoNumeros {
    int numeros(int a, int b);
}

interface UtilizandoString {
    String utilizar(String util);

}

public class PraticandoAprendizado {
    public static void main(String[] args) {
        OperandoNumeros somar = new OperandoNumeros() {
            @Override
            public int numeros(int a, int b) {
                return a + b;

            }
        };
        System.out.println("Praticando soma sem lambda " + somar.numeros(15, 23));


        OperandoNumeros somarFL = (a, b) -> a + b;
        System.out.println("Praticando soma com lambda " + somarFL.numeros(24, 56));

        OperandoNumeros subtrairFL = (a, b) -> a - b;
        System.out.println("Praticando subtracao com lambda " + subtrairFL.numeros(34, 15));

        OperandoNumeros divisaoFL = (a, b) -> a / b;
        System.out.println("Praticando divisao com lambda " + divisaoFL.numeros(50, 5));

        OperandoNumeros multiplicacaoFL = (a, b) -> a * b;
        System.out.println("Praticando multiplicacao com lambda " + multiplicacaoFL.numeros(25, 4));

        //Praticando com string

        UtilizandoString maiuscula = new UtilizandoString() {
            @Override
            public String utilizar(String util) {
                return util.toUpperCase(Locale.ROOT);
            }
        };
        System.out.println("Praticando com string sem lambda : " + maiuscula.utilizar("frederico"));

        UtilizandoString maiusculaFL = str -> str.toUpperCase(Locale.ROOT);
        System.out.println("Praticando com string com lambda: " + maiusculaFL.utilizar("teclado"));

        UtilizandoString minusculaFL = str -> str.toLowerCase();
        System.out.println("Praticando com string com lambda : " + minusculaFL.utilizar("BICICLETA"));

        //Usando filter

        List<String> nomes = Arrays.asList("Maria", "Roseane", "Joao", "Alberto", "Herculano", "Jorge");
        List<String> nomesFiltrados = new ArrayList<>();
        for (String nome : nomes) {
            if (nome.length() > 3) {
                nomesFiltrados.add(nome);
            }
        }
        System.out.println("Nomes com mais de 3 letras sem funcao lambda : " + nomesFiltrados);

        List<String> nomesFiltradosFL = nomes.stream().filter(nome -> nome.length() > 4).toList();
        System.out.println("nomes com mais de 4 letras com funcao lambda: " + nomesFiltradosFL);


        //Utilizando filtro com objetos

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Gabriela", 15),
                new Pessoa("Roberta", 22),
                new Pessoa("Maicon", 29),
                new Pessoa("Josiel", 24)
        );

        List<String> nomesPessoas = pessoas.stream().map(p -> p.getNome()).toList();
        List<Integer> idadePessoas = pessoas.stream().map(Pessoa::getIdade).toList();

        System.out.println("Lista de nomes: " + nomesPessoas + " e lista de idade: " + idadePessoas);


    }
}
