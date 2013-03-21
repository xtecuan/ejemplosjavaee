/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.poo.basica.modelo;

/**
 *
 * @author xtecuan
 */
public class Carro {

    public static int contadorCarros;
    public static final String PLACA = "XYZ123";
    public static final String FABRI = "Toyota";
    public static final String COLOR = "Gris";
    public static final double VEL_MAX = 210;
    private String numeroPlaca;
    private String color;
    private String fabricante;
    private double velocidadMax;
    private double velocidadActual;
    private int rumbo;

    static {
        contadorCarros = 0;
    }

    public Carro() {

        this.numeroPlaca = PLACA;
        this.fabricante = FABRI;
        this.color = COLOR;
        this.velocidadMax = VEL_MAX; //KPH

        imprimirVelocidadMax();
        incrementarContadorCarro();
    }

    private void imprimirVelocidadMax() {
        System.out.println("La velocidad maxima es: " + this.velocidadMax + " km/h");
    }

    public Carro(String numeroPlaca, String color, String fabricante, double velocidadMax) {
        this.numeroPlaca = numeroPlaca;
        this.color = color;
        this.fabricante = fabricante;
        this.velocidadMax = velocidadMax;
        imprimirVelocidadMax();
        incrementarContadorCarro();
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public int getRumbo() {
        return rumbo;
    }

    public void setRumbo(int rumbo) {
        this.rumbo = rumbo;
    }

    public void acelerar(double velocidadFinal) {

        this.velocidadActual = velocidadFinal;
        //A continuacion vendria aca los calculos para graficar el cambio de velocidad en
        //la pantalla del juego
    }

    public void frenar() {
        this.velocidadActual = 0;
        //blah calculos
    }

    public void girar(int direccion) {

        rumbo = direccion;
        //cogigo para hacer girar el carro
    }

    @Override
    public String toString() {
        return "Carro{" + "numeroPlaca=" + numeroPlaca + ", color=" + color + ", fabricante=" + fabricante + ", velocidadMax=" + velocidadMax + ", velocidadActual=" + velocidadActual + ", rumbo=" + rumbo + '}';
    }

    private static void incrementarContadorCarro() {
        contadorCarros++;
    }
    
    public static int obtenerNumeroDeCarros(){
        return contadorCarros;
    }
}
