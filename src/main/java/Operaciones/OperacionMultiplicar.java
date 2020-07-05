package Operaciones;

public class OperacionMultiplicar extends OperacionCompuesta{
    
    public OperacionMultiplicar(Operacion op){
        super(op);
    }
    
    public OperacionMultiplicar(float numero){
        super(numero);
    }
    
    public OperacionMultiplicar(){
        super();
    }

    @Override
    public float evaluar() {
        float resultado = 1;

        for (Operacion operacion: operaciones) {
            resultado *= operacion.evaluar();
        }

        return resultado;
    }

    @Override
    public String getSimbolo() {
        return Constantes.PRODUCTO; 
    }
}
