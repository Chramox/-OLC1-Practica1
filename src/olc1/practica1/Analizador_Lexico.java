/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.practica1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Juan Marcos Ibarra
 */
public class Analizador_Lexico {

    //VARIABLES
    List<Token> listaTokens = new LinkedList<>();
    int idToken;
    int estado = 0; //variable para ir cambiando de estado
    String auxiliarLexema = ""; //variable donde se guarda el valor del Token
    boolean esCadena = false;
    boolean esComentarioSimple = false;
    boolean esComentarioMultiple = false;
    boolean esNumeroFlotante = false;

    public void Leer(String Texto) {
        char c;
        char[] caracteres = Texto.toCharArray();

        for (int i = 0; i < Texto.length(); i++) {
            c = caracteres[i];

            //IMPLEMENTACION DEL AUTOMATA FINITO
            switch (estado) {
                // ESTADO INICIAL
                case 0: {
                    if (Character.isDigit(c)) {
                        estado = 1;
                        auxiliarLexema += c;
                    } else if (Character.isLetter(c)) {
                        estado = 2;
                        auxiliarLexema += c;
                    }//EMPIEZA COMPARACION PARA LOS SIMBOLOS
                    else if (c == '<') { //MANDAR A ESTADO DE COMENTARIOS
                        auxiliarLexema += c;
                    } else if (c == '/') { //MANDAR A ESTADO DE COMENTARIOS
                        auxiliarLexema += c;
                    } else if (c == ';') {
                        auxiliarLexema += c;
                        agregarToken(Token.Tipo.PUNTO_COMA);
                    } else if (c == ':') {
                        auxiliarLexema += c;
                        agregarToken(Token.Tipo.DOS_PUNTOS);
                    } else if (c == '{') {
                        auxiliarLexema += c;
                        agregarToken(Token.Tipo.LLAVE_APERTURA);
                    } else if (c == '}') {
                        auxiliarLexema += c;
                        agregarToken(Token.Tipo.LLAVE_CIERRE);
                    } else if (c == '_') {
                        estado = 2;
                        auxiliarLexema += c;
                        agregarToken(Token.Tipo.DOS_PUNTOS);
                    } else if (c == ',') {
                        auxiliarLexema += c;
                        agregarToken(Token.Tipo.PUNTO_COMA);
                    } else if (c == '.') {
                        auxiliarLexema += c;
                        agregarToken(Token.Tipo.PUNTO);
                    }
                }
                break;
                case 1://NUMEROS, SI Y SOLO SI, NUMEROS
                {
                    if (Character.isDigit(c)) {
                        estado = 1;
                        auxiliarLexema += c;
                    } else if (c == '.') {
                        esNumeroFlotante = true;
                        estado = 1;
                        auxiliarLexema += c;
                    } else if (Character.isLetter(c))// SE CONVIERTE EN ERROR (ID`S NO PUEDEN EMPEZAR CON NUMERO)
                    {
                        estado = 4;
                        auxiliarLexema += c;
                    } else {
                        idToken = 40;
                        i--;
                        if (esNumeroFlotante == false) {
                            agregarToken(Token.Tipo.NUMERO_ENTERO);
                        } else // esNumeroFlotante == true -> se agreaga un numero flotante
                        {
                            agregarToken(Token.Tipo.NUMERO_FLOTANTE);
                        }

                    }
                }
                break;
        }
    }
}

public void agregarToken(Token.Tipo Tipo){
            listaTokens.add(new Token(Tipo, auxiliarLexema, idToken));
            auxiliarLexema = "";
            estado = 0;
        }
}
