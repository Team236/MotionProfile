# MotionProfile
Code to generate and use motion profiles for smooth autonomous movement

This is Techno Ticks package, just like Updater, Tickanum, Standard, etc.
This means that it is designed to be easy to incorporate into your robot project,
and it is meant to be abstract enough to run not only on an FRC robot, but any 
robot that runs java.

## Installing

If your robot project (`workspace/robot`) is not a git project, this is very simple.
Just open the command line, navigate to `workspace/robot/src` and type the following
command: 
```
git clone https://https://github.com/Team236/MotionProfile.git motionProfile
git clone https://https://github.com/Team236/Updater.git updater
```

If your robot project is a git project, then you have to add it as a git submodule.
This is an experimental feature that hasn't existed for too long, so keep in mind
that it's not perfect for more complex purposes. For what we're doing, however, it's
perfect. Just navigate to `workspace/robot/src` and type the following commands:

```
git submodule add https://github.com/Team236/MotionProfile.git motionProfile
git submodule add https://https://github.com/Team236/Updater.git updater
git submodule init
```

This will import the module and create unstaged changes. You
will have to commit this change, and commit your change whenever you update the
module.

After this, your tree should look like this:

    MyRobot
        src
            motionProfile
            updater
            org
                first
                    ...

# Using

Motion Profiles are easy to create, and moderately more difficult to follow.
You can look at our 2016-Robot project for an example of how to implement this.

More docs to come.
