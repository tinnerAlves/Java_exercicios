import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Aquecimento {
    private static boolean ehPrimo(int numero) {
    if (numero < 2) {
        return false;
    }

    for (int i = 2; i * i <= numero; i++) {
        if (numero % i == 0) {
            return false;
        }
    }

    return true;
}
    public static void main(String [] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        
        int i;
        int n = 0;
        int resto3 = 0;
        int resto5 = 0;



        System.out.print("Digite o valor de n : ");
        n = scanner.nextInt();
        while(n <= 0){
            System.out.println("Digite novamente o valor, sendo maior que 0 : ");
            n = scanner.nextInt();
        }
        
        for(i = 1; i <= n; i++){

            resto5 = i % 5;
            resto3 = i % 3;

            if ((resto3 == 0)  && (resto5 == 0)){
                System.out.println("FizzBuzz");
            }
            else if(resto3 == 0){
                System.out.println("Fizz");
            }
            else if (resto5 == 0){
                System.out.println("Buzz");
            }
            else{
            System.out.println(i);
            }
        }       

        List<Integer> primos = new ArrayList<>();

        for(i = 1; i <= n; i++){
        if(ehPrimo(i)){
            primos.add(i);
        }
        }

        System.out.println("Quantidade de primos: " + primos.size());
        System.out.println("Primos: " + primos);

     scanner.close();
    
    }
}
