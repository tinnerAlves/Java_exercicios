
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringsEColecoes {

    public static boolean ehPalindromo(String texto) {
        String limpo = texto.toLowerCase().replaceAll("[^a-z]", "");
        for (int i = 0; i < limpo.length() / 2; i++) {
            if (limpo.charAt(i) != limpo.charAt(limpo.length() - 1 - i)) {

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");
       

        String textoA, example;

        System.out.print("Digite um texto : ");
        textoA = scanner.nextLine();

        System.out.println(" é palindromo ? " + textoA + " = " + ehPalindromo(textoA));

        //CONTAGEM DAS PALAVRAS 
        System.out.print("Escreva uma frase : ");
        example = scanner.nextLine();

        Map<String, Integer> contagem = new HashMap<>();

        for (String word : example.split(" ")) {
            contagem.put(word, contagem.getOrDefault(word, 0) + 1);
        }
        contagem.getOrDefault("python", 0);

        System.out.println(contagem);

        scanner.close();
    }

}
