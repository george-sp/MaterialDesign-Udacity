## ImmersiveImagesDemo
----------------------------------
This app was created to show how images can be manipulated.

==================================

**Transformations and ScaleTypes:**
-**`FIT_CENTER`****:** The default ScaleType for an image is `FIT_CENTER`. It scales the image to fit inside the view while keeping the aspect ratio. If the axes don't match, the empty space is distributed on both sides of the image, either the top and bottom or left and right.
-**`FIT_START`****:** Scales the image to fit the view but it aligns it, the image, so that the unused space appears before the image.
-**`FIT_END`****:** Scales the image to fit the view but it aligns the image so that the unused space appears after the image.
-**`FIT_XY`****:** Scales the image to use all the space in  the view, even the aspect ratio changes. In other words, unless your image has an aspect ratio that closely matches your view, using `FIT_XY` might be a bad idea.
-**`CENTER`****:** Displays the image centered in the view with no scaling at all. In this case, in our example, the image is larger than our view so we only see a small portion of it.
-**`CENTER_INSIDE`****:** Attempts to center the image in the view and will scale it down to fit. If the image is smaller than the view, it won't scale it up and the extra space will evenly distributed around the image. If the image is larger than the view, `CENTER_INSIDE` will look similar to the results of `FIT_CENTER`.
-**`CENTER_CROP`****:** Scales the image so that both the width and the height exceed the dimensions of the view. It centers the image and then crops everything that was left around it but not in view. It can make an already great image more impactful.
-**`MATRIX`****:** A `Matrix` is composed of translations, scaling and rotation. For this matrix, the x and y axes were scaled in half and 100 pixels were translated in each direction.

> **NOTE:**
> - _Don't_ use ill sized images.
> - _Don't_ add large paddings.
>
> It makes your images look lower quality.

==================================
**Check for ScaleType information:**
- [ScaleType official documentation](https://developer.android.com/reference/android/widget/ImageView.ScaleType.html)
