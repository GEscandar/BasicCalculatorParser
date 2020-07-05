/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora2;

import Operaciones.*;

/**
 *
 * @author Germán
 */
public class CalculatorParser {
    
    public Operacion parsear(String texto){
        
        OperacionSumar operacion = new OperacionSumar();
        OperacionCompuesta ultima = operacion;
        String stringNumero = "";
        texto = "0+" + texto.replaceAll("\\s+","");
        
        for(int i = 0; i < texto.length(); i++){
            
            char caracter = texto.charAt(i);
            
            if(Character.isDigit(caracter)){
                stringNumero += caracter;
            }
            else{
                float numero = Float.parseFloat(stringNumero);

                if(caracter == '+' || caracter == '-'){
                    ultima.agregarOperacion(numero);
                    ultima = FabricaDeOperaciones.crearOperacion(String.valueOf(caracter));
                    operacion.agregarOperacion(ultima);
                }
                
                else if(caracter == 'x' || caracter == '/'){
                    
                    if(ultima.getSimbolo().equals( "/") || ultima.getSimbolo().equals("x")){
                        ultima.agregarOperacion(new OperacionSimple(numero));
                        OperacionCompuesta producto = FabricaDeOperaciones.crearOperacion(String.valueOf(caracter));
                        producto.agregarOperacion(ultima.obtenerUltima());
                        ultima.establecerUltima(producto);
                    }
                }
                
                stringNumero = "";
            }
        }
        
        if(Character.isDigit(texto.charAt(texto.length()-1)))
            ultima.agregarOperacion(new OperacionSimple(Float.parseFloat(stringNumero)));
        
        return operacion;
    }
    
}

