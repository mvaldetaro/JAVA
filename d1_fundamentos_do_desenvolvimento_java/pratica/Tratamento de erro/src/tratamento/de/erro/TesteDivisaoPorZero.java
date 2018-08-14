package tratamento.de.erro;

public class TesteDivisaoPorZero {
    public static void main(String[] args) {
        int numerador = 5;
        int denominador = 0;
        try {
            int resultado = quociente(numerador, denominador);
            System.out.println("O resultado de divisão é: " + resultado);
        } catch (ArithmeticException ae){
            System.err.println("Você tentou realizar uma divisão com o denominador zero.");
        } finally { //opcional
            System.out.println("Esta instrução será executada!");
        }
    }
    public static int quociente(int numerador, int denominador) throws ArithmeticException {
        return numerador/denominador;
    }
    
}
