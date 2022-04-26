package Modelo;

import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Competidor extends Thread implements Comparable<Competidor>, Serializable {

    private Carrera carrera;
    private final String Nombre;
    private final double Edad;
    private final String Nacionalidad;
    private final int Numero;
    private final String Color;
    private int pasos;
    private int Tiempo;
    private static int A = 0;
    private javax.swing.JLabel Caballo;

    public Competidor(String Nombre, double Edad, String Nacionalidad, int Numero, String Color, int pasos, javax.swing.JLabel caballo, Carrera carrera) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Nacionalidad = Nacionalidad;
        this.Numero = Numero;
        this.Color = Color;
        this.pasos = pasos;
        this.Tiempo = 0;
        this.Caballo = caballo;
        this.carrera = carrera;
    }

    public Competidor() {
        this.Nombre = " ";
        this.Edad = 0;
        this.Nacionalidad = " ";
        this.Numero = 0;
        this.Color = " ";
        this.pasos = 0;
        this.Tiempo = 0;
        this.Caballo = new javax.swing.JLabel();
    }

    public String getNombre() {
        return Nombre;
    }

    public double getEdad() {
        return Edad;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public int getNumero() {
        return Numero;
    }

    public String getColor() {
        return Color;
    }

    public int getPasos() {
        return pasos;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

    public JLabel getCaballo() {
        return Caballo;
    }

    public void setCaballo(JLabel Caballo) {
        this.Caballo = Caballo;
    }

    @Override
    public int compareTo(Competidor t) {
        if (Tiempo < t.Tiempo) {
            return -1;
        }
        if (Tiempo > t.Tiempo) {
            return 1;
        }
        return 0;
    }

    @Override
    public void run() {
        boolean Meta = false;
        long Dormir;
        int Espera;
        while (!Meta) {
            Espera = 0;
            if (pasos >= 710) {
                Meta = true;
            } else {
                pasos += Math.random() * 50;
                Espera += Math.random() * 50;
                Caballo.setLocation(pasos, Caballo.getY());
                try {
                    Dormir = Espera * 20;
                    Tiempo += Dormir;
                    Thread.sleep(Dormir);
                } catch (InterruptedException ex) {
                    try {
                        Thread.currentThread().join();
                    } catch (InterruptedException ex1) {
                    }
                }
            }
        }
        A++;
        if (A == carrera.getNroCompetidores()) {
            carrera.terminarCarrera(true);
            A = 0;
        }
    }
}
