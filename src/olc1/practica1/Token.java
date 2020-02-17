/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.practica1;

/**
 *
 * @author marco
 */
public class Token {
    //TIPOS DE TOKENS ADMITIDOS EN EL PROGRAMA
    public enum Tipo
    {
         // SIMBOLOS ESPECIALES
            LLAVE_APERTURA,     //  { X
            LLAVE_CIERRE,       //  } X
            DOS_PUNTOS,         //  : X
            PARENTESIS_APERTURA,//  ( X
            PARENTESIS_CIERRE,  //  ) X
            COMILLA_DOBLE,      //  "  [REVISAR]
            COMA,               //  , X
            PUNTO,              //    X
            PUNTO_COMA,         //    X 
            // OPERADORES
            OP_SUMA,            //    X  
            GUION_BAJO,         //    X
            // OPERADORES MAYOR Y MENOR
            MAYOR,              //  > X
            MENOR,              //  < X
            // -----------------------------
            NUMERO_ENTERO,
            NUMERO_FLOTANTE,
            CADENA,
            ERROR,
            IDENTIFICADOR, // NOMBRES DE METODOS, VARIABLES, CLASES, ETC.
            // -----------------------------
            // PALABRAS RESERVADAS
            // [NO SE CUALES VAN A SER MIS PALABRAS RESERVADAS TODAVIA]
            //TIPOS DE VARIABLES
            INT,             //    X 
            FLOAT,           //    X 
            CHAR,            //    X 
            STRING,          //    X 
            BOOL,             //    X 
            // COMENTARIOS
            COMENTARIO_SIMPLE, // //
            COMENTARIO_MULTILINEA, // /*
            // */
    }
}
