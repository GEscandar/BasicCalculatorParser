/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

/**
 *
 * @author Germán
 */
public class FabricaDeOperaciones {
   
    public static OperacionCompuesta crearOperacion(String stringOperacion) {
        if (Constantes.SUMA.equals(stringOperacion)) {
            return new OperacionSumar();
        } else if (Constantes.DIVISION.equals(stringOperacion)) {
            return new OperacionDividir();
        } else if (Constantes.PRODUCTO.equals(stringOperacion)) {
            return new OperacionMultiplicar();
        } else if (Constantes.RESTA.equals(stringOperacion)) {
            return new OperacionRestar(new OperacionSimple(0));
        }
         
         return new OperacionSumar();
    }
    
}
