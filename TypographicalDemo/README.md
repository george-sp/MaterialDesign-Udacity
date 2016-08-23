## TypographicalDemo
----------------------------------
A small app to show you the different typographical sizes, and their names, that are available in Android.

> Let's say you found a font that looks great on a bunch of different screen resolutions and different sizes, and even better, it doesn't detract from the overall theme of your app.
>
> How would you use it?
>
> 1. Pick up a font from Google web fonts, because most of them are available with open source licenses.
> 2. Add an `assets` directory under `source` `main`.
> 3. Include the selected font, which in this case is "Courgette-Regular", in the `assets` directory.
> 4. If you're using your font inside a `fragment`, due to the fragment life cycle, you need to instantiate the type face in the _`onAttach()`_ method. The reason for this is there's a short period of time after a fragment is created, but before it's attached to a host activity.
So, if you can see in this **`Typeface.createFromAsset()`** function, we have `getActivity()` and then `getAssets()`.
If this is called before it's attached to the activity, it will result in an error.
So, if we go to our _`onCreateView()`_ method, after instantiating our text views, we just call the **`setTypeface()`** function with the object that we just created.
