import javax.print.attribute.standard.PrinterMoreInfoManufacturer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

interface OperacaoMatematica {
    int calcular(int a, int b);
}

interface ManipuladorString {
    String manipular(String str);
}

public class Main {
    public static void main(String[] args) {
        OperacaoMatematica soma = new OperacaoMatematica() {
            @Override
            public int calcular(int a, int b) {
                return a + b;
            }
        };

        System.out.println("Soma sem funcao lambda " + soma.calcular(5, 3));

        OperacaoMatematica somarFL = (a, b) -> a + b;

        System.out.println("Soma com funcao lambda " + somarFL.calcular(5, 3));

        OperacaoMatematica multiplicacao = (a, b) -> a * b;
        System.out.println("multiplicacao com funcao lambda " + multiplicacao.calcular(5, 3));

        OperacaoMatematica divisao = (a, b) -> a / b;
        System.out.println("divisao com lambda " + divisao.calcular(15, 3));

        OperacaoMatematica subtracao = (a, b) -> a - b;
        System.out.println("subtracao com lambda " + subtracao.calcular(35, 20));

        //Manipulação de String

        ManipuladorString maiuscula = new ManipuladorString() {
            @Override
            public String manipular(String str) {
                return str.toUpperCase(Locale.ROOT);
            }
        };
        System.out.println("manipulacao de string sem lambda " + maiuscula.manipular("feijoada"));

        ManipuladorString maiusculaFL = str -> str.toUpperCase(Locale.ROOT);
        System.out.println("Manipulacao de string com lambda " + maiusculaFL.manipular("cachorro"));

        //usando filter

        List<String> palavras = Arrays.asList("java", "lambda", "javanauta", "spring", "praticando");

        List<String> palavrasFiltradas = new ArrayList<>();
        for (String palavra : palavras) {
            if (palavra.length() > 5) {
                palavrasFiltradas.add(palavra);
            }
        }

        System.out.println("palavras com mais de 5 letras sem funcao lambda : " + palavrasFiltradas);

        List<String> palavrasFiltradasFL = palavras.stream().filter(palavra -> palavra.length() > 5).toList();
        System.out.println("palavras com mais de 5 letras com funcao lambda : " + palavrasFiltradasFL);

        List<String> palavrasFiltradas2 = palavras.stream().filter(palavra -> palavra.length() > 2).toList();
        System.out.println("filtro de palavras com funcao lambda - teste : " + palavrasFiltradas2);

        //Filtros com objetos

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 2),
                new Pessoa("Charlie", 25),
                new Pessoa("Bob", 22)
        );

        List<String> nomes = pessoas.stream().map(pessoa -> pessoa.getNome()).toList();
        List<Integer> idade = pessoas.stream().map(Pessoa::getIdade).toList();

        System.out.println("Lista de nomes: " + nomes + " e lista de idade: " + idade);

    }
}