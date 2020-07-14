package ed.dci;

public enum RangoCarta {
    ACE(1),
    N2(2),
    N3(3),
    N4(4),
    N5(5),
    N6(6),
    N7(7),
    N8(8),
    N9(9),
    N10(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int valor;

    RangoCarta(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
