## AspectRatioDemo
----------------------------------
This application demonstrates an example of always showing our images with a 3:2 aspect ratio.

That is whatever width its given, will set its own height to be two-thirds of this.

==================================
If you're displaying dynamic content where you don't know the exact size it will be or when handling different size devices, it can be useful to display the image at a fixed aspect ratio.

So you know how your design will appear for your users.

To enforce the size of the view itself, we can easily subclass `ImageView` to enforce a given aspect ratio.

**FOLLOW THE STEPS**

1. Create a new class and call it `ThreeTwoImageView`, extend from our custom `ForegroundImageView` (or from `ImageView` itself).

2. Generate all of the required constructors to handle creating this view from code or from XML.

3. **_Key part:_** Override the `onMeasure(int widthMeasureSpec, int heightMeasureSpec)` method.

4. Unpack the given width `int width = MeasureSpec.getSize(widthMeasureSpec)`.

5. Calculate two-thirds (`* 2 / 3`) of this width.

6. Make view's height to be exactly two-thirds of the width height `int threeTwoHeightMeasureSpec = MeasureSpec.makeMeasureSpec(desiredHeight, MeasureSpec.EXACTLY)`.

7. Pass these onto the superclass to handle the rest of the measurement class `super.onMeasure(widthMeasureSpec, threeTwoHeightMeasureSpec)`.

_Note:_ To use this custom class, use the fully qualified name in the tag and follow the convention setting `0dp` as the height.
