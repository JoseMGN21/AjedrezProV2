import java.util.ArrayList;

public abstract class Pieza {

    boolean color;
    boolean regresar;
    boolean viva;
    int posicionx;
    int posiciony;
    boolean selected;
    String icon;
    ArrayList<int[]> movValidos = new ArrayList<int[]>();
    ArrayList<int[]> movAmenaza = new ArrayList<int[]>();
    int n, m;
    public int[] mov = new int[2];
    public int[] ame = new int[2];
    public int[] posPieza = new int[2];
    static public boolean valido;


    public abstract void movimiento();

    public abstract void amenaza(Pieza rey);

    public abstract ArrayList<int[]> compararListas(ArrayList<int[]> movValidos, ArrayList<int[]> movAmenaza);

    public boolean comprobarBloqueoComer() {
        for (int[] elemento : this.movAmenaza) {
            boolean chocaxp = false, chocayp = false, chocaxn = false, chocayn = false, chocadxp = false, chocadxn = false, chocadyp = false, chocadyn = false;
            for (int n = 1; !(elemento[0] + n >= 7 && elemento[0] - n < 0 && elemento[1] + n >= 7 && elemento[1] - n < 0) && (!chocaxp || !chocayp || !chocaxn || !chocayn || !chocadyn || !chocadyp || !chocadxn || !chocadxp); n++) {
                if (!(elemento[0] + n > 7)) {
                    if (!chocaxp) {
                        if (Juego.tablero.tab[elemento[0] + n][elemento[1]] != null) {
                            if ((Juego.tablero.tab[elemento[0] + n][elemento[1]].color != Juego.piezaJaque.color)) {
                                if(this.movAmenaza.indexOf(elemento) != 0 && !this.color && (n < 3)){
                                    if(n == 1 && Juego.tablero.tab[elemento[0] + n][elemento[1]] instanceof  Peon && Juego.tablero.tab[elemento[0] + n][elemento[1]].color != this.color){
                                        return true;
                                    } else if (n == 2 && Juego.tablero.tab[elemento[0] + n][elemento[1]] instanceof  Peon && Juego.tablero.tab[elemento[0] + n][elemento[1]].color != this.color && !((Peon) Juego.tablero.tab[elemento[0] + n][elemento[1]]).moved){
                                        return true;
                                    }
                                }
                                if (Juego.tablero.tab[elemento[0] + n][elemento[1]] instanceof Torre || Juego.tablero.tab[elemento[0] + n][elemento[1]] instanceof Reina) {
                                    return true;
                                } else chocaxp = true;
                            } else chocaxp = true;
                        }
                    }
                } else chocaxp = true;
                if (!(elemento[1] + n > 7)) {
                    if (!chocayp) {
                        if (Juego.tablero.tab[elemento[0]][elemento[1] + n] != null) {
                            if ((Juego.tablero.tab[elemento[0]][elemento[1] + n].color != Juego.piezaJaque.color)) {
                                if(this.movAmenaza.indexOf(elemento) != 0 && this.color && (n < 3)){
                                    if(n == 1 && Juego.tablero.tab[elemento[0] + n][elemento[1]] instanceof  Peon && Juego.tablero.tab[elemento[0] + n][elemento[1]].color != this.color){
                                        return true;
                                    } else if (n == 2 && Juego.tablero.tab[elemento[0] + n][elemento[1]] instanceof  Peon && Juego.tablero.tab[elemento[0] + n][elemento[1]].color != this.color && !((Peon) Juego.tablero.tab[elemento[0] + n][elemento[1]]).moved){
                                        return true;
                                    }
                                }
                                if (Juego.tablero.tab[elemento[0]][elemento[1] + n] instanceof Torre || Juego.tablero.tab[elemento[0]][elemento[1] + n] instanceof Reina) {
                                    return true;
                                } else chocayp = true;
                            } else chocayp = true;
                        }
                    }
                } else chocayp = true;
                if (!(elemento[0] - n < 0)) {
                    if (!chocaxn) {
                        if (Juego.tablero.tab[elemento[0] - n][elemento[1]] != null) {
                            if ((Juego.tablero.tab[elemento[0] - n][elemento[1]].color != Juego.piezaJaque.color)) {
                                if (Juego.tablero.tab[elemento[0] - n][elemento[1]] instanceof Torre || Juego.tablero.tab[elemento[0] - n][elemento[1]] instanceof Reina) {
                                    return true;
                                } else chocaxn = true;
                            } else chocaxn = true;
                        }
                    }
                } else chocaxn = true;
                if (!(elemento[1] - n < 0)) {
                    if (!chocayn) {
                        if (Juego.tablero.tab[elemento[0]][elemento[1] - n] != null) {
                            if ((Juego.tablero.tab[elemento[0]][elemento[1] - n].color != Juego.piezaJaque.color)) {
                                if (Juego.tablero.tab[elemento[0]][elemento[1] - n] instanceof Torre || Juego.tablero.tab[elemento[0]][elemento[1] - n] instanceof Reina) {
                                    return true;
                                } else chocayn = true;
                            } else chocayn = true;
                        }
                    }
                } else chocayn = true;
                if (!(elemento[0] + n > 7 || elemento[1] + n > 7)) {
                    if (!chocadxp) {
                        if (Juego.tablero.tab[elemento[0] + n][elemento[1] + n] != null) {
                            if ((Juego.tablero.tab[elemento[0] + n][elemento[1] + n].color != Juego.piezaJaque.color)) {
                                if(this.movAmenaza.indexOf(elemento) == 0 && !this.color && (n == 1)){
                                    if(Juego.tablero.tab[elemento[0] + n][elemento[1] + n] instanceof Peon && Juego.tablero.tab[elemento[0] + n][elemento[1] + n].color != this.color);
                                    return true;
                                }
                                if (Juego.tablero.tab[elemento[0] + n][elemento[1] + n] instanceof Alfil || Juego.tablero.tab[elemento[0] + n][elemento[1] + n] instanceof Reina || (!(Juego.piezaJaque.color) && Juego.tablero.tab[elemento[0] + n][elemento[1] + n] instanceof Peon)) {
                                    return true;
                                } else chocadxp = true;
                            } else chocadxp = true;
                        }
                    }
                } else chocadxp = true;
                if (!(elemento[0] - n < 0 || elemento[1] + n > 7)) {
                    if (!chocadyp) {
                        if (Juego.tablero.tab[elemento[0] - n][elemento[1] + n] != null) {
                            if ((Juego.tablero.tab[elemento[0] - n][elemento[1] + n].color != Juego.piezaJaque.color)) {
                                if(this.movAmenaza.indexOf(elemento) == 0 && this.color && (n == 1)){
                                    if(Juego.tablero.tab[elemento[0] - n][elemento[1] + n] instanceof Peon && Juego.tablero.tab[elemento[0] - n][elemento[1] + n].color != this.color);
                                    return true;
                                }
                                if (Juego.tablero.tab[elemento[0] - n][elemento[1] + n] instanceof Alfil || Juego.tablero.tab[elemento[0] - n][elemento[1] + n] instanceof Reina || ((Juego.piezaJaque.color) && Juego.tablero.tab[elemento[0] - n][elemento[1] + n] instanceof Peon)) {
                                    return true;
                                } else chocadyp = true;
                            } else chocadyp = true;
                        }
                    }
                } else chocadyp = true;
                if (!(elemento[0] - n < 0 || elemento[1] - n < 0)) {
                    if (!chocadxn) {
                        if (Juego.tablero.tab[elemento[0] - n][elemento[1] - n] != null) {
                            if ((Juego.tablero.tab[elemento[0] - n][elemento[1] - n].color != Juego.piezaJaque.color)) {
                                if(this.movAmenaza.indexOf(elemento) == 0 && this.color && (n == 1)){
                                    if(Juego.tablero.tab[elemento[0] - n][elemento[1] - n] instanceof Peon && Juego.tablero.tab[elemento[0] - n][elemento[1] - n].color != this.color);
                                    return true;
                                }
                                if (Juego.tablero.tab[elemento[0] - n][elemento[1] - n] instanceof Alfil || Juego.tablero.tab[elemento[0] - n][elemento[1] - n] instanceof Reina || ((Juego.piezaJaque.color) && Juego.tablero.tab[elemento[0] - n][elemento[1] - n] instanceof Peon)) {
                                    return true;
                                } else chocadxn = true;
                            } else chocadxn = true;
                        }
                    }
                } else chocadxn = true;
                if (!(elemento[0] + n > 7 || elemento[1] - n < 0)) {
                    if (!chocadyn) {
                        if (Juego.tablero.tab[elemento[0] + n][elemento[1] - n] != null) {
                            if ((Juego.tablero.tab[elemento[0] + n][elemento[1] - n].color != Juego.piezaJaque.color)) {
                                if(this.movAmenaza.indexOf(elemento) == 0 && !this.color && (n == 1)){
                                    if(Juego.tablero.tab[elemento[0] + n][elemento[1] - n] instanceof Peon && Juego.tablero.tab[elemento[0] + n][elemento[1] - n].color != this.color);
                                    return true;
                                }
                                if (Juego.tablero.tab[elemento[0] + n][elemento[1] - n] instanceof Alfil || Juego.tablero.tab[elemento[0] + n][elemento[1] - n] instanceof Reina || (!(Juego.piezaJaque.color) && Juego.tablero.tab[elemento[0] + n][elemento[1] - n] instanceof Peon)) {
                                    return true;
                                } else chocadyn = true;
                            } else chocadyn = true;
                        }
                    }
                } else chocadyn = true;
            }
            for (int n = 1; n <= 2; n++) {
                for (int m = 2; m >= 1; m--) {
                    if (m == n)
                        continue;
                    try {
                        if (Juego.tablero.tab[posicionx + n][posiciony + m] != null) {
                            if (Juego.tablero.tab[posicionx + n][posiciony + m] instanceof Caballo && Juego.tablero.tab[posicionx + n][posiciony + m].color != this.color) {
                                return true;
                            }
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (Juego.tablero.tab[posicionx - n][posiciony + m] != null) {
                            if (Juego.tablero.tab[posicionx - n][posiciony + m] instanceof Caballo && Juego.tablero.tab[posicionx - n][posiciony + m].color != this.color) {
                                return true;
                            }
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (Juego.tablero.tab[posicionx + n][posiciony - m] != null) {
                            if (Juego.tablero.tab[posicionx + n][posiciony - m] instanceof Caballo && Juego.tablero.tab[posicionx + n][posiciony - m].color != this.color) {
                                return true;
                            }
                        }
                    } catch (Exception e) {
                    }
                    try {
                        if (Juego.tablero.tab[posicionx - n][posiciony - m] != null) {
                            if (Juego.tablero.tab[posicionx - n][posiciony - m] instanceof Caballo && Juego.tablero.tab[posicionx - n][posiciony - m].color != this.color) {
                                return true;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return false;
    }

    public boolean comprobarMovimientoRey(Pieza rey){
        rey.movimiento();
        return rey.movValidos.size() != 0;
    }
    public void buscarRey(int[] posPieza){
        Juego.piezaBloqueada = null;
        boolean chocaxp = false, chocayp = false, chocaxn = false, chocayn = false, chocadxp = false, chocadxn = false, chocadyp = false, chocadyn = false;
        Pieza posRey;
        for (int n = 1; !((posPieza[0] + n >= 7 && posPieza[0] - n < 0 && posPieza[1] + n >= 7 && posPieza[1] - n < 0) && !(!chocaxp || !chocayp || !chocaxn || !chocayn || !chocadxp || !chocadxn || !chocadyp || !chocadyn)) ; n++) {
            if (!(posPieza[0] + n > 7)) {
                if (!chocaxp) {
                    if (Juego.tablero.tab[posPieza[0] + n][posPieza[1]] != null) {
                        if ((Juego.tablero.tab[posPieza[0] + n][posPieza[1]].color == Juego.tablero.tab[posPieza[0]][posPieza[1]].color && Juego.tablero.tab[posPieza[0] + n][posPieza[1]] instanceof Rey)) {
                            posRey =Juego.tablero.tab[posPieza[0] + n][posPieza[1]];
                            buscarPiezaOponente("Reyxp", posRey);
                            break;
                            } else chocaxp = true;
                        }
                    }
            } else chocaxp = true;
            if (!(posPieza[1] + n > 7)) {
                if (!chocayp) {
                    if (Juego.tablero.tab[posPieza[0]][posPieza[1] + n] != null) {
                        if ((Juego.tablero.tab[posPieza[0]][posPieza[1] + n].color == Juego.tablero.tab[posPieza[0]][posPieza[1]].color && Juego.tablero.tab[posPieza[0]][posPieza[1] + n] instanceof Rey)) {
                            posRey =Juego.tablero.tab[posPieza[0]][posPieza[1] + n];
                            buscarPiezaOponente("Reyyp", posRey);
                            break;
                        } else chocayp = true;
                    }
                }
            }else chocayp = true;
            if (!(posPieza[0] - n < 0)) {
                if (!chocaxn) {
                    if (Juego.tablero.tab[posPieza[0] - n][posPieza[1]] != null) {
                        if ((Juego.tablero.tab[posPieza[0] - n][posPieza[1]].color == Juego.tablero.tab[posPieza[0]][posPieza[1]].color && Juego.tablero.tab[posPieza[0] - n][posPieza[1]] instanceof Rey)) {
                            posRey =Juego.tablero.tab[posPieza[0] - n][posPieza[1]];
                            buscarPiezaOponente("Reyxn", posRey);
                            break;
                        } else chocaxn = true;
                    }
                }
            }else chocaxn = true;
            if (!(posPieza[1] - n < 0)) {
                if (!chocayn) {
                    if (Juego.tablero.tab[posPieza[0]][posPieza[1] - n] != null) {
                        if ((Juego.tablero.tab[posPieza[0]][posPieza[1] - n].color == Juego.tablero.tab[posPieza[0]][posPieza[1]].color && Juego.tablero.tab[posPieza[0]][posPieza[1] - n] instanceof Rey)) {
                            posRey =Juego.tablero.tab[posPieza[0]][posPieza[1] - n];
                            buscarPiezaOponente("Reyyn", posRey);
                            break;
                        } else chocayn = true;
                    }
                }
            }else chocayn = true;
            if (!(posPieza[0] + n > 7 || posPieza[1] + n > 7)) {
                if (!chocadxp) {
                    if (Juego.tablero.tab[posPieza[0] + n][posPieza[1] + n] != null) {
                        if ((Juego.tablero.tab[posPieza[0] + n][posPieza[1] + n].color == Juego.tablero.tab[posPieza[0]][posPieza[1]].color && Juego.tablero.tab[posPieza[0] + n][posPieza[1] + n] instanceof Rey)) {
                            posRey =Juego.tablero.tab[posPieza[0] + n][posPieza[1] + n];
                            buscarPiezaOponente("Reydxp", posRey);
                            break;
                        } else chocadxp = true;
                    }
                }
            }else chocadxp = true;
            if (!(posPieza[0] - n < 0 || posPieza[1] + n > 7)) {
                if (!chocadyp) {
                    if (Juego.tablero.tab[posPieza[0] - n][posPieza[1] + n] != null) {
                        if ((Juego.tablero.tab[posPieza[0] - n][posPieza[1] + n].color == Juego.tablero.tab[posPieza[0]][posPieza[1]].color && Juego.tablero.tab[posPieza[0] - n][posPieza[1] + n] instanceof Rey)) {
                            posRey =Juego.tablero.tab[posPieza[0] - n][posPieza[1] + n];
                            buscarPiezaOponente("Reydyp", posRey);
                            break;
                        } else chocadyp = true;
                    }
                }
            }else chocadyp = true;
            if (!(posPieza[0] - n < 0 || posPieza[1] - n < 0)) {
                if (!chocadxn) {
                    if (Juego.tablero.tab[posPieza[0] - n][posPieza[1] - n] != null) {
                        if ((Juego.tablero.tab[posPieza[0] - n][posPieza[1] - n].color == Juego.tablero.tab[posPieza[0]][posPieza[1]].color && Juego.tablero.tab[posPieza[0] - n][posPieza[1] - n] instanceof Rey)) {
                            posRey =Juego.tablero.tab[posPieza[0] - n][posPieza[1] - n];
                            buscarPiezaOponente("Reydxn", posRey);
                            break;
                        } else chocadxn = true;
                    }
                }
            }else chocadxn = true;
            if (!(posPieza[0] + n > 7 || posPieza[1] - n < 0)) {
                if (!chocadyn) {
                    if (Juego.tablero.tab[posPieza[0] + n][posPieza[1] - n] != null) {
                        if ((Juego.tablero.tab[posPieza[0] + n][posPieza[1] - n].color == Juego.tablero.tab[posPieza[0]][posPieza[1]].color && Juego.tablero.tab[posPieza[0] + n][posPieza[1] - n] instanceof Rey)) {
                            posRey =Juego.tablero.tab[posPieza[0] + n][posPieza[1] - n];
                            buscarPiezaOponente("Reydyn", posRey);
                            break;
                        } else chocadyn = true;
                    }
                }
            }else chocadyn = true;
        }
    }

    public void buscarPiezaOponente(String direccion, Pieza posRey){
        switch(direccion){
            case "Reyxp":
                for(int n = 1 ; this.posicionx - n >= 0 ; n++){
                    if(Juego.tablero.tab[this.posicionx - n][this.posiciony] != null){
                        if((Juego.tablero.tab[this.posicionx - n][this.posiciony] instanceof Reina || Juego.tablero.tab[this.posicionx - n][this.posiciony] instanceof Torre) && Juego.tablero.tab[this.posicionx - n][this.posiciony].color != this.color) {
                            Juego.tablero.tab[this.posicionx - n][this.posiciony].amenaza(posRey);
                            Juego.piezaBloqueada = Juego.tablero.tab[this.posicionx - n][this.posiciony];
                            break;
                        } else {
                            Juego.piezaBloqueada = null;
                            break;
                        }
                    }
                }
                break;
            case "Reyyp":
                for(int n = 1 ; this.posiciony - n >= 0 ; n++){
                    if(Juego.tablero.tab[this.posicionx][this.posiciony - n] != null){
                        if((Juego.tablero.tab[this.posicionx][this.posiciony - n] instanceof Reina || Juego.tablero.tab[this.posicionx][this.posiciony - n] instanceof Torre) && Juego.tablero.tab[this.posicionx][this.posiciony - n].color != this.color) {
                            Juego.tablero.tab[this.posicionx][this.posiciony - n].amenaza(posRey);
                            Juego.piezaBloqueada = Juego.tablero.tab[this.posicionx][this.posiciony - n];
                            break;
                        } else {
                            Juego.piezaBloqueada = null;
                            break;
                        }
                    }
                }
                break;
            case "Reyxn":
                for(int n = 1 ; this.posicionx + n <= 7 ; n++){
                    if(Juego.tablero.tab[this.posicionx + n][this.posiciony] != null){
                        if((Juego.tablero.tab[this.posicionx + n][this.posiciony] instanceof Reina || Juego.tablero.tab[this.posicionx + n][this.posiciony] instanceof Torre) && Juego.tablero.tab[this.posicionx + n][this.posiciony].color != this.color){
                            Juego.tablero.tab[this.posicionx + n][this.posiciony].amenaza(posRey);
                            Juego.piezaBloqueada = Juego.tablero.tab[this.posicionx + n][this.posiciony];
                            break;
                        } else {
                            Juego.piezaBloqueada = null;
                            break;
                        }
                    }
                }
                break;
            case "Reyyn":
                for(int n = 1 ; this.posiciony + n <= 7 ; n++){
                    if(Juego.tablero.tab[this.posicionx][this.posiciony + n] != null){
                        if((Juego.tablero.tab[this.posicionx][this.posiciony + n] instanceof Reina || Juego.tablero.tab[this.posicionx][this.posiciony + n] instanceof Torre) && Juego.tablero.tab[this.posicionx][this.posiciony + n].color != this.color) {
                            Juego.tablero.tab[this.posicionx][this.posiciony + n].amenaza(posRey);
                            Juego.piezaBloqueada = Juego.tablero.tab[this.posicionx][this.posiciony + n];
                            break;
                        } else {
                            Juego.piezaBloqueada = null;
                            break;
                        }
                    }
                }
                break;
            case "Reydxp":
                for(int n = 1 ; this.posicionx - n >= 0 && this.posiciony - n >= 0 ; n++){
                    if(Juego.tablero.tab[this.posicionx - n][this.posiciony - n] != null){
                        if((Juego.tablero.tab[this.posicionx - n][this.posiciony - n] instanceof Reina || Juego.tablero.tab[this.posicionx - n][this.posiciony - n] instanceof Alfil) && Juego.tablero.tab[this.posicionx - n][this.posiciony - n].color != this.color) {
                            Juego.tablero.tab[this.posicionx - n][this.posiciony - n].amenaza(posRey);
                            Juego.piezaBloqueada = Juego.tablero.tab[this.posicionx - n][this.posiciony - n];
                            break;
                        } else {
                            Juego.piezaBloqueada = null;
                            break;
                        }
                    }
                }
                break;
            case "Reydyp":
                for(int n = 1 ; this.posicionx + n <= 7 && this.posiciony - n >= 0 ; n++){
                    if(Juego.tablero.tab[this.posicionx + n][this.posiciony - n] != null){
                        if((Juego.tablero.tab[this.posicionx + n][this.posiciony - n] instanceof Reina || Juego.tablero.tab[this.posicionx + n][this.posiciony - n] instanceof Alfil) && Juego.tablero.tab[this.posicionx + n][this.posiciony - n].color != this.color) {
                            Juego.tablero.tab[this.posicionx + n][this.posiciony - n].amenaza(posRey);
                            Juego.piezaBloqueada = Juego.tablero.tab[this.posicionx + n][this.posiciony - n];
                            break;
                        } else {
                            Juego.piezaBloqueada = null;
                            break;
                        }
                    }
                }
                break;
            case "Reydxn":
                for(int n = 1 ; this.posicionx + n <= 7 && this.posiciony + n <= 7 ; n++){
                    if(Juego.tablero.tab[this.posicionx + n][this.posiciony + n] != null){
                        if((Juego.tablero.tab[this.posicionx + n][this.posiciony + n] instanceof Reina || Juego.tablero.tab[this.posicionx + n][this.posiciony + n] instanceof Alfil) && Juego.tablero.tab[this.posicionx + n][this.posiciony + n].color != this.color) {
                            Juego.tablero.tab[this.posicionx + n][this.posiciony + n].amenaza(posRey);
                            Juego.piezaBloqueada = Juego.tablero.tab[this.posicionx + n][this.posiciony + n];
                            break;
                        }  else {
                            Juego.piezaBloqueada = null;
                            break;
                        }
                    }
                }
                break;
            case "Reydyn":
                for(int n = 1 ; this.posicionx - n <= 0 && this.posiciony + n >= 7 ; n++){
                    if(Juego.tablero.tab[this.posicionx - n][this.posiciony + n] != null){
                        if((Juego.tablero.tab[this.posicionx - n][this.posiciony + n] instanceof Reina || Juego.tablero.tab[this.posicionx - n][this.posiciony + n] instanceof Alfil) && Juego.tablero.tab[this.posicionx + n][this.posiciony - n].color != this.color) {
                            Juego.tablero.tab[this.posicionx - n][this.posiciony + n].amenaza(posRey);
                            Juego.piezaBloqueada = Juego.tablero.tab[this.posicionx - n][this.posiciony + n];
                            break;
                        } else {
                            Juego.piezaBloqueada = null;
                            break;
                        }
                    }
                }
                break;
        }
    }
}





