package motionProfile;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * 
 * @author samcf_000
 * @param _motorA
 *            A SpeedController to set speed
 * @param _motorB
 *            A SpeedController to set speed
 * @param _enc
 *            An Encoder to read distance from
 */
public class DriveSide implements ProfileSource, ProfileOutput {

	private ArrayList<SpeedController> motors;
	private Encoder enc;
	private boolean invertEncoder;

	public DriveSide(ArrayList<SpeedController> _motors, Encoder _enc, boolean _invertEncoder) {
		this.enc = _enc;
		invertEncoder = _invertEncoder;

		motors = new ArrayList<SpeedController>();

		// Copy motors from arg list to the private list
		for (int i = 0; i < _motors.size(); i++) {
			this.motors.add(_motors.get(i));
		}
	}

	public void addMotor(SpeedController _motor) {
		motors.add(_motor);
	}

	@Override
	public void setSpeed(double speed) {
		for (int i = 0; i < motors.size(); i++) {
			motors.get(i).set(speed);
		}
	}

	@Override
	public double getDistance() {
		//if invert encoder is true, multiply by -1, otherwise multiply by 1.
		return enc.getDistance() * (invertEncoder?-1:1);
	}

	public double getSpeed() {
		return motors.get(0).get();
	}
}
