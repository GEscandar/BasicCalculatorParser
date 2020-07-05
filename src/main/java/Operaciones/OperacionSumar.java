package Operaciones;

public class OperacionSumar extends OperacionCompuesta {
    
    public OperacionSumar(Operacion op){
        super(op);
    }
    
    public OperacionSumar(float numero){
        super(numero);
    }
    
    public OperacionSumar(){
        super();
    }

    @Override
    public float evaluar() {
        float resultado = 0;

        for(Operacion operacion: operaciones) {
            resultado += operacion.evaluar();
        }

        return resultado;
    }

    @Override
    public String getSimbolo() {
        return Constantes.SUMA;
    }
}
