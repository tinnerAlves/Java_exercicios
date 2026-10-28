
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContasBancaria {

    private int ID;
    private String titular;
    private double saldo;

    public ContasBancaria(int id, String titular, double saldo) {
        this.ID = id;
        this.titular = titular;
        this.saldo = saldo;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;

        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char Escolha;
        double valor;
        char continua = 'S';
        char S;
        int ID;

        List<ContasBancaria> contas = new ArrayList<>();
        contas.add(new ContasBancaria(0, "Fernando Savarton", 100.00));
        contas.add(new ContasBancaria(1, "Joana Martinz", 100.00));
        contas.add(new ContaPoupanca(2, "Joana d'Arc", 200.00));

        System.out.println("Gostaria de Incializar o serviço ? S - sim ou N - não");
        S = sc.next().charAt(0);

        while (S == 'S') {
            System.out.println("Qual seria numero da conta ? ");
            ID = sc.nextInt();

            if (ID < 0 || ID >= contas.size()) {
                System.out.println("Conta Inexistente!");
            } else {
                ContasBancaria conta = contas.get(ID);

                if (continua != 'C') {
                    System.out.println("Qual operação será feita ? D - depositar, S - Sacar, V - verificar saldo, Se for uma conta poupança, para ver o rendimento - T");
                    Escolha = sc.next().charAt(0);
                    switch (Escolha) {
                        case 'D' -> {
                            System.out.print("Valor que irá depositar = ");
                            valor = sc.nextDouble();

                            System.out.println("Confirma a operação ? ");
                            continua = sc.next().charAt(0);
                            if (continua == 'N') {
                                break;
                            } else {

                                if (conta.depositar(valor) == true) {
                                    System.out.println("Deposito feito com sucesso ");
                                } else {
                                    System.out.println("Erro, algo aconteceu!!! Contate o suporte ");
                                }
                            }

                            break;
                        }
                        case 'S' -> {
                            System.out.print("Valor que irá sacar = ");
                            valor = sc.nextDouble();

                            System.out.print("Confirma a operação ? ");
                            continua = sc.next().charAt(0);
                            if (continua == 'N') {
                                break;
                            } else {

                                if (conta.sacar(valor) == true) {
                                    System.out.println("Saque realizado com sucesso.");
                                } else {
                                    System.out.println("Saque recusado: saldo insuficiente ou valor inválido. ");
                                }
                            }

                            break;
                        }
                        case 'V' -> {
                            System.out.println("Saldo : " + conta.getSaldo());
                            break;
                        }
                        case 'T' -> {
                            if (conta instanceof ContaPoupanca poupanca) {
                                System.out.print("Taxa (%) = ");
                                double taxa = sc.nextDouble();
                                if (poupanca.render(taxa)) {
                                    System.out.println("Rendimento aplicado.");
                                } else {
                                    System.out.println("Taxa inválida.");
                                }
                            } else {
                                System.out.println("Essa conta não é poupança.");
                            }

                        }
                    }
                }
            }
            System.out.print("F = Finalizar, S - continuar : ");
            S = sc.next().charAt(0);
        }
        sc.close();

    }

}
