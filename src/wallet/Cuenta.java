package wallet;

public class Cuenta extends Usuario implements OperacionBancaria {

    private String tipoCuenta, nombreBanco;
    private int numeroCuenta;
    private double saldo;
    private boolean validacionCuenta;
    private Moneda moneda;

    /**
     * Constructor de la clase Cuenta.
     * 
     * @param nombre           Nombre del titular de la cuenta.
     * @param apellido         Apellido del titular de la cuenta.
     * @param email            Correo electrónico del titular de la cuenta.
     * @param rut              RUT del titular de la cuenta.
     * @param pass             Contraseña del titular de la cuenta.
     * @param tipoCuenta       Tipo de la cuenta.
     * @param nombreBanco      Nombre del banco al que pertenece la cuenta.
     * @param numeroCuenta     Número de la cuenta bancaria.
     * @param saldo            Saldo actual de la cuenta.
     * @param validacionCuenta Indica si la cuenta está activa o no.
     * @param moneda           Moneda en la que se encuentra la cuenta.
     */
    public Cuenta(String nombre, String apellido, String email, String rut, int pass, String tipoCuenta,
            String nombreBanco, int numeroCuenta, double saldo, boolean validacionCuenta, Moneda moneda) {
        super(nombre, apellido, email, rut, pass);
        this.tipoCuenta = tipoCuenta;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.validacionCuenta = validacionCuenta;
        this.moneda = moneda;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isValidacionCuenta() {
        return validacionCuenta;
    }

    public void setValidacionCuenta(boolean validacionCuenta) {
        this.validacionCuenta = validacionCuenta;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    /**
     * Representación textual de la información de la cuenta.
     * 
     * @return Información de la cuenta en formato String.
     */
    @Override
    public String toString() {
        return "\nNombre: " + getNombre() + " " + getApellido() +
                "\nBanco: " + nombreBanco +
                "\nCuenta: " + tipoCuenta +
                "\nN° Cuenta: " + numeroCuenta +
                "\nSaldo: $" + saldo;
    }

    /**
     * Consulta el saldo disponible en la cuenta.
     *
     * Este método imprime el saldo actual de la cuenta en la consola.
     */
    @Override
    public void ConsultaSaldo() {
        System.out.println("***Saldo Disponible en la Cuenta***");
        System.out.println("$" + getSaldo() + " CLP");
    }

    /**
     * Este método permite realizar un depósito a la cuenta bancaria.
     *
     * @param montoDepositar El monto que se desea depositar. Debe ser mayor a 0.
     */
    @Override
    public void Depositar(double montoDepositar) {

        if (montoDepositar <= 0) { //verifica si el monto es menor o igual 0 antes de depositar a la cuenta
            System.out.println("El monto debe ser mayor a 0 pesos");
        } else {
            saldo += montoDepositar; // actualiza el saldo de la cuenta aumentando el monto
            System.out.println("$" + montoDepositar + " Han sido abonados a su cuenta");
            System.out.println("Monto total de la cuenta: $" + saldo);
        }
    }

    /**
     * Permite retirar dinero de una cuenta bancaria.
     *
     * @param montoRetirar El monto que se desea retirar de la cuenta. Debe ser un valor numérico mayor a 0.
     */
    @Override
    public void RetiroDinero(double montoRetirar) {

        if (montoRetirar > 0) { //verifica si monto es mayor a 0 
            if (saldo < montoRetirar) { // verifica si hay saldo en la cuenta para retirar dinero
                System.out.println("No tiene suficiente saldo en su cuenta para retirar");
            } else {
                saldo -= montoRetirar; // actualiza el saldo de la cuenta restando el monto retirado
                System.out.println("$" + montoRetirar + " Han sido retirados de su cuenta");
                System.out.println("Monto total de la cuenta: $" + saldo);
            }
        } else {
            System.out.println("El monto debe ser mayor a 0 pesos");
        }
    }

    /**
     * Este método realiza una transferencia de dinero entre dos cuentas.
     *
     * @param montoTransferir El monto a transferir.
     * @param cuenta La cuenta destino a la que se transferirá el dinero.
     */
    @Override
    public void Transferir(double montoTransferir, Cuenta cuentaDestino) {
        double comisionTransferencia = 300; 

        if (montoTransferir > 0) { // verifica que el monto a transferir sea mayor a 0
            if (this.saldo < montoTransferir) { // Se valida que el saldo de la cuenta origen sea suficiente para la transferencia
                System.out.println("No tiene suficiente saldo en su cuenta para transferir");
            } else if (cuentaDestino.validacionCuenta == true) { // Se valida que la cuenta destino esté activa
                if (cuentaDestino.getNombreBanco().equalsIgnoreCase(this.nombreBanco)) { // Se verifica si ambas cuentas pertenecen al mismo banco
                    this.saldo -= montoTransferir; // Actualiza el saldo de la cuenta restando el monto transferido
                    cuentaDestino.setSaldo(cuentaDestino.getSaldo() + montoTransferir); // actualiza el saldo de la cuenta de destino 
                    System.out.println("$" + montoTransferir + " Han sido transferido a " + cuentaDestino.getNombre() + " "
                            + cuentaDestino.getApellido());
                    System.out.println("Monto total de la cuenta: $" + this.saldo);
                } else {
                    this.saldo -= montoTransferir; 
                    this.saldo -= comisionTransferencia; // Actualiza el saldo de la cuenta - menos la comisión
                    cuentaDestino.setSaldo(cuentaDestino.getSaldo() + montoTransferir);
                    System.out.println("$" + montoTransferir + " Han sido transferido a " + cuentaDestino.getNombre() + " "
                            + cuentaDestino.getApellido());
                    System.out.println("Monto total de la cuenta: $" + this.saldo);
                }
            } else {
                System.out.println("La cuenta ha transferir no esta activa en este momento");
            }
        } else {
            System.out.println("El monto debe ser mayor a 0 pesos");
        }
    }
}