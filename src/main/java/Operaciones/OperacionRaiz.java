package Operaciones;

public class OperacionRaiz implements Operacion{

    private Operacion operacion;

    public OperacionRaiz(Operacion operacion){
        this.operacion = operacion;
    }
    
    public OperacionRaiz(){
        operacion = new OperacionSimple(0);
    }

    @Override
    public float evaluar() {
        return (float) Math.sqrt(operacion.evaluar());
    }

    @Override
    public void agregarOperacion(Operacion op) {
        operacion.agregarOperacion(op);
    }
}
