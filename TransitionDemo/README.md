## ImmersiveImagesDemo
----------------------------------
In this application, when the button is tapped the OS executes a transition.

==================================

#### How it works
**`beginDelayedTransition`** takes a view group and a transition type.
In this case it's the root view and the slide transition.

1. Immediately after the call to `beginDelayedTransition()`, transition calls capture start states.
Which indicated captures the start save for all views in the view group before we've modified them.
2. After that's done we modify the elements we want to change or transition.
3. When the frame is done, transition manager calls capture end states, which stores the end states of all views in the view group.
4. The transition calls creat animator with the state and animator set and executes it.

==================================

**Check the documentation**
- [TransitionManager](https://developer.android.com/reference/android/transition/TransitionManager.html)
