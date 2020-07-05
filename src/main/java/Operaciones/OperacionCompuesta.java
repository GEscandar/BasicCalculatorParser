package Operaciones;

import java.util.ArrayList;

public abstract class OperacionCompuesta implements Operacion{

    protected ArrayList<Operacion> operaciones;
    
    public OperacionCompuesta(Operacion operacion){
        operaciones = new ArrayList<Operacion>();
        operaciones.add(operacion);
    }
    
    public OperacionCompuesta(float numero){
        this(new OperacionSimple(numero));
    }
    
    public OperacionCompuesta(){
        operaciones = new ArrayList<Operacion>();
    }

    public void agregarOperacion(Operacion operacion){
        operaciones.add(operacion);
    }

    public void agregarOperacion(float numero){
        this.agregarOperacion(new OperacionSimple(numero));
    }
    
    public Operacion obtenerUltima(){
        return operaciones.get(operaciones.size()-1);
    }
    
    public void establecerUltima(Operacion op){
        operaciones.remove(operaciones.size()-1);
        operaciones.add(op);
    }

    public abstract float evaluar();
    public abstract String getSimbolo();
}
