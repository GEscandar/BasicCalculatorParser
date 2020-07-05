package Operaciones;

public class OperacionDividir extends OperacionCompuesta{
    
    public OperacionDividir(Operacion op){
        super(op);
    }
    
    public OperacionDividir(float numero){
        super(numero);
    }

    OperacionDividir() {
        super();
    }

    @Override
    public float evaluar() {
        float resultado = operaciones.get(0).evaluar();

        for (int i = 1; i < operaciones.size(); i++) {
            resultado /= operaciones.get(i).evaluar();
        }

        return resultado;
    }

    @Override
    public String getSimbolo() {
        return Constantes.DIVISION;
    }
}
