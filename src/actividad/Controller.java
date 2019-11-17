/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Controller {

    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Persona> classroom = new ArrayList();
    ArrayList<MasaCorporal> history = new ArrayList();

    public Controller() {
        this.loadMenu();
    }

    public void loadMenu() {
        this.optionSelected(JOptionPane.showInputDialog("Escoja una opcion:\n1.Crear Array de personas\n2.Mostrar Array de persona\n3.Ver Historial de persona\n 4.Salir"));
    }

    public void optionSelected(String op) {
        switch (op) {
            case "1":

                try {
                    this.createArray();
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case "2":
                this.showArray();
                break;
            case "3":
                this.menuIMC();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion NO valida");
                this.loadMenu();
                break;

        }
    }

    public void createArray() throws IOException {
        String n = "", a = "", fn = "", id = "", g = "", d = "", em = "", tel = "", cel = "";
        int i = 0, an = 0;
        boolean act = true;
        while (act) {
            i++;
            an = 0;
            System.out.print("Digite nombre de persona " + i + ":              ");
            n = leer.readLine();
            System.out.print("Digite apellido de persona " + i + ":            ");
            a = leer.readLine();
            System.out.print("Digite fecha de nacimiento de persona " + i + ": ");
            fn = leer.readLine();
            System.out.print("Digite identificacion de persona " + i + ":      ");
            id = leer.readLine();
            System.out.print("Digite genero de persona " + i + ":              ");
            g = leer.readLine();
            System.out.print("Digite direccion de persona " + i + ":           ");
            d = leer.readLine();
            System.out.print("Digite email de persona " + i + ":               ");
            em = leer.readLine();
            System.out.print("Digite telefono de persona " + i + ":            ");
            tel = leer.readLine();
            System.out.print("Digite celular de persona " + i + ":             ");
            cel = leer.readLine();
            this.classroom.add(new Persona(n, a, fn, id, g, d, em, tel, cel));
            System.out.println("\n------------------------------------------------------------------\n");
            do {
                an = Integer.parseInt(JOptionPane.showInputDialog("¿Desea añadir otra persona?\n 1. SI \n 2. NO"));
                if (an == 1) {
                    act = true;
                } else if (an == 2) {
                    act = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                }
            } while (an != 1 && an != 2);
        }
        System.out.println("\n\n\n\n\n");
        this.loadMenu();
    }
    
    public void showArray(){
        for (Persona opc : classroom) {

            System.out.println(opc.getFullNombre());
            System.out.println(opc.getFecha_nacimienta());
            System.out.println(String.valueOf(opc.getedad())+" AÑOS");
            System.out.println(opc.getIdentidad());
            System.out.println(opc.getDireccion());
            System.out.println(opc.getEmail());
            System.out.println(opc.getTelefono());
            System.out.println(opc.getCelular());
            System.out.println("--------------------------------------------------------------- \n");
        }
        this.loadMenu();
    }
    
    public void eliminarArray(){
        String ie = JOptionPane.showInputDialog("Digite Id de la persona que desee eliminar");
        for (int i = 0; i < classroom.size(); i++) {
           if (classroom.equals(ie)) {
            classroom.remove(i);
            JOptionPane.showMessageDialog(null, "Seguro desea eliminar este elemento", " ", JOptionPane.OK_CANCEL_OPTION);
        } else  {
               JOptionPane.showMessageDialog(null, "No se encontro el ID");
           }
        }
        this.loadMenu();
    }
    
    public void menuIMC() {
        op(JOptionPane.showInputDialog("Escoja una opcion:\n"
                + "1.IMC Agregar\n"
                + "2.IMC Mostrar\n"
                + "3.Volver\n"
                + "4.Salir"));

    }
 
    public void op(String op) {
        switch (op) {
            case "1": {
                try {
                    this.crearIMC();
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "2":
                this.mostrarIMC();
                break;
            case "3":
                this.loadMenu();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion NO valida");
                this.menuIMC();
                break;
    
        }
    }

    public void  crearIMC() throws IOException{
        double a = 0.0, p = 0.0;
        int i = 0, an = 0;
        boolean act = true;
        while (act) {
            i++;
            an = 0;
            System.out.print("Digite Altura de persona " + i + ":              ");
            a = Double.parseDouble(leer.readLine());
            System.out.print("Digite peso de persona   " + i + ":              ");
            p = Double.parseDouble(leer.readLine());;
            
            this.history.add(new MasaCorporal(p, a));
            System.out.println("\n------------------------------------------------------------------\n");
            do {
                an = Integer.parseInt(JOptionPane.showInputDialog("¿Desea añadir otra persona?\n 1. si \n 2. no"));
                if (an == 1) {
                    act = true;
                } else if (an == 2) {
                    act = false;
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                }
            } while (an != 1 && an != 2);
        }
        System.out.println("\n\n\n\n");
        this.menuIMC();
        }
    
    public void mostrarIMC (){
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i).calcularIMC() + "\n"
                             + history.get(i).validarimc());
            System.out.println("--------------------------------------------------------------- \n");
        }
        this.menuIMC();
    }
}
