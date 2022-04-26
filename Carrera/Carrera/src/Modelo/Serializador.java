package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serializador {

    private FileInputStream ArchivoEntrada = null;
    private FileOutputStream ArchivoSalida = null;
    private ObjectInputStream SerializadorEntrada = null;
    private ObjectOutputStream SerializadorSalida = null;

    public void GuardarObjeto(ArrayList<Object> data, String NombreArchivo) {
        try {
            ArchivoSalida = new FileOutputStream(NombreArchivo);
            SerializadorSalida = new ObjectOutputStream(ArchivoSalida);
            SerializadorSalida.writeObject(data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                SerializadorSalida.close();
                ArchivoSalida.close();
            } catch (IOException ex) {
                Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Object> LeerObjeto(String NombreArchivo) {
        ArrayList<Object> data = null;
        try {
            ArchivoEntrada = new FileInputStream(NombreArchivo);
            SerializadorEntrada = new ObjectInputStream(ArchivoEntrada);
            data = (ArrayList<Object>) SerializadorEntrada.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                SerializadorSalida.close();
            } catch (IOException ex) {
                Logger.getLogger(Serializador.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                return data;
            }
        }
    }
}
