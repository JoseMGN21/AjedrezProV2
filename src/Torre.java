public class Torre extends Pieza {
    boolean moved;

    public Torre() {
        super();
        viva = true;
        moved = false;
        if (Tablero.posx == 0) {
            color = false;
            icon = "♜";
        } else {
            color = true;
            icon = "♜";
        }
        regresar = true;
        posicionx = Tablero.posx;
        posiciony = Tablero.posy;
    }

    @Override
    public void movimiento() {
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
                    } else chocaxp = true;
                }
            }
            if (!(posicionx + n > 7)) {
                if (!chocayp) {
                    if (Juego.tablero.tab[ posicionx][posiciony + n] == null) {
                        mov[0] = posicionx;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx][posiciony + n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
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
                    } else chocayn = true;
                }
            }
        }
        if(movValidos.size() == 0){
            System.out.println("No existen movimientos válidos para esta pieza, elige otra.");
            this.selected = false;
            valido = false;
        }
    }
}
