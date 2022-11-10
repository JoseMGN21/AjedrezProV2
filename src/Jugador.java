import java.util.Scanner;

public class Jugador {
    static Scanner entrada = new Scanner(System.in);
    //static int coordx;
    //static int coordy;
    static boolean color = true;
    static int[] coords = new int[2];
    static int nuevaPosx, nuevaPosy;
    boolean mover;

    public Jugador(boolean color) {
        if (color)
            mover = true;
        else
            mover = false;

    }

    public int[] seleccionarPieza() {
        String coordenada;
        char letracoord;
        char numerocoord;
        if (Juego.turno % 2 == 0)
            color = false;
        else
            color = true;


        while (true) {
            System.out.println("Introduce la coordenada de la pieza que desee mover");
            coordenada = entrada.nextLine();
            coordenada = coordenada.toUpperCase();


            if (coordenada.length() == 2) {

                letracoord = coordenada.charAt(0);
                numerocoord = coordenada.charAt(1);


                if (!(letracoord <= 'H' && letracoord >= 'A') && !(numerocoord <= '8' && numerocoord >= '1'))
                    System.out.println("Coordenada Invalida");


            } else {
                System.out.println("Coordenada Invalida");
            }

            try {
                ChessPosition cp = ChessPosition.valueOf(coordenada);
                if (Juego.tablero.tab[cp.coordy][cp.coordx].color == color) {
                    System.out.println("Pieza válido");
                    Juego.tablero.tab[cp.coordy][cp.coordx].selected = true;
                    coords[0] = cp.coordy;
                    coords[1] = cp.coordx;
                    Pieza.valido = true;
                    Juego.tablero.tab[cp.coordy][cp.coordx].movimiento();
                    return coords;

                } else {
                    System.out.println("Selecciona una ficha de tu color.");

                }
            } catch (Exception e) {
                System.out.println("La casilla seleccionada está vacía, intente de nuevo.");
            }
        }
    }


    public enum ChessPosition {

        A1(0, 0),
        A2(0, 1),
        A3(0, 2),
        A4(0, 3),
        A5(0, 4),
        A6(0, 5),
        A7(0, 6),
        A8(0, 7),

        B1(1, 0),
        B2(1, 1),
        B3(1, 2),
        B4(1, 3),
        B5(1, 4),
        B6(1, 5),
        B7(1, 6),
        B8(1, 7),

        C1(2, 0),
        C2(2, 1),
        C3(2, 2),
        C4(2, 3),
        C5(2, 4),
        C6(2, 5),
        C7(2, 6),
        C8(2, 7),

        D1(3, 0),
        D2(3, 1),
        D3(3, 2),
        D4(3, 3),
        D5(3, 4),
        D6(3, 5),
        D7(3, 6),
        D8(3, 7),

        E1(4, 0),
        E2(4, 1),
        E3(4, 2),
        E4(4, 3),
        E5(4, 4),
        E6(4, 5),
        E7(4, 6),
        E8(4, 7),

        F1(5, 0),
        F2(5, 1),
        F3(5, 2),
        F4(5, 3),
        F5(5, 4),
        F6(5, 5),
        F7(5, 6),
        F8(5, 7),

        G1(6, 0),
        G2(6, 1),
        G3(6, 2),
        G4(6, 3),
        G5(6, 4),
        G6(6, 5),
        G7(6, 6),
        G8(6, 7),

        H1(7, 0),
        H2(7, 1),
        H3(7, 2),
        H4(7, 3),
        H5(7, 4),
        H6(7, 5),
        H7(7, 6),
        H8(7, 7);

        //   private final int row;
        //   private final int column;


        private final int coordx;
        private final int coordy;

        ChessPosition(int coordx, int coordy) {
            this.coordx = coordx;
            this.coordy = coordy;

        }

        public int CoordX() {
            return coordx;
        }

        public int CoordY() {
            return coordy;
        }

        public String toString() {
            return name() + " fila=" + CoordX() + ", columna=" + CoordY();
        }
    }

    public void moverPieza(Pieza pieza) {
        Pieza.valido = false;
        while (true) {
            System.out.println("Escriba la coordenada a donde quiera mover la pieza ");
            String coordenada = entrada.nextLine();
            coordenada = coordenada.toUpperCase();

            if (coordenada.length() == 2) {
                char letracoord = coordenada.charAt(0);
                char numerocoord = coordenada.charAt(1);

                if (!(letracoord <= 'H' && letracoord >= 'A') && !(numerocoord <= '8' && numerocoord >= '1'))
                    System.out.println("Coordenada Invalida");


            } else {
                System.out.println("Coordenada Invalida");
            }

            try {
                ChessPosition cp = ChessPosition.valueOf(coordenada);
                nuevaPosx = cp.coordx;
                nuevaPosy = cp.coordy;
                for (int[] elemento : pieza.movValidos) {
                    if (elemento[0] == nuevaPosy && elemento[1] == nuevaPosx) {
                        mover = true;
                        Juego.tablero.tab[pieza.posicionx][pieza.posiciony] = null;
                        Juego.tablero.tab[nuevaPosy][nuevaPosx] = pieza;
                        pieza.posicionx = cp.coordx;
                        pieza.posiciony = cp.coordy;
                        pieza.selected = false;
                        Pieza.valido = true;
                        break;
                    }

                }
            } catch (Exception e) {
                System.out.println("Casilla no existe.");
            }break;

        }
    }
}









        /* while (true){
            while (true){
                System.out.println("Escriba la coordenada a de la pieza que quiere mover");
                try{
                    coordx=entrada.nextByte();
                    if (coordx>7)
                        System.out.println("Coordenada Invalida, intente de nuevo");
                    else
                        break;
                }catch (Exception e){
                    System.out.println("Valor incorrecto, Intente de nuevo");
                    entrada = new Scanner(System.in);
                }
            }
            while (true){
                try{
                    System.out.println("Escrib");
                }
           }

    }
    */

