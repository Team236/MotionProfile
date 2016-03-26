package motionProfile;

import updater.Updatable;

/**
 * 
 * @author samcf_000
 *
 */

public class ProfileFollowerNoFeedback implements Updatable {
    // Profile to be followed
    Profile profile;
    // Step of profile
    private int i = 0;
    // Source for position feedback
    // public ProfileSource source;
    // Output for the motor power
    public ProfileOutput output;
    // Constants + Gains
    double kV, kA, kP;
    double endPosition;
    public volatile boolean isEnabled;
    public volatile boolean onTarget;
    public volatile double error;

    public ProfileFollowerNoFeedback(Profile p, ProfileOutput output, FollowParameters params) {
	this.profile = p;
	// this.source = source;
	this.output = output;
	this.kV = params.kV;
	this.kA = params.kA;
	this.kP = params.kP;

	this.endPosition = p.get(p.length() - 1).position;
    }

    @Override
    public void update() {
	// Make sure i is within bounds of profile
	if (i < 0) {
	    i = 0;
	} else if (i >= profile.length()) {
	    i = profile.length() - 1;
	}
	// Get position from the profile
	// double position = profile.get(i).position;
	// Determine if we are on target. Allowing error of +/- .1
	// onTarget = Math.abs(endPosition + source.getDistance()) < .1;

	// error = endPosition - source.getDistance();

	// Calculate the acceleration and velocity feedforward
	double v = kV * profile.get(i).speed;
	// Calculate the correction
	double correction = 0;
	// Set the speed of the motor with correction
	output.setSpeed(v + correction);
	// Increment our loop counter
	i++;
    }

    @Override
    public void enable() {
	this.isEnabled = true;
    }

    @Override
    public void disable() {
	this.isEnabled = false;
    }

    @Override
    public boolean isEnabled() {
	return isEnabled;
    }

    @Override
    public String toString() {
	return "Motion Profile Follower";
    }
}
