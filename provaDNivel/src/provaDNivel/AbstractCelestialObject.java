package provaDNivel;

public abstract class AbstractCelestialObject implements CelestialObject2 {
    protected String name;
    protected double gravity;
    protected double mass;
    protected double radius;
    protected double rotationPeriod;
    protected double orbitalPeriod;
    
    public AbstractCelestialObject(String name, double gravity, double mass, double radius, 
                                  double rotationPeriod, double orbitalPeriod) {
        this.name = name;
        this.gravity = gravity;
        this.mass = mass;
        this.radius = radius;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
    }
    
    @Override
    public double getGravity() {
        return gravity;
    }
    
    @Override
    public double getMass() {
        return mass;
    }
    
    @Override
    public double getRadius() {
        return radius;
    }
    
    @Override
    public double getRotationPeriod() {
        return rotationPeriod;
    }
    
    @Override
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    
    @Override
    public String getName() {
        return name;
    }
} 