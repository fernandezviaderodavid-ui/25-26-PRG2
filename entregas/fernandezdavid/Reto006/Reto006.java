import java.util.*;

public class Blackjack {
    static Scanner sc = new Scanner(System.in);
    static List<Integer> mazo = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11);

    public static void main(String[] args) {
        jugar();
    }

    static void jugar() {
        List<Integer> mano = new ArrayList<>(Arrays.asList(sacar(), sacar()));
        turno(mano);
    }

    static void turno(List<Integer> mano) {
        int puntos = 0, ases = 0;
        for (int c : mano) {
            puntos += c;
            if (c == 11) ases++;
        }
        while (puntos > 21 && ases-- > 0) puntos -= 10;

        String estado = (puntos == 21) ? "Ganó" : (puntos > 21) ? "Perdió" : "Sigue jugando";
        System.out.printf("\nMano: %s - Puntaje: %d ==> %s\n", mano, puntos, estado);
        System.out.print("1. Pedir | 2. Nuevo | 3. Salir\n> ");
        
        String op = sc.next();
        if (op.equals("1") && puntos < 21) {
            mano.add(sacar());
            turno(mano);
        } else if (op.equals("2")) {
            jugar();
        }
    }

    static int sacar() {
        return mazo.get(new Random().nextInt(mazo.size()));
    }
}
