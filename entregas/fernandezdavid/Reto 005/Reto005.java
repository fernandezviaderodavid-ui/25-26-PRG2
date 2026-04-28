class Carrera {
    private int pos1 = 0;
    private int pos2 = 0;
    private int turno = 1;

    public void jugar() {

        
        while (pos1 < 40 && pos2 < 40) {

            int avance = (int)(Math.random() * 3); // 0,1,2

            if (turno == 1) {
                pos1 += avance;
                turno = 2;
            } else {
                pos2 += avance;
                turno = 1;
            }

            mostrar();
        }

        // Resultado
        if (pos1 >= 40 && pos2 >= 40) {
            System.out.println("Empate");
        } else if (pos1 >= 40) {
            System.out.println("Ganó el caballo 1");
        } else {
            System.out.println("Ganó el caballo 2");
        }
    }

    private void mostrar() {
        System.out.println("----------------------------------------------");

        for (int i = 0; i < 40; i++) {
            if (i == pos1) System.out.print("1");
            else System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < 40; i++) {
            if (i == pos2) System.out.print("2");
            else System.out.print("-");
        }
        System.out.println();

        System.out.println("----------------------------------------------");
    }
}
