package org.example.pruebafx;

public class Contador {

    private int contar;

    public Contador() {
        contar = 0;
    }

    public void contar() {
        ++contar;
    }

    public void resetear() {
        contar = 0;
    }

    public int getContar() {
        return contar;
    }
}
