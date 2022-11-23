import java.util.ArrayList;

public class Caballo extends Pieza {

    public Caballo(int posx, int posy){
        super();
        viva=true;
        icon="♞";

        if (posx==0)
            color=false;
        else
            color=true;

        regresar=true;
        posicionx=posx;
        posiciony=posy;
    }

    @Override
    public void movimiento() {
        for (int n = 1; n <= 2; n++) {
            for (int m = 2; m >= 1; m--) {
                if (m == n)
                    continue;
                try {
                    if (Juego.tablero.tab[posicionx + n][posiciony + m] == null) {
                        if (posicionx + n <= 7) {
                            mov[0] = posicionx + n;
                            mov[1] = posiciony + m;
                            movValidos.add(mov.clone());
                        }
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony + m].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posicionx - n][posiciony + m] == null) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx - n][posiciony + m].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posicionx + n][posiciony - m] == null) {
                        if (posicionx + n <= 7) {
                            mov[0] = posicionx + n;
                            mov[1] = posiciony - m;
                            movValidos.add(mov.clone());
                        }
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony - m].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony - m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posicionx - n][posiciony - m] == null) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony - m;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx - n][posiciony - m].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony - m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                }
            }
        }
        posPieza[0] = this.posicionx;
        posPieza[1] = this.posiciony;
        buscarRey(posPieza);
        try {
            if(Juego.jaqueBlanco || Juego.jaqueNegro)
                movValidos = compararListas(movValidos, Juego.piezaJaque.movAmenaza);
            movValidos = compararListas(movValidos, Juego.piezaBloqueada.movAmenaza);
        } catch(Exception e){}
        if (movValidos.size() == 0) {
            System.out.println("No hay movimientos válidos para esa pieza.");
            System.out.println("Seleccione otra pieza.");
            valido = false;
            Juego.tablero.tab[posicionx][posiciony].selected = false;
        } else {
            System.out.println("Movimientos válidos:");
            for (int[] elemento : movValidos) {

                System.out.println("[" + elemento[0] + "," + elemento[1] + "]");
            }
            valido = true;
        }
    }
    @Override
    public void amenaza(Pieza rey){
        ame[0] = this.posicionx;
        ame[1] = this.posiciony;
        movAmenaza.add(ame.clone());
    }

    public ArrayList<int[]> compararListas(ArrayList<int[]> movValidos, ArrayList<int[]> movAmenaza) {
        ArrayList<int[]> movimientos = new ArrayList<int[]>();
        for (int[] elemento : movValidos) {
            for (int[] elemento2 : movAmenaza) {
                if (elemento[0] == elemento2[0] && elemento[1] == elemento2[1])
                    movimientos.add(elemento);
            }
        }
        return movimientos;
    }
}
