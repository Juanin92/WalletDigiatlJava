package wallet;

import java.util.Scanner;

public class WalletApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean condicion = true;

        // Por el momento solo se utiliza peso chilenos en las cuentas
        Moneda peso = new Moneda("CLP", "PesoChileno"); 
        
        // Creación de cuentas con diferentes datos
        Cuenta juan = new Cuenta("Juan", "Claveria", "jc@gmail.com", "18212716-7", 123456, "Corriente", "BancoChile",
                2354545, 500000, true, peso);
        Cuenta domi = new Cuenta("Dominique", "Cordero", "dc@gmail.com", "201212817-5", 4567678, "Vista", "BancoEstado",
                23434545, 10000000, true, peso);
        Cuenta dante = new Cuenta("Dante", "Inferno", "di@gmail.com", "112366453-4", 98776544, "Ahorro", "BancoChile",
                2342343, 30000000, true, peso);
        Cuenta yuri = new Cuenta("Yuri", "Labrador", "yl@gmail.com", "4353453-4", 344667, "Ahorro", "Santander",
                345465655, 10000, false, peso);

        while (condicion) {
            System.out.println("\n**** MENU ****");
            System.out.println("1.Información Cuenta");
            System.out.println("2.Transferencia");
            System.out.println("3.Deposito");
            System.out.println("4.Retiro Dinero");
            System.out.println("5.Consulta Saldo");
            System.out.println("6.Conversor a moneda extranjera");
            System.out.print("7.Salir\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(juan.toString());
                    break;
                case 2:
                    juan.Transferir(100000, dante);
                    juan.Transferir(100000, yuri);
                    juan.Transferir(100000, domi);
                    break;
                case 3:
                    juan.Depositar(1000);
                    break;
                case 4:
                    juan.RetiroDinero(10000);
                    break;
                case 5:
                    juan.ConsultaSaldo();
                    break;
                case 6:
                    System.out.println("Consultar a que divisa: ");
                    System.out.println("1. USD");
                    System.out.println("2. EURO");
                    opcion = scanner.nextInt();

                    if (opcion == 1) {
                        System.out.println("USD$"+peso.ConversionDivisas(juan.getSaldo(), "USD"));
                    } else if (opcion == 2) {
                        System.out.println("$"+peso.ConversionDivisas(juan.getSaldo(), "EURO")+" Euro");
                    } else {
                        System.out.println("Opción invalida!");
                    }
                    break;
                case 7:
                    condicion = false;
                default:
                    System.out.println("Opción invalida!");
                    break;
            }
        }
        scanner.close();
    }
}