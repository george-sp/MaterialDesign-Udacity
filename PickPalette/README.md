## PickPalette
----------------------------------
This application extracts a palette from an image.

==================================

#### What  it does
After we receive an resource identifier for an image, we can load it into our view and convert it into a bitmap that the palette will use to generate the color swatches.

Alternatively, If we've taken a photo, we'll receive a bitmap from the camera without the need for
that conversion step.

These color swatches fall into two different areas, either vibrant or a muted color.

The type and number of swatches is dependent on the composition of your image.
And how much of it is in a certain color and how that color contrast to other colors in the image.

==================================

**Check out:**
- [Info on Palettes](https://developer.android.com/reference/android/support/v7/graphics/Palette.html)
