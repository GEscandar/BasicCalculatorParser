package Operaciones;

public class OperacionSimple implements Operacion{
    protected float numero;

    public OperacionSimple(float numero){
        this.numero = numero;
    }

    public float evaluar() {
        return numero;
    }

    public void agregarOperacion(Operacion op) {}
}
