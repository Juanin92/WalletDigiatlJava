package wallet;

public class Moneda{

    private String simbolo,nombreMoneda;
    /**
     * Constructor de la clase Moneda.
     * 
     * @param simbolo Símbolo de la moneda (ej: USD, EUR, CLP, etc).
     * @param nombreMoneda Nombre completo de la moneda.
     */
    public Moneda(String simbolo, String nombreMoneda) {
        this.simbolo = simbolo;
        this.nombreMoneda = nombreMoneda;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    /**
     * Convierte un monto de una moneda a otra.
     * 
     * @param saldo Monto a convertir.
     * @param simbolo Símbolo de la moneda a la que se desea convertir (ej: USD, EUR).
     * @return Monto convertido a la moneda indicada por el símbolo.
     */
    public double ConversionDivisas(double saldo,String simbolo){
        
        double USD = 952.45; // tasa de cambio del dolar fija
        double EURO = 1014.70; // tasa de cambio del euro fija
        double conversion;

        if (simbolo.equalsIgnoreCase("USD")) {
            conversion = saldo / USD;
        }else if (simbolo.equalsIgnoreCase("EURO")) {
            conversion = saldo / EURO;
        }else{
            System.out.println("El tipo de moneda no esta actualmente disponible");
            conversion = 0.0;
        }
        return conversion;
    }
}
