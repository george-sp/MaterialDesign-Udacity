## TickCrossDemo
----------------------------------
A simple example of changing a tick into a cross.

Of course this can combined with other effects, such as throwing in a rotate, to get a little bit fancier.

The restriction when morphing is that the shapes need to have the same number of drawing commands in them in order to interpolate between the two states.

==================================

### [**`android.graphics.drawable.VectorDrawable`**](https://developer.android.com/reference/android/graphics/drawable/VectorDrawable.html)

[VectorDrawable](https://developer.android.com/reference/android/graphics/drawable/VectorDrawable.html) was introduced in Lollipop and lets you create density independent images by defining a series of drawing commands. (It's similar in concept to SVG on the web.)

Here is an example:

```
<vector xmlns = ... 
    android:width = "120dp"
    android:height = "120dp"
    android:viewportWidth = "24dp"
    android:viewportHeight = "24dp">

    <path
        android:name = "cross"
        android:pathData = "M6.4,6.4 L17.6,17.6 M6.4,17.6 L17.6,6.4"
        android:strokeWidth = "2dp"
        android:strokeLineCap = "square"
        android:strokeColor = "#999"
</vector>
```

> It defines a path which has a series of space separated drawing commands, which use a subset of the SVG path data spec to draw lines, curves and so on.
>
> These commands draw a cross by :
>
> Moving to a point.
> Drawing a line to another point.
> Lifting and moving to another point.
> And drawing another line.
>
> Simple.

Vectors aren't appropriate for every kind of image.
You wouldn't want to represent a person's face with a vector, for example.
But iconography and simple illustrations are great candidates.

- The vector format provides **density independence**, meaning that the same image works on any screen density. When vector support reaches enough devices, you won't have to explore assets at multiple different sizes.

- It also generally produces a **small file size**.

But the opportunity to animate all or parts of the image is what we're really interested in right now.

### [**`android.graphics.drawable.AnimatedVectorDrawable`**](https://developer.android.com/reference/android/graphics/drawable/AnimatedVectorDrawable.html)

The [AnimatedVectorDrawable](https://developer.android.com/reference/android/graphics/drawable/AnimatedVectorDrawable.html) class lets you animate any property of a part of set of parts.

Here's a list of what you can animate:

- translate
- scale
- rotate
- opacity
- color
- path
- trim start/end
- clip-path

> The first five have pretty standard animation properties. (But having the ability to target
individual elements within the drawable is quite powerful.)
>
> The last three properties and the kind of animation they allow are more unique:
> - **_path_**: We can animate the actual path data itself, allowing you to morph, so to speak, one shape into another. (We can, of course, combine this with other effects, such as throwing in a rotate, to get a little bit fancier.)
> The restriction when morphing is that the shapes need to have the same number of drawing commands in them in order to interpolate between the two states.
> - **_trim start/end_**: When drawing a path, VectorDrawable allows you to only draw a portion of it
by trimming the start or end of it.
> - **_clip_path_**: VectorDrawables also support the notion of clip pass. That is applying a clip
region to your drawing. Animating this clip region allows you to reveal or hide portions of the image.
