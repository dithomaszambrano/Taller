package actividad;

public class MasaCorporal extends Persona{
    
    double peso;
    double altura;
    double IMD;

    public MasaCorporal() {
    }

    public MasaCorporal(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getIMD() {
        return IMD;
    }

    public void setIMD(double IMD) {
        this.IMD = IMD;
    }
    
    public double calcularIMC() {
        double imc = peso / (altura * altura)*10000;
        return imc; 
        
    }
    
    public String validarimc() {
        double imc = calcularIMC();
        String clasificacion = "";
        if (imc < 16) {
            return clasificacion = "Infrapeso: Delgadez severa";
        } else if (imc < 17) {
            return clasificacion = "Infrapeso: Delgadez moderada";
        } else if (imc < 18.50) {
            return clasificacion = "Infrapeso: Delgadez aceptable";
        } else if (imc < 25) {
            return clasificacion = "Peso normal";
        } else if (imc < 30) {
            return clasificacion = "Sobrepeso";
        } else if (imc < 35) {
            return clasificacion = "Obeso: Tipo 1";
        } else if (imc < 40) {
            return clasificacion = "Obeso: Tipo 2";
        } else {
            return clasificacion = "Obeso: Tipo 3";
        }

    }
}
