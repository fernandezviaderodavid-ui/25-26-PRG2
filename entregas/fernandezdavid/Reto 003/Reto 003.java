
import java.util.Random;
import java.util.Scanner;

public class Buscaminas {

    private static final int FILAS = 5;
    private static final int COLUMNAS = 7;
    private static final int TOTAL_MINAS = 5;

    public static void main(String[] args) {

        char[][] tableroReal = new char[FILAS][COLUMNAS];
        char[][] tableroVisible = new char[FILAS][COLUMNAS];

        inicializarTablero(tableroReal, tableroVisible);
        colocarMinas(tableroReal);

        Scanner scanner = new Scanner(System.in);
        int minasEncontradas = 0;
        int celdasDescubiertas = 0;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {

            mostrarTablero(tableroVisible);

            int fila = pedirNumero(scanner, "Introduzca fila (1-5): ") - 1;
            int columna = pedirNumero(scanner, "Introduzca columna (1-7): ") - 1;

            if (!posicionValida(fila, columna)) {
                System.out.println("Posición fuera de rango.");
                continue;
            }

            if (tableroVisible[fila][columna] != '-') {
                System.out.println("Casilla ya descubierta.");
                continue;
            }

            if (tableroReal[fila][columna] == 'M') {
                tableroVisible[fila][columna] = '*';
                minasEncontradas++;
                System.out.println("¡BOOM! Mina encontrada.");
            } else {
                tableroVisible[fila][columna] = '.';
                celdasDescubiertas++;
            }

            if (minasEncontradas == TOTAL_MINAS) {
                System.out.println("Lo siento, ha perdido.");
                juegoTerminado = true;
            }

            if (celdasDescubiertas == (FILAS * COLUMNAS - TOTAL_MINAS)) {
                System.out.println("¡Enhorabuena, ha ganado!");
                juegoTerminado = true;
            }
        }

        scanner.close();
    }

    private static void inicializarTablero(char[][] real, char[][] visible) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                real[i][j] = ' ';
                visible[i][j] = '-';
            }
        }
    }

    private static void colocarMinas(char[][] tablero) {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < TOTAL_MINAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);

            if (tablero[fila][columna] != 'M') {
                tablero[fila][columna] = 'M';
                minasColocadas++;
            }
        }
    }

    private static void mostrarTablero(char[][] tablero) {
        System.out.println();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int pedirNumero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    private static boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS;
    }
}

