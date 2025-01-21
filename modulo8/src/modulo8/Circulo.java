package modulo8;

public class Circulo {
    private Punto centro;
    private double radio;

    public Circulo(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public double distanciaCentros(Circulo otroCirculo) {
        double dx = this.centro.getPosicioX() - otroCirculo.centro.getPosicioX();
        double dy = this.centro.getPosicioY() - otroCirculo.centro.getPosicioY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean ecuales(Circulo otroCirculo) {
        return this.centro.getPosicioX() == otroCirculo.centro.getPosicioX() &&
               this.centro.getPosicioY() == otroCirculo.centro.getPosicioY() &&
               this.radio == otroCirculo.radio;
    }

    public boolean sonConcentrics(Circulo otroCirculo) {
        return this.centro.getPosicioX() == otroCirculo.centro.getPosicioX() &&
               this.centro.getPosicioY() == otroCirculo.centro.getPosicioY();
    }

    public boolean tienenIgualRadio(Circulo otroCirculo) {
        return this.radio == otroCirculo.radio;
    }

    public boolean sonTangentes(Circulo otroCirculo) {
        double distancia = distanciaCentros(otroCirculo);
        return distancia == this.radio + otroCirculo.radio || distancia == Math.abs(this.radio - otroCirculo.radio);
    }

    public boolean sonSecantes(Circulo otroCirculo) {
        double distancia = distanciaCentros(otroCirculo);
        return distancia < this.radio + otroCirculo.radio && distancia > Math.abs(this.radio - otroCirculo.radio);
    }

    public boolean noSeTocan(Circulo otroCirculo) {
        double distancia = distanciaCentros(otroCirculo);
        return distancia > this.radio + otroCirculo.radio;
    }
}
