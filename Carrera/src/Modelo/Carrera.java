package Modelo;

import Vista.VistaUsuario;
import java.io.Serializable;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Carrera extends Thread implements Serializable {
    
    private Competidor[] competidor;
    private Competidor[] resultados;
    private int NroCompetidores = 5;
    private boolean carreraTerminada;
    private VistaUsuario vista;
    public DefaultTableModel model;

    public Carrera(VistaUsuario vista) {
        this.vista = vista;
        model = (DefaultTableModel) vista.JTabResultados.getModel();
        competidor = new Competidor[NroCompetidores];
        resultados = new Competidor[NroCompetidores];
        carreraTerminada = false;
        for (int x = 0; x < NroCompetidores; x++) {
            resultados[x] = null;
            competidor[x] = null;
        }
        competidor[0] = new Competidor("Panchito", 20, "Colombia", 1, "Gris", vista.Caballo1.getLocation().x, vista.Caballo1, this);
        competidor[1] = new Competidor("Juanita", 19, "Argentina", 2, "Rojo", vista.Caballo2.getLocation().x, vista.Caballo2, this);
        competidor[2] = new Competidor("Michael Jackson", 34, "EEUU", 3, "Azul", vista.Caballo3.getLocation().x, vista.Caballo3, this);
        competidor[3] = new Competidor("Andrei", 22, "Colombia", 4, "Verde", vista.Caballo4.getLocation().x, vista.Caballo4, this);
        competidor[4] = new Competidor("Sofia", 18, "Colombia", 5, "Magenta", vista.Caballo5.getLocation().x, vista.Caballo5, this);
    }

    public int getNroCompetidores() {
        return NroCompetidores;
    }

    public void setNroCompetidores(int NroCompetidores) {
        this.NroCompetidores = NroCompetidores;
    }

    public Competidor[] getResultados() {
        return resultados;
    }

    public void setResultados(Competidor[] resultados) {
        this.resultados = resultados;
    }

    public boolean isCarreraTerminada() {
        return carreraTerminada;
    }

    public void setCarreraTerminada(boolean carreraTerminada) {
        this.carreraTerminada = carreraTerminada;
    }

    public Competidor[] getCompetidor() {
        return competidor;
    }

    public void setCompetidor(Competidor[] competidor) {
        this.competidor = competidor;
    }

    public VistaUsuario getVista() {
        return vista;
    }

    public void setVista(VistaUsuario vista) {
        this.vista = vista;
    }

    public void terminarCarrera(boolean señalUltCompetidor) {
        this.carreraTerminada = señalUltCompetidor;
        resultados = competidor;
        Arrays.sort(resultados);
        int a = 0;
        Object[] O = new Object[3];
        for (int x = 0; x < 5; x++) {
            if (resultados[x].getTiempo() > 0) {
                O[0] = a+1;
                O[1] = resultados[x].getColor();
                O[2] = ((double) this.resultados[x].getTiempo()) / 1000;
                model.addRow(O);
                a++;
            }
        }
    }

    public void pausar() {
        for (int x = 0; x < NroCompetidores; x++) {
            competidor[x].interrupt();
        }
    }

    public void pedirNroCompetidores() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(vista, "Bienvenid@ a la carrera:\n"
                        + "Escoja el Numero de competidores que quiere que participen: (2-5)");
                if (input == null || (input != null && ("".equals(input)))) {
                    NroCompetidores = 0;
                    break;
                }
                NroCompetidores = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Ingrese el número en formato númerico!");
            }
        }
    }

    @Override
    public void run() {
        for (int x = 0; x < NroCompetidores; x++) {
            competidor[x].start();
        }
    }

}
