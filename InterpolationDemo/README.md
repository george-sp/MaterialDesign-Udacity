## InterpolationDemo
----------------------------------
This app is an example of interpolation.

==================================

**Details:**
- The app has two spinners.
	- The first one has a list of a bunch of different interpolators like _accelerate_, _decelerate_, _bounce_, _decelerate_, _linear_, _overshoot_.
	- And the second spinner has different timings, from 100 milliseconds all the way up to 3,000 milliseconds or three seconds, _so that you can see how fast or how slow things work_.

**In Code:**
- Create a new instance of the interpolator.
	- Because it's different based off of what the name is, we actually use the Java **`Class.forName(String className)`** to get the class and then instantiate a new instance.
	- But if you were using this in your own app, you would call, **`new BounceInterpolator()`** directly.
