package sprint1;

abstract class Instrument {
    protected String name;
    protected double price;
    
    public Instrument(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }
    
    public abstract void play();
}

class Wind extends Instrument {
    static {
        System.out.println("Loading Wind class...");
    }
    
    public Wind(String name, double price) {
        super(name, price);
    }
    
    @Override
    public void play() {
        System.out.println("A wind instrument is playing");
    }
}

class String extends Instrument {
    static {
        System.out.println("Loading String class...");
    }
    
    public String(String name, double price) {
        super(name, price);
    }
    
    @Override
    public void play() {
        System.out.println("A string instrument is playing");
    }
}

class Percussion extends Instrument {
    static {
        System.out.println("Loading Percussion class...");
    }
    
    public Percussion(String name, double price) {
        super(name, price);
    }
    
    @Override
    public void play() {
        System.out.println("A percussion instrument is playing");
    }
}

public class Tasca1 {
    public static void main(String[] args) {
        System.out.println("Creating first wind instrument:");
        Wind flute = new Wind("Flute", 100.0);
        flute.play();
        
        System.out.println("\nCreating first string instrument:");
        String guitar = new String("Guitar", 200.0);
        guitar.play();
        
        System.out.println("\nCreating first percussion instrument:");
        Percussion drum = new Percussion("Drum", 150.0);
        drum.play();
    }
}
