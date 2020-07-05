package Operaciones;

public class OperacionRestar extends OperacionCompuesta {

    public OperacionRestar(Operacion op){
        super(op);
    }
    
    public OperacionRestar(float numero){
        super(numero);
    }
    
    public OperacionRestar(){
        super();
    }

    @Override
    public float evaluar() {
        float resultado = operaciones.isEmpty() ? 0 : operaciones.get(0).evaluar();

        for (int i = 1; i < operaciones.size(); i++) {
            resultado -= operaciones.get(i).evaluar();
        }

        return resultado;
    }

    @Override
    public String getSimbolo() {
        return Constantes.RESTA;
    }
}
