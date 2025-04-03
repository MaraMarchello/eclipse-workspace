package pruebaNivel1;

public class Satellite implements CelestialObject {
	private String name;
	private double gravity;
	private double mass;
	private double radius;
	private double rotationPeriod;
	private double orbitalPeriod;

	public Satellite(String name, double gravity, double mass, double radius, 
					double rotationPeriod, double orbitalPeriod) {
		this.name = name;
		this.gravity = gravity;
		this.mass = mass;
		this.radius = radius;
		this.rotationPeriod = rotationPeriod;
		this.orbitalPeriod = orbitalPeriod;
	}

	@Override
	public double getGravity() { return gravity; }
	@Override
	public double getMass() { return mass; }
	@Override
	public double getRadius() { return radius; }
	@Override
	public double getRotationPeriod() { return rotationPeriod; }
	@Override
	public double getOrbitalPeriod() { return orbitalPeriod; }
	public String getName() { return name; }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
