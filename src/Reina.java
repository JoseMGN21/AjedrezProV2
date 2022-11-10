public class Reina extends Pieza{

    public Reina(){
        super();
        viva=true;
        if(Tablero.posx==0) {

            color = false;
            icon = "♛";
        }
        else {
            color=true;
            icon="♛";
        }
        regresar=true;
        posicionx=Tablero.posx;
        posiciony=Tablero.posy;
    }

    @Override
    public void movimiento() {
        for (n = 1; !(posicionx + n >= 7 && posicionx - n < 0 && posiciony + n >= 7 && posiciony - n < 0) && (!chocaxp || !chocayp || !chocaxn || !chocayn); n++) {
            if (!(posicionx + n > 7)) {
                if (!chocaxp) {
                    if (Juego.tablero.tab[posicionx + n][posiciony] == null) {
                        mov[0] =posicionx + n;
                        mov[1] = posiciony;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony;
                        movValidos.add(mov.clone());
                        chocaxp = true;
                    } else chocaxp = true;
                }
            }
            if (!(posiciony + n > 7)) {
                if (!chocayp) {
                    if (Juego.tablero.tab[posicionx][posiciony + n] == null) {
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
                        mov[1] =posiciony;
                        movValidos.add(mov.clone());
                        chocaxn = true;
                    } else chocaxn = true;
                }
            }
            if (!(posiciony - n < 0)) {
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
            if (!(posicionx + n > 7 || posiciony + n > 7)) {
                if (!chocadxp) {
                    if (Juego.tablero.tab[posicionx + n][posiciony + n] == null) {
                        mov[0] =posicionx + n;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony + n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                        chocadxp = true;
                    } else chocadxp = true;
                }
            }
            if (!(posicionx - n < 0 || posiciony + n > 7)) {
                if (!chocadyp) {
                    if (Juego.tablero.tab[posicionx - n][posiciony + n] == null) {
                        mov[0] = posicionx - n;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx - n][posiciony + n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] =posicionx - n;
                        mov[1] = posiciony + n;
                        movValidos.add(mov.clone());
                        chocadyp = true;
                    } else chocadyp = true;
                }
            }
            if (!(posicionx - n < 0 ||posiciony - n < 0)) {
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
            }
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
            }
        }
        if(movValidos.size() == 0){
            System.out.println("No existen movimientos válidos para esta pieza, elige otra.");
            this.selected = false;
            valido = false;
        }
    }
}
