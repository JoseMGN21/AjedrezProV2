import java.util.ArrayList;

public class Rey extends Pieza{
    boolean enJaque;
    boolean moved;

    public Rey(int posx, int posy){
        super();
        viva=true;
        moved=false;
        enJaque=false;
        icon="♚";
        if (posx == 0) {
            color = false;
        }
        else{
            color=true;
            }
        regresar=true;
        posicionx=posx;
        posiciony=posy;
}

    @Override
    public void movimiento() {
        for (int n = -1; n <= 1; n++) {
            for (int m = -1; m <= 1; m++) {
                if (posicionx + n < 0 || posicionx + n > 7 || (n == 0 && m == 0))
                    continue;
                try {
                    int[] posReyn = {posicionx + n,posiciony + m};
                    if (Juego.tablero.tab[posicionx + n][posiciony + m] == null && !comprobarJaque(posReyn)) {
                        mov[0] = posicionx + n;
                        mov[1] = posiciony + m;
                        movValidos.add(mov.clone());
                    } else if ((Juego.tablero.tab[posicionx + n][posiciony + m].color != Juego.tablero.tab[posicionx][posiciony].color) && !comprobarJaque(posReyn)) {
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
        } else {
            System.out.println("Movimientos válidos:");
            for (int[] elemento : movValidos) {
                System.out.println("[" + elemento[0] + "," + elemento[1] + "]");
            }
            valido = true;
        }
    }

    public boolean comprobarJaque(int[] posRey) {
        boolean chocaxp = false, chocayp = false, chocaxn = false, chocayn = false, chocadxp = false, chocadxn = false, chocadyp = false, chocadyn = false;
        this.enJaque = false;

        for (int n = 1; !(posRey[0] + n >= 7 && posRey[0] - n < 0 && posRey[1] + n >= 7 && posRey[1] - n < 0) && (!chocaxp || !chocayp || !chocaxn || !chocayn || !chocadyn || !chocadyp || !chocadxn || !chocadxp); n++) {
            if (!(posRey[0] + n > 7)) {
                if (!chocaxp) {
                    if (Juego.tablero.tab[posRey[0] + n][posRey[1]] != null) {
                        if ((Juego.tablero.tab[posRey[0] + n][posRey[1]].color != this.color)) {
                            if (Juego.tablero.tab[posRey[0] + n][posRey[1]] instanceof Torre || Juego.tablero.tab[posRey[0] + n][posRey[1]] instanceof Reina || ((this.color != Juego.tablero.tab[posRey[0] + n][posRey[1]].color) && Juego.tablero.tab[posRey[0] + n][posRey[1]] instanceof Rey && n == 1)) {
                                try {
                                    ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                    Juego.piezaJaque = Juego.tablero.tab[posRey[0] + n][posRey[1]];
                                } catch(Exception e){return true;}
                                chocaxp = true;
                            } else chocaxp = true;
                        } else chocaxp = true;
                    }
                }
            } else chocaxp = true;
            if (!(posRey[1] + n > 7)) {
                if (!chocayp) {
                    if (Juego.tablero.tab[posRey[0]][posRey[1] + n] != null) {
                        if ((Juego.tablero.tab[posRey[0]][posRey[1] + n].color != this.color)) {
                            if (Juego.tablero.tab[posRey[0]][posRey[1] + n] instanceof Torre || Juego.tablero.tab[posRey[0]][posRey[1] + n] instanceof Reina || ((this.color != Juego.tablero.tab[posRey[0]][posRey[1] + n].color) && Juego.tablero.tab[posRey[0]][posRey[1] + n] instanceof Rey && n == 1)) {
                                try {
                                    ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                    Juego.piezaJaque = Juego.tablero.tab[posRey[0]][posRey[1] + n];
                                } catch(Exception e) {return true;}
                                chocayp = true;
                            } else chocayp = true;
                        } else chocayp = true;
                    }
                }
            }else chocayp = true;
            if (!(posRey[0] - n < 0)) {
                if (!chocaxn) {
                    if (Juego.tablero.tab[posRey[0] - n][posRey[1]] != null) {
                        if ((Juego.tablero.tab[posRey[0] - n][posRey[1]].color != this.color)) {
                            if (Juego.tablero.tab[posRey[0] - n][posRey[1]] instanceof Torre || Juego.tablero.tab[posRey[0] - n][posRey[1]] instanceof Reina || ((this.color != Juego.tablero.tab[posRey[0] - n][posRey[1]].color) && Juego.tablero.tab[posRey[0] - n][posRey[1]] instanceof Rey && n == 1)) {
                                try {
                                    ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                    Juego.piezaJaque = Juego.tablero.tab[posRey[0] - n][posRey[1]];
                                } catch (Exception e){return true;}
                                chocaxn = true;
                            } else chocaxn = true;
                        } else chocaxn = true;
                    }
                }
            }else chocaxn = true;
            if (!(posRey[1] - n < 0)) {
                if (!chocayn) {
                    if (Juego.tablero.tab[posRey[0]][posRey[1] - n] != null) {
                        if ((Juego.tablero.tab[posRey[0]][posRey[1] - n].color != this.color)) {
                            if (Juego.tablero.tab[posRey[0]][posRey[1] - n] instanceof Torre || Juego.tablero.tab[posRey[0]][posRey[1] - n] instanceof Reina || ((this.color != Juego.tablero.tab[posRey[0]][posRey[1] - n].color) && Juego.tablero.tab[posRey[0]][posRey[1] - n] instanceof Rey && n == 1)) {
                                try {
                                    ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                    Juego.piezaJaque = Juego.tablero.tab[posRey[0]][posRey[1]];
                                } catch (Exception e){return true;}
                                chocayn = true;
                            } else chocayn = true;
                        } else chocayn = true;
                    }
                }
            }else chocayn = true;
            if (!(posRey[0] + n > 7 || posRey[1] + n > 7)) {
                if (!chocadxp) {
                    if (Juego.tablero.tab[posRey[0] + n][posRey[1] + n] != null) {
                        if ((Juego.tablero.tab[posRey[0] + n][posRey[1] + n].color != this.color)) {
                            if (Juego.tablero.tab[posRey[0] + n][posRey[1] + n] instanceof Alfil || Juego.tablero.tab[posRey[0] + n][posRey[1] + n] instanceof Reina || (!(this.color) && Juego.tablero.tab[posRey[0] + n][posRey[1] + n] instanceof Peon && n == 1) || ((this.color != Juego.tablero.tab[posRey[0] + n][posRey[1] + n].color) && Juego.tablero.tab[posRey[0] + n][posRey[1] + n] instanceof Rey && n == 1)) {
                                try {
                                    ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                    Juego.piezaJaque = Juego.tablero.tab[posRey[0] + n][posRey[1] + n];
                                } catch (Exception e) {return true;}
                                chocadxp = true;
                            } else chocadxp = true;
                        } else chocadxp = true;
                    }
                }
            }else chocadxp = true;
            if (!(posRey[0] - n < 0 || posRey[1] + n > 7)) {
                if (!chocadyp) {
                    if (Juego.tablero.tab[posRey[0] - n][posRey[1] + n] != null) {
                        if ((Juego.tablero.tab[posRey[0] - n][posRey[1] + n].color != this.color)) {
                            if (Juego.tablero.tab[posRey[0] - n][posRey[1] + n] instanceof Alfil || Juego.tablero.tab[posRey[0] - n][posRey[1] + n] instanceof Reina || ((this.color) && Juego.tablero.tab[posRey[0] - n][posRey[1] + n] instanceof Peon && n == 1) || ((this.color != Juego.tablero.tab[posRey[0] - n][posRey[1] + n].color) && Juego.tablero.tab[posRey[0] - n][posRey[1] + n] instanceof Rey && n == 1)) {
                                try {
                                    ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                    Juego.piezaJaque = Juego.tablero.tab[posRey[0] - n][posRey[1] + n];
                                } catch (Exception e){return true;}
                                chocadyp = true;
                            } else chocadyp = true;
                        } else chocadyp = true;
                    }
                }
            }else chocadyp = true;
            if (!(posRey[0] - n < 0 || posRey[1] - n < 0)) {
                if (!chocadxn) {
                    if (Juego.tablero.tab[posRey[0] - n][posRey[1] - n] != null) {
                        if ((Juego.tablero.tab[posRey[0] - n][posRey[1] - n].color != this.color)) {
                            if (Juego.tablero.tab[posRey[0] - n][posRey[1] - n] instanceof Alfil || Juego.tablero.tab[posRey[0] - n][posRey[1] - n] instanceof Reina || ((this.color) && Juego.tablero.tab[posRey[0] - n][posRey[1] - n] instanceof Peon && n == 1) || ((this.color != Juego.tablero.tab[posRey[0] - n][posRey[1] - n].color) && Juego.tablero.tab[posRey[0] - n][posRey[1] - n] instanceof Rey && n == 1)) {
                                try {
                                    ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                    Juego.piezaJaque = Juego.tablero.tab[posRey[0] - n][posRey[1] - n];
                                } catch(Exception e){return true;}
                                chocadxn = true;
                            } else chocadxn = true;
                        } else chocadxn = true;
                    }
                }
            }else chocadxn = true;
            if (!(posRey[0] + n > 7 || posRey[1] - n < 0)) {
                if (!chocadyn) {
                    if (Juego.tablero.tab[posRey[0] + n][posRey[1] - n] != null) {
                        if ((Juego.tablero.tab[posRey[0] + n][posRey[1] - n].color != this.color)) {
                            if (Juego.tablero.tab[posRey[0] + n][posRey[1] - n] instanceof Alfil || Juego.tablero.tab[posRey[0] + n][posRey[1] - n] instanceof Reina || (!(this.color) && Juego.tablero.tab[posRey[0] + n][posRey[1] - n] instanceof Peon && n == 1) || ((this.color != Juego.tablero.tab[posRey[0] + n][posRey[1] - n].color) && Juego.tablero.tab[posRey[0] + n][posRey[1] - n] instanceof Rey && n == 1)) {
                                try {
                                    ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                    Juego.piezaJaque = Juego.tablero.tab[posRey[0] + n][posRey[1] - n];
                                } catch (Exception e){return true;}
                                chocadyn = true;
                            } else chocadyn = true;
                        } else chocadyn = true;
                    }
                }
            }else chocadyn = true;
        }
        for (int n = 1; n <= 2; n++) {
            for (int m = 2; m >= 1; m--) {
                if (m == n)
                    continue;
                try {
                    if (Juego.tablero.tab[posRey[0] + n][posRey[1] + m] != null) {
                        if (Juego.tablero.tab[posRey[0] + n][posRey[1] + m] instanceof Caballo && Juego.tablero.tab[posRey[0] + n][posRey[1] + m].color != this.color) {
                            try {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] + n][posRey[1] + m];
                            } catch(Exception e) {return true;}
                        }
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posRey[0] - n][posRey[1] + m] != null) {
                        if (Juego.tablero.tab[posRey[0] - n][posRey[1] + m] instanceof Caballo && Juego.tablero.tab[posRey[0] - n][posRey[1] + m].color != this.color) {
                            try {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] - n][posRey[1] + m];
                            } catch (Exception e){return true;}
                        }
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posRey[0] + n][posRey[1] - m] != null) {
                        if (Juego.tablero.tab[posRey[0] + n][posRey[1] - m] instanceof Caballo && Juego.tablero.tab[posRey[0] + n][posRey[1] - m].color != this.color) {
                            try {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] + n][posRey[1] - m];
                            } catch (Exception e) {return true;}
                        }
                    }
                } catch (Exception e) {
                }
                try {
                    if (Juego.tablero.tab[posRey[0] - n][posRey[1] - m] != null) {
                        if (Juego.tablero.tab[posRey[0] - n][posRey[1] - m] instanceof Caballo && Juego.tablero.tab[posRey[0] - n][posRey[1] - m].color != this.color) {
                            try {
                                ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque = true;
                                Juego.piezaJaque = Juego.tablero.tab[posRey[0] - n][posRey[1] - m];
                            } catch (Exception e) {return true;}
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        try {
            return ((Rey) Juego.tablero.tab[posRey[0]][posRey[1]]).enJaque;
        } catch (Exception e) {return false;}
        }
    @Override
    public void amenaza(Pieza rey){
    }

    public ArrayList<int[]> compararListas(ArrayList<int[]> movValidos, ArrayList<int[]> movAmenaza) {
        ArrayList<int[]> movimientos = new ArrayList<int[]>();
        for (int[] elemento : movValidos) {
            for (int[] elemento2 : movAmenaza) {
                if (elemento[0] == elemento2[0] && elemento[1] == elemento2[1])
                    if(elemento[0] == Juego.piezaJaque.posicionx && elemento[1] == Juego.piezaJaque.posiciony)
                            movimientos.add(elemento);
            }
        }
        return movimientos;
    }
}

