import java.util.ArrayList;

public class Alfil extends Pieza{

    public Alfil(int posx, int posy){
        super();
        viva=true;
        icon="♝";
        if (posx==0){
            color=false;
        }
        else
            color=true;

        regresar = true;
        posicionx = posx;
        posiciony = posy;
    }

    @Override
    public void movimiento() {
        boolean chocadxp = false, chocadxn = false, chocadyp = false, chocadyn = false;
        for (int n = 1; !(posicionx + n >= 7 && posicionx - n <= 0 && posiciony + n >= 7 && posiciony - n <= 0) && (!chocadxp || !chocadyp || !chocadxn || !chocadyn); n++) {
            if (!(posicionx + n > 7 || posiciony + n > 7)) {
                if (!chocadxp) {
                    if (Juego.tablero.tab[posicionx + n][posiciony + n] == null) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                    } else if (Juego.tablero.tab[posicionx + n][posiciony + n].color != Juego.tablero.tab[posicionx][posiciony].color) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                        chocadxp = true;
                    } else chocadxp = true;
                }
            } else chocadxp = true;
            if (!(posicionx - n < 0 || posiciony + n > 7)) {
                if (!chocadyp) {
                    if (Juego.tablero.tab[posicionx - n][posiciony + n] == null) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx - n][posiciony + n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                        chocadyp = true;
                    } else chocadyp = true;
                }
            } else chocadyp = true;
            if (!(posicionx - n < 0 || posiciony - n < 0)) {
                if (!chocadxn) {
                    if (Juego.tablero.tab[posicionx - n][posiciony - n] == null) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony - n;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx - n][posiciony - n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony - n;
                        movValidos.add(mov.clone());
                        chocadxn = true;
                    } else chocadxn = true;
                }
            } else chocadxn = true;
            if (!(posicionx + n > 7 || posiciony - n < 0)) {
                if (!chocadyn) {
                    if (Juego.tablero.tab[posicionx + n][posiciony - n] == null) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony - n;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony - n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony - n;
                        movValidos.add(mov.clone());
                        chocadyn = true;
                    } else chocadyn = true;
                }
            } else chocadyn = true;
        }
        posPieza[0] = this.posicionx;
        posPieza[1] = this.posiciony;
        buscarRey(posPieza);
        try {
            if(Juego.jaqueBlanco || Juego.jaqueNegro)
                movValidos = compararListas(movValidos, Juego.piezaJaque.movAmenaza);
            movValidos = compararListas(movValidos, Juego.piezaBloqueada.movAmenaza);
        } catch (Exception e){}
        if(movValidos.size() == 0){
            System.out.println("No existen movimientos válidos para esta pieza, elige otra.");
            this.selected = false;
            valido = false;
        } else {
            System.out.println("Movimientos válidos:");
            for (int[] elemento : movValidos) {
                System.out.println("[" + elemento[0] + "," + elemento[1] + "]");
            }
            valido = true;
        }
    }
    @Override
    public void amenaza(Pieza rey) {
        if (this.posicionx < rey.posicionx) {
            if (this.posiciony < rey.posiciony) {
                for (int n = 0; this.posicionx + n < rey.posicionx && this.posiciony + n < rey.posiciony; n++) {
                    ame[0] = this.posicionx + n;
                    ame[1] = this.posiciony + n;
                    movAmenaza.add(ame.clone());
                }
            } else {
                for (int n = 0; this.posicionx + n < rey.posicionx && this.posiciony - n > rey.posiciony; n++) {
                    ame[0] = this.posicionx + n;
                    ame[1] = this.posiciony - n;
                    movAmenaza.add(ame.clone());
                }
            }
        } else if (this.posiciony < rey.posiciony) {
            for (int n = 0; this.posicionx - n > rey.posicionx && this.posiciony + n < rey.posiciony; n++) {
                ame[0] = this.posicionx - n;
                ame[1] = this.posiciony + n;
                movAmenaza.add(ame.clone());
            }
        } else {
            for (int n = 0; this.posicionx - n > rey.posicionx && this.posiciony - n > rey.posiciony; n++) {
                ame[0] = this.posicionx - n;
                ame[1] = this.posiciony - n;
                movAmenaza.add(ame.clone());
            }
        }
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
