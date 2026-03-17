class Fraccion {

    private int numerador;
    private int denominador;

    // Constructor
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    public Fraccion(int numero) {
        this.numerador = numero;
        this.denominador = 1;
    }

    public Fraccion sumar(Fraccion otra) {
        int num = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int den = this.denominador * otra.denominador;
        return new Fraccion(num, den);
    }

    public Fraccion restar(Fraccion otra) {
        int num = this.numerador * otra.denominador - otra.numerador * this.denominador;
        int den = this.denominador * otra.denominador;
        return new Fraccion(num, den);
    }

    public Fraccion multiplicar(Fraccion otra) {
        int num = this.numerador * otra.numerador;
        int den = this.denominador * otra.denominador;
        return new Fraccion(num, den);
    }

    public Fraccion dividir(Fraccion otra) {
        int num = this.numerador * otra.denominador;
        int den = this.denominador * otra.numerador;
        return new Fraccion(num, den);
    }

     
    public Fraccion opuesta() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion inversa() {
        return new Fraccion(this.denominador, this.numerador);
    }

    public double toDecimal() {
        return (double) numerador / denominador;
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    private void simplificar() {
        int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));
        numerador = numerador / mcd;
        denominador = denominador / mcd;

        // Evitar denominador negativo
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    // Algoritmo de Euclides
    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
