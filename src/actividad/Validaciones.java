/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author usuario
 */
public class Validaciones {
        
    public static boolean isEmail(String email){
    String regex= "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
        Pattern patron = Pattern.compile(regex); 
        Matcher m = patron.matcher(email);
        boolean validar = m.find();
    return validar;
    }
    
    public static boolean isCelular(String cel){
    String regex= "^3[0-9]{9,9}$";
        Pattern patron = Pattern.compile(regex); 
        Matcher m = patron.matcher(cel);
        boolean validar = m.find();
    return validar;
    }
    
    public static boolean isTelefono(String tel){
    String regex= "^3[0-9]{6,6}$";
        Pattern patron = Pattern.compile(regex); 
        Matcher m = patron.matcher(tel);
        boolean validar = m.find();
    return validar;
    }
    
}
