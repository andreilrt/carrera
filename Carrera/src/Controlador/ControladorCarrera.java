package Controlador;

import Modelo.Carrera;
import Modelo.Serializador;
import Vista.VistaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class ControladorCarrera implements ActionListener {

    private final VistaUsuario vista;
    private Carrera carrera;
    private Carrera respaldo;
    private final Serializador serializador;
    private String nombreDelArchivo;
    private int NroComp;
    private ArrayList<Object> data;

    public ControladorCarrera() {
        vista = new VistaUsuario();
        vista.setVisible(true);
        data = null;
        carrera = new Carrera(vista);
        respaldo = carrera;
        serializador = new Serializador();
        NroComp = 5;
        inicio();
    }

    public void inicio() {
        vista.JMnuiAbrir.addActionListener(this);
        vista.JMnuiIniciar.addActionListener(this);
        vista.JMnuiGuardar.addActionListener(this);
        vista.JMnuiPausar.addActionListener(this);
        vista.JMnuiReanudar.addActionListener(this);
        vista.JMnuiReiniciar.addActionListener(this);
        vista.JMnuiSalir.addActionListener(this);
    }

    public void borrarTabla() {
        if (vista.JTabResultados.getRowCount() != 0) {
            for (int x = 0; x < NroComp; x++) {
                carrera.model.removeRow(0);
            }
        }
    }

    public void iniciarCarrera() {
        carrera = new Carrera(vista);
        borrarTabla();
        if (vista.JMnuiPausar.isEnabled() || carrera.isAlive()) {
            this.suspenderCarrera();
        }
        carrera.pedirNroCompetidores();
        NroComp = carrera.getNroCompetidores();
        respaldo.setNroCompetidores(NroComp);
        carrera.setNroCompetidores(NroComp);
        vista.Caballo1.setLocation(10, 60);
        vista.Caballo2.setLocation(10, 140);
        vista.Caballo3.setLocation(10, 210);
        vista.Caballo4.setLocation(10, 290);
        vista.Caballo5.setLocation(10, 360);
        carrera.start();
    }

    public void guardar() {
        if (vista.JMnuiPausar.isEnabled() || carrera.isAlive()) {
            this.suspenderCarrera();
        }
        for (int x = 0; x < 5; x++) {
            respaldo.getCompetidor()[x].setTiempo(carrera.getCompetidor()[x].getTiempo());
        }
        carrera = new Carrera(vista);
        for (int x = 0; x < 5; x++) {
            carrera.getCompetidor()[x].setTiempo(respaldo.getCompetidor()[x].getTiempo());
        }
        carrera.setNroCompetidores(NroComp);
        data = new ArrayList<>();
        data.add(carrera);
        data.add(carrera.getCompetidor());
        data.add(carrera.getResultados());
        if (data != null) {
            nombreDelArchivo = JOptionPane.showInputDialog(vista, "Escriba el nombre del archivo", "Guardar archivo", JOptionPane.QUESTION_MESSAGE);
            if (nombreDelArchivo == null || (nombreDelArchivo != null && "".equals(nombreDelArchivo))) {
                JOptionPane.showMessageDialog(vista, "Se ha cancelado");
            } else {
                serializador.GuardarObjeto(data, nombreDelArchivo);
                JOptionPane.showMessageDialog(vista, "Se ha guardado correctamente");
            }
        }
    }

    public void abrir() {
        borrarTabla();
        if (vista.JMnuiPausar.isEnabled() || carrera.isAlive()) {
            this.suspenderCarrera();
        }
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(vista);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            JOptionPane.showMessageDialog(fc, "Archivo: " + file.getName() + "\nAbierto", "Archivo abierto", JOptionPane.INFORMATION_MESSAGE);
            nombreDelArchivo = file.getName();
            data = serializador.LeerObjeto(nombreDelArchivo);
            carrera = (Carrera) data.get(0);
            this.NroComp = carrera.getNroCompetidores();
            carrera.setResultados(carrera.getCompetidor());
            Arrays.sort(carrera.getResultados());//organizar
            int a = 0;
            DefaultTableModel model = (DefaultTableModel) vista.JTabResultados.getModel();
            Object[] O = new Object[3];
            for (int x = 0; x < 5; x++) {
                if (carrera.getResultados()[x].getTiempo() > 0) {
                    O[0] = a + 1;
                    O[1] = carrera.getResultados()[x].getColor();
                    O[2] = ((double) carrera.getResultados()[x].getTiempo()) / 1000;
                    model.addRow(O);
                    a++;
                }
                respaldo = carrera;
            }
            vista.Caballo1.setLocation(carrera.getCompetidor()[4].getCaballo().getX(), carrera.getCompetidor()[4].getCaballo().getY());
            vista.Caballo2.setLocation(carrera.getCompetidor()[3].getCaballo().getX(), carrera.getCompetidor()[3].getCaballo().getY());
            vista.Caballo3.setLocation(carrera.getCompetidor()[2].getCaballo().getX(), carrera.getCompetidor()[2].getCaballo().getY());
            vista.Caballo4.setLocation(carrera.getCompetidor()[1].getCaballo().getX(), carrera.getCompetidor()[1].getCaballo().getY());
            vista.Caballo5.setLocation(carrera.getCompetidor()[0].getCaballo().getX(), carrera.getCompetidor()[0].getCaballo().getY());
        } else {
            JOptionPane.showMessageDialog(fc, "Cancelado", "Cancelar", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void suspenderCarrera() {
        try {
            for (int x = 0; x < 5; x++) {
                respaldo.getCompetidor()[x].setTiempo(carrera.getCompetidor()[x].getTiempo());
            }
            carrera.pausar();
            carrera.join();
            carrera = new Carrera(vista);
            for (int x = 0; x < 5; x++) {
                carrera.getCompetidor()[x].setTiempo(respaldo.getCompetidor()[x].getTiempo());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reanudar() {
        carrera = new Carrera(vista);
        borrarTabla();
        if (vista.JMnuiPausar.isEnabled() || carrera.isAlive()) {
            this.suspenderCarrera();
        }
        carrera.setNroCompetidores(NroComp);
        carrera.start();
    }

    public void reiniciar() {
        this.suspenderCarrera();
        vista.Caballo1.setLocation(10, 60);
        vista.Caballo2.setLocation(10, 140);
        vista.Caballo3.setLocation(10, 210);
        vista.Caballo4.setLocation(10, 290);
        vista.Caballo5.setLocation(10, 360);
        this.iniciarCarrera();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        vista.JMnuiAbrir.setEnabled(true);
        vista.JMnuiIniciar.setEnabled(true);
        vista.JMnuiGuardar.setEnabled(true);
        vista.JMnuiPausar.setEnabled(true);
        vista.JMnuiReanudar.setEnabled(true);
        vista.JMnuiReiniciar.setEnabled(true);
        if (ae.getSource() == vista.JMnuiAbrir) {
            this.abrir();
            vista.JMnuiIniciar.setEnabled(false);
        }
        if (ae.getSource() == vista.JMnuiIniciar) {
            this.iniciarCarrera();
            vista.JMnuiIniciar.setEnabled(false);
            vista.JMnuiReanudar.setEnabled(false);
        }
        if (ae.getSource() == vista.JMnuiGuardar) {
            this.guardar();
        }
        if (ae.getSource() == vista.JMnuiPausar) {
            this.suspenderCarrera();
            vista.JMnuiPausar.setEnabled(false);
        }
        if (ae.getSource() == vista.JMnuiReanudar) {
            this.reanudar();
            vista.JMnuiIniciar.setEnabled(false);
            vista.JMnuiReanudar.setEnabled(false);
        }
        if (ae.getSource() == vista.JMnuiReiniciar) {
            this.reiniciar();
            vista.JMnuiIniciar.setEnabled(false);
            vista.JMnuiReanudar.setEnabled(false);
        }
        if (ae.getSource() == vista.JMnuiSalir) {
            System.exit(0);
        }
    }

}
