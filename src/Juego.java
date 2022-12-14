public class Juego {
    public static int turno =1;
    public static Tablero tablero;
    public static Pieza piezaJaque, piezaBloqueada;
    public static int[] posReyB = {7,4};
    public static int[] posReyN = {0,4};
    public static boolean jaqueBlanco, jaqueNegro, jaqueMate;
    public static void main(String[] args) {
        tablero = new Tablero();//Tablero
        Jugador Jugador1 = new Jugador(true);
        Jugador Jugador2 = new Jugador(false);
        tablero.imprimirTablero();
        jaqueMate = false;
    while (!jaqueMate){
        if (Jugador1.mover)
            System.out.println("Turno de las Blancas");
        if (Jugador2.mover)
            System.out.println("Turno de las negras");
         Pieza.valido = false;
        while (!Pieza.valido) {
            if (Jugador1.mover) {
                if(((Rey) tablero.tab[posReyB[0]][posReyB[1]]).enJaque){
                    piezaJaque.movAmenaza.clear();
                    piezaJaque.amenaza(tablero.tab[posReyB[0]][posReyB[1]]);
                }
                Jugador1.seleccionarPieza();
                tablero.imprimirTablero();
            }
            if (Jugador2.mover){
                if(((Rey) tablero.tab[posReyB[0]][posReyB[1]]).enJaque){
                    piezaJaque.movAmenaza.clear();
                    piezaJaque.amenaza(tablero.tab[posReyN[0]][posReyN[1]]);
                }
                Jugador2.seleccionarPieza();
                tablero.imprimirTablero();
            }
            }
        if (Jugador1.mover)
            Jugador1.moverPieza(tablero.tab[Jugador.coords[0]][Jugador.coords[1]]);
        if (Jugador2.mover)
            Jugador2.moverPieza(tablero.tab[Jugador.coords[0]][Jugador.coords[1]]);
        tablero.imprimirTablero();
        if(((Rey) tablero.tab[posReyB[0]][posReyB[1]]).comprobarJaque(posReyB)){
            System.out.println("Jaque al rey blanco");
            piezaJaque.amenaza(tablero.tab[posReyB[0]][posReyB[1]]);
            if(!piezaJaque.comprobarBloqueoComer() && !((Rey) tablero.tab[posReyB[0]][posReyB[1]]).comprobarMovimientoRey(tablero.tab[Juego.posReyB[0]][Juego.posReyB[1]])) {
                System.out.println("Jaque Mate");
                System.exit(0);
            }
            jaqueBlanco = true;
            ((Rey) tablero.tab[posReyB[0]][posReyB[1]]).enJaque = true;
        } else {
            jaqueBlanco = false;
            ((Rey) tablero.tab[posReyB[0]][posReyB[1]]).enJaque = false;
        }
        if(((Rey) tablero.tab[posReyN[0]][posReyN[1]]).comprobarJaque(posReyN)){
            System.out.println("Jaque al rey negro");
            piezaJaque.amenaza(tablero.tab[posReyN[0]][posReyN[1]]);
            if(!piezaJaque.comprobarBloqueoComer() && !((Rey) tablero.tab[posReyN[0]][posReyN[1]]).comprobarMovimientoRey(tablero.tab[Juego.posReyN[0]][Juego.posReyN[1]])) {
                System.out.println("Jaque Mate");
                System.exit(0);
            }
            jaqueNegro = true;
            ((Rey) tablero.tab[posReyN[0]][posReyN[1]]).enJaque = true;
        } else {
            jaqueNegro = false;
            ((Rey) tablero.tab[posReyN[0]][posReyN[1]]).enJaque = false;
        }

        if(Pieza.valido) {
            Jugador1.mover ^= true;
            Jugador2.mover ^= true;
            turno += 1;
        }
    }
    System.out.println("Jaque mate. Fin del juego.");
    System.exit(0);
    }
}

