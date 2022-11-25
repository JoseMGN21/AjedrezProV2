import java.util.ArrayList;

public class Torre extends Pieza {
    boolean moved;

    public Torre(int posx, int posy) {
        super();
        viva = true;
        moved = false;
        icon = "♜";
        if (posx == 0) {
            color = false;
        } else {
            color = true;
        }
        regresar = true;
        posicionx = posx;
        posiciony = posy;
    }

    @Override
    public void movimiento() {
        boolean chocaxp = false, chocayp = false, chocaxn = false, chocayn = false;
        for (n = 1; !( posicionx + n >= 7 &&  posicionx - n < 0 &&  posiciony + n >= 7 &&  posiciony - n < 0) && (!chocaxp || !chocayp || !chocaxn || !chocayn); n++) {
            if (!( posicionx + n > 7)) {
                if (!chocaxp) {
                    if (Juego.tablero.tab[ posicionx + n][posiciony] == null) {
                        mov[0] =  posicionx + n;
                        mov[1] = posiciony;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[ posicionx + n][ posiciony].color != Juego.tablero.tab[  posicionx][ posiciony].color)) {
                        mov[0] =  posicionx + n;
                        mov[1] =  posiciony;
                        movValidos.add(mov.clone());
                        chocaxp = true;
                    } else chocaxp = true;
                }
            }
            if (!(posiciony + n > 7)) {
                if (!chocayp) {
                    if (Juego.tablero.tab[ posicionx][posiciony + n] == null) {
                        mov[0] = posicionx;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx][posiciony + n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                        chocayp = true;
                    } else chocayp = true;
                }
            }
            if (!(posicionx - n < 0)) {
                if (!chocaxn) {
                    if (Juego.tablero.tab[posicionx - n][posiciony] == null) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx - n][posiciony].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony;
                        movValidos.add(mov.clone());
                        chocaxn = true;
                    } else chocaxn = true;
                }
            }
            if (!( posiciony - n < 0)) {
                if (!chocayn) {
                    if (Juego.tablero.tab[posicionx][posiciony - n] == null) {
                        mov[0] = posicionx;
                        mov[1] = posiciony - n;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx][posiciony - n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx;
                        mov[1] = posiciony - n;
                        movValidos.add(mov.clone());
                        chocayn = true;
                    } else chocayn = true;
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
            this.moved = true;
        }
    }
    @Override
    public void amenaza(Pieza rey){
        if(this.posicionx == rey.posicionx) {
            if (this.posiciony < rey.posiciony) {
                for (int n = 0; (this.posiciony - n) > rey.posiciony; n++) {
                    if(Juego.tablero.tab[posicionx][posiciony - n] != null)
                        continue;
                    ame[0] = this.posicionx;
                    ame[1] = this.posiciony - n;
                    movAmenaza.add(ame.clone());
                }
            } else {
                for (int n = 0; (this.posiciony + n) < rey.posiciony; n++) {
                    if(Juego.tablero.tab[posicionx + n][posiciony] != null)
                        continue;
                    ame[0] = this.posicionx;
                    ame[1] = this.posiciony + n;
                    movAmenaza.add(ame.clone());
                }
            }
        }
        else if (this.posiciony == rey.posiciony){
            if (this.posicionx < rey.posicionx) {
                for (int n = 0; (this.posicionx - n) > rey.posicionx; n++) {
                    ame[0] = this.posicionx - n;
                    ame[1] = this.posiciony;
                    movAmenaza.add(ame.clone());
                }
            } else {
                for (int n = 0; (this.posicionx + n) < rey.posicionx; n++) {
                    ame[0] = this.posicionx + n;
                    ame[1] = this.posiciony;
                    movAmenaza.add(ame.clone());
                }
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
