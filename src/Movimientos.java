/*
import java.util.ArrayList;


public class Movimientos {
static ArrayList<int[]> movValidos;
int n,m;
boolean chocaxp, chocayp, chocaxn, chocayn,chocadxp, chocadxn, chocadyp, chocadyn;
public int[] mov = new int[2];
    int posicionx;
    int posiciony;
    static public boolean valido;

    public Movimientos(Pieza pieza) {
        movValidos = new ArrayList<int[]>();
        if (pieza instanceof Peon) {
            if (!pieza.color) {
                for (n = 1; n <= 2 && pieza.posicionx + n < 7; n++) {
                    if (Tablero.tab[pieza.posicionx + n][pieza.posiciony] == null) {
                        mov[0] = pieza.posicionx + n;
                        mov[1] = pieza.posiciony;
                        movValidos.add(mov.clone());
                    } else break;
                }
            } else {
                for (n = 1; n <= 2 && pieza.posicionx - n > 0; n++) {
                    if (Tablero.tab[pieza.posicionx - n][pieza.posiciony] == null) {
                        mov[0] = pieza.posicionx - n;
                        mov[1] = pieza.posiciony;
                        movValidos.add(mov.clone());
                    } else break;
                }
            }
        } else if (pieza instanceof Torre) {
            for (n = 1; !(pieza.posicionx + n >= 7 && pieza.posicionx - n < 0 && pieza.posiciony + n >= 7 && pieza.posiciony - n < 0) && (!chocaxp || !chocayp || !chocaxn || !chocayn); n++) {
                if (!(pieza.posicionx + n > 7)) {
                    if (!chocaxp) {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony] == null) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx + n][pieza.posiciony].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony;
                            movValidos.add(mov.clone());
                        } else chocaxp = true;
                    }
                }
                if (!(pieza.posicionx + n > 7)) {
                    if (!chocayp) {
                        if (Tablero.tab[pieza.posicionx][pieza.posiciony + n] == null) {
                            mov[0] = pieza.posicionx;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx][pieza.posiciony + n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else chocayp = true;
                    }
                }
                if (!(pieza.posicionx - n < 0)) {
                    if (!chocaxn) {
                        if (Tablero.tab[pieza.posicionx - n][pieza.posiciony] == null) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx - n][pieza.posiciony].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony;
                            movValidos.add(mov.clone());
                        } else chocaxn = true;
                    }
                }
                if (!(pieza.posiciony - n < 0)) {
                    if (!chocayn) {
                        if (Tablero.tab[pieza.posicionx][pieza.posiciony - n] == null) {
                            mov[0] = pieza.posicionx;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx][pieza.posiciony - n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else chocayn = true;
                    }
                }
            }
        } else if (pieza instanceof Alfil) {
            for (n = 1; !(pieza.posicionx + n >= 7 && pieza.posicionx - n < 0 && pieza.posiciony + n >= 7 && pieza.posiciony - n < 0) && (!chocaxp || !chocayp || !chocaxn || !chocayn); n++) {
                if (!(pieza.posicionx + n > 7 || pieza.posiciony + n > 7)) {
                    if (!chocadxp) {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony + n] == null) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else if (Tablero.tab[pieza.posicionx + n][pieza.posiciony + n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else chocadxp = true;
                    }
                }
                if (!(pieza.posicionx - n < 0 || pieza.posiciony + n > 7)) {
                    if (!chocadyp) {
                        if (Tablero.tab[pieza.posicionx - n][pieza.posiciony + n] == null) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx][pieza.posiciony + n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else chocadyp = true;
                    }
                }
                if (!(pieza.posicionx - n < 0 || pieza.posiciony - n < 0)) {
                    if (!chocadxn) {
                        if (Tablero.tab[pieza.posicionx - n][pieza.posiciony - n] == null) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx - n][pieza.posiciony].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else chocadxn = true;
                    }
                }
                if (!(pieza.posicionx + n > 7 || pieza.posiciony - n < 0)) {
                    if (!chocadyn) {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony - n] == null) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx][pieza.posiciony - n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else chocadyn = true;
                    }
                }
            }
        } else if (pieza instanceof Reina) {
            for (n = 1; !(pieza.posicionx + n >= 7 && pieza.posicionx - n < 0 && pieza.posiciony + n >= 7 && pieza.posiciony - n < 0) && (!chocaxp || !chocayp || !chocaxn || !chocayn); n++) {
                if (!(pieza.posicionx + n > 7)) {
                    if (!chocaxp) {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony] == null) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx + n][pieza.posiciony].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony;
                            movValidos.add(mov.clone());
                            chocaxp = true;
                        } else chocaxp = true;
                    }
                }
                if (!(pieza.posiciony + n > 7)) {
                    if (!chocayp) {
                        if (Tablero.tab[pieza.posicionx][pieza.posiciony + n] == null) {
                            mov[0] = pieza.posicionx;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx][pieza.posiciony + n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                            chocayp = true;
                        } else chocayp = true;
                    }
                }
                if (!(pieza.posicionx - n < 0)) {
                    if (!chocaxn) {
                        if (Tablero.tab[pieza.posicionx - n][pieza.posiciony] == null) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx - n][pieza.posiciony].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony;
                            movValidos.add(mov.clone());
                            chocaxn = true;
                        } else chocaxn = true;
                    }
                }
                if (!(pieza.posiciony - n < 0)) {
                    if (!chocayn) {
                        if (Tablero.tab[pieza.posicionx][pieza.posiciony - n] == null) {
                            mov[0] = pieza.posicionx;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx][pieza.posiciony - n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                            chocayn = true;
                        } else chocayn = true;
                    }
                }
                if (!(pieza.posicionx + n > 7 || pieza.posiciony + n > 7)) {
                    if (!chocadxp) {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony + n] == null) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx + n][pieza.posiciony + n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                            chocadxp = true;
                        } else chocadxp = true;
                    }
                }
                if (!(pieza.posicionx - n < 0 || pieza.posiciony + n > 7)) {
                    if (!chocadyp) {
                        if (Tablero.tab[pieza.posicionx - n][pieza.posiciony + n] == null) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx - n][pieza.posiciony + n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony + n;
                            movValidos.add(mov.clone());
                            chocadyp = true;
                        } else chocadyp = true;
                    }
                }
                if (!(pieza.posicionx - n < 0 || pieza.posiciony - n < 0)) {
                    if (!chocadxn) {
                        if (Tablero.tab[pieza.posicionx - n][pieza.posiciony - n] == null) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx - n][pieza.posiciony - n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                            chocadxn = true;
                        } else chocadxn = true;
                    }
                }
                if (!(pieza.posicionx + n > 7 || pieza.posiciony - n < 0)) {
                    if (!chocadyn) {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony - n] == null) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx + n][pieza.posiciony - n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony - n;
                            movValidos.add(mov.clone());
                            chocadyn = true;
                        } else chocadyn = true;
                    }
                }
            }
        } else if (pieza instanceof Rey) {
            for (n = -1; n <= 1; n++) {
                for (m = -1; m <= 1; m++) {
                    if (pieza.posicionx + n < 0 || pieza.posicionx + n > 7 || (n == 0 && m == 0))
                        continue;
                    try {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony + m] == null) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony + m;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx + n][pieza.posiciony + n].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony + m;
                            movValidos.add(mov.clone());
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        } else if (pieza instanceof Caballo) {
            for (n = 1; n <= 2; n++) {
                for (m = 2; m >= 1; m--) {
                    if (m == n)
                        continue;
                    try {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony + m] == null) {
                            if (pieza.posicionx + n <= 7) {
                                mov[0] = pieza.posicionx + n;
                                mov[1] = pieza.posiciony + m;
                                movValidos.add(mov.clone());
                            }
                        } else if ((Tablero.tab[pieza.posicionx + n][pieza.posiciony + m].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony + m;
                            movValidos.add(mov.clone());
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (Tablero.tab[pieza.posicionx - n][pieza.posiciony + m] == null) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony + m;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx - n][pieza.posiciony + m].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony + m;
                            movValidos.add(mov.clone());
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (Tablero.tab[pieza.posicionx + n][pieza.posiciony - m] == null) {
                            if (pieza.posicionx + n <= 7) {
                                mov[0] = pieza.posicionx + n;
                                mov[1] = pieza.posiciony - m;
                                movValidos.add(mov.clone());
                            }
                        } else if ((Tablero.tab[pieza.posicionx + n][pieza.posiciony - m].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx + n;
                            mov[1] = pieza.posiciony - m;
                            movValidos.add(mov.clone());
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (Tablero.tab[pieza.posicionx - n][pieza.posiciony - m] == null) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony - m;
                            movValidos.add(mov.clone());
                        } else if ((Tablero.tab[pieza.posicionx - n][pieza.posiciony - m].color != Tablero.tab[pieza.posicionx][pieza.posiciony].color)) {
                            mov[0] = pieza.posicionx - n;
                            mov[1] = pieza.posiciony - m;
                            movValidos.add(mov.clone());
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        if (movValidos.size() == 0) {
            System.out.println("No hay movimientos válidos para esa pieza.");
            System.out.println("Seleccione otra pieza.");
            valido = false;
            Tablero.tab[pieza.posicionx][pieza.posiciony].selected = false;
        } else {
            System.out.println("Movimientos válidos:");
            for (int[] elemento : movValidos) {

                System.out.println("[" + elemento[0] + "," + elemento[1] + "]");
            }
            valido = true;
        }
    }

}
 */