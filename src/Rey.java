public class Rey extends Pieza{
    boolean enJaque;
    boolean moved;

    public Rey(){
        super();
        viva=true;
        moved=false;
        enJaque=false;

        if (Tablero.posx==0) {
            color = false;
            icon = "♚";
        }
        else{
            color=true;
                icon="♚";
            }
        regresar=true;
        posicionx=Tablero.posx;
        posiciony=Tablero.posy;
}

    @Override
    public void movimiento() {
        for (n = -1; n <= 1; n++) {
            for (m = -1; m <= 1; m++) {
                if (posicionx + n < 0 || posicionx + n > 7 || (n == 0 && m == 0))
                    continue;
                try {
                    if (Juego.tablero.tab[posicionx + n][posiciony + m] == null) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony + n].color != Juego.tablero.tab[posicionx][posiciony].color)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        if(movValidos.size() == 0){
            System.out.println("No existen movimientos válidos para esta pieza, elige otra.");
            this.selected = false;
            valido = false;
        }
    }

    public boolean comprobarJaque(int[] posRey) {
        boolean chocaxp = false, chocayp = false, chocaxn = false, chocayn = false, chocadxp = false, chocadxn = false, chocadyp = false, chocadyn = false;
        for (n = 1; !(posRey[0] + n >= 7 && posRey[0] - n < 0 && posRey[1] + n >= 7 && posRey[1] - n < 0) && (!chocaxp || !chocayp || !chocaxn || !chocayn || !chocadyn || !chocadyp || !chocadxn || !chocadxp); n++) {
            if (!(posRey[0] + n > 7)) {
                if (!chocaxp) {
                    if (Juego.tablero.tab[posRey[0] + n][posRey[1]] != null) {
                        if ((Juego.tablero.tab[posRey[0] + n][posRey[1]].color != Juego.tablero.tab[posRey[0]][posRey[1]].color)) {
                            if (Juego.tablero.tab[posRey[0] + n][posRey[1]] instanceof Torre || Juego.tablero.tab[posRey[0] + n][posRey[1]] instanceof Reina) {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] + n][posRey[1]];
                                chocaxp = true;
                            }
                        } else chocaxp = true;
                    }
                }
            } else chocaxp = true;
            if (!(posRey[1] + n > 7)) {
                if (!chocayp) {
                    if (Juego.tablero.tab[posRey[0]][posRey[1] + n] != null) {
                        if ((Juego.tablero.tab[posRey[0]][posRey[1] + n].color != Juego.tablero.tab[posRey[0]][posRey[1]].color)) {
                            if (Juego.tablero.tab[posRey[0]][posRey[1] + n] instanceof Torre || Juego.tablero.tab[posRey[0]][posRey[1] + n] instanceof Reina) {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0]][posRey[1] + n];
                                chocayp = true;
                            }
                        } else chocayp = true;
                    }
                }
            }else chocayp = true;
            if (!(posRey[0] - n < 0)) {
                if (!chocaxn) {
                    if (Juego.tablero.tab[posRey[0] - n][posRey[1]] != null) {
                        if ((Juego.tablero.tab[posRey[0] - n][posRey[1]].color != Juego.tablero.tab[posRey[0]][posRey[1]].color)) {
                            if (Juego.tablero.tab[posRey[0] - n][posRey[1]] instanceof Torre || Juego.tablero.tab[posRey[0] - n][posRey[1]] instanceof Reina) {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] - n][posRey[1]];
                                chocaxn = true;
                            }
                        } else chocaxn = true;
                    }
                }
            }else chocaxn = true;
            if (!(posRey[1] - n < 0)) {
                if (!chocayn) {
                    if (Juego.tablero.tab[posRey[0]][posRey[1] - n] != null) {
                        if ((Juego.tablero.tab[posRey[0]][posRey[1] - n].color != Juego.tablero.tab[posRey[0]][posRey[1]].color)) {
                            if (Juego.tablero.tab[posRey[0]][posRey[1] - n] instanceof Torre || Juego.tablero.tab[posRey[0]][posRey[1] - n] instanceof Reina) {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0]][posRey[1]];
                                chocayn = true;
                            }
                        } else chocayn = true;
                    }
                }
            }else chocayn = true;
            if (!(posRey[0] + n > 7 || posRey[1] + n > 7)) {
                if (!chocadxp) {
                    if (Juego.tablero.tab[posRey[0] + n][posRey[1] + n] != null) {
                        if ((Juego.tablero.tab[posRey[0] + n][posRey[1] + n].color != Juego.tablero.tab[posRey[0]][posRey[1]].color)) {
                            if (Juego.tablero.tab[posRey[0] + n][posRey[1] + n] instanceof Alfil || Juego.tablero.tab[posRey[0] + n][posRey[1] + n] instanceof Reina || (!(Juego.tablero.tab[posRey[0]][posRey[1]].color) && Juego.tablero.tab[posRey[0] + n][posRey[1] + n] instanceof Peon)) {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] + n][posRey[1] + n];
                                chocadxp = true;
                            }
                        } else chocadxp = true;
                    }
                }
            }else chocadxp = true;
            if (!(posRey[0] - n < 0 || posRey[1] + n > 7)) {
                if (!chocadyp) {
                    if (Juego.tablero.tab[posRey[0] - n][posRey[1] + n] != null) {
                        if ((Juego.tablero.tab[posRey[0] - n][posRey[1] + n].color != Juego.tablero.tab[posRey[0]][posRey[1]].color)) {
                            if (Juego.tablero.tab[posRey[0] - n][posRey[1] + n] instanceof Alfil || Juego.tablero.tab[posRey[0] - n][posRey[1] + n] instanceof Reina || ((Juego.tablero.tab[posRey[0]][posRey[1]].color) && Juego.tablero.tab[posRey[0] - n][posRey[1] + n] instanceof Peon)) {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] - n][posRey[1] + n];
                                chocadyp = true;
                            }
                        } else chocadyp = true;
                    }
                }
            }else chocadyp = true;
            if (!(posRey[0] - n < 0 || posRey[1] - n < 0)) {
                if (!chocadxn) {
                    if (Juego.tablero.tab[posRey[0] - n][posRey[1] - n] != null) {
                        if ((Juego.tablero.tab[posRey[0] - n][posRey[1] - n].color != Juego.tablero.tab[posRey[0]][posRey[1]].color)) {
                            if (Juego.tablero.tab[posRey[0] - n][posRey[1] - n] instanceof Alfil || Juego.tablero.tab[posRey[0] - n][posRey[1] - n] instanceof Reina || ((Juego.tablero.tab[posRey[0]][posRey[1]].color) && Juego.tablero.tab[posRey[0] - n][posRey[1] - n] instanceof Peon)) {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] - n][posRey[1] - n];
                                chocadxn = true;
                            }
                        } else chocadxn = true;
                    }
                }
            }else chocadxn = true;
            if (!(posRey[0] + n > 7 || posRey[1] - n < 0)) {
                if (!chocadyn) {
                    if (Juego.tablero.tab[posRey[0] + n][posRey[1] - n] != null) {
                        if ((Juego.tablero.tab[posRey[0] + n][posRey[1] - n].color != Juego.tablero.tab[posRey[0]][posRey[1]].color)) {
                            if (Juego.tablero.tab[posRey[0] + n][posRey[1] - n] instanceof Alfil || Juego.tablero.tab[posRey[0] + n][posRey[1] - n] instanceof Reina || (!(Juego.tablero.tab[posRey[0]][posRey[1]].color) && Juego.tablero.tab[posRey[0] + n][posRey[1] - n] instanceof Peon)) {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] + n][posRey[1] - n];
                                chocadyn = true;
                            }
                        } else chocadyn = true;
                    }
                }
            }else chocadyn = true;
        }
        return ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque;
    }
}

