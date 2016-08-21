## DynamicSurfacesDemo
----------------------------------
In this app, when you scroll, the image disappears and the word eclairs appears in the app bar.
_The image has a **parallax effect** as it collapses. - **(the foreground moves faster than the background, providing a sense of depth to the scene)**_

==================================

#### Important Note
Without this line:
<pre>
<b>android:nestedScrollingEnabled="true"</b>
</pre>
the app doesn't know when to scroll the toolbar, so our toolbar remains stationary.

This is because `AppBarLayout` expects to have a sibling in `CoordinatorLayout` that is capable of nested scrolling.

We can do that with a nested scroll view from the support library, or by setting `nestedScrollingEnabled` to true.

The **`nestedScrollingEnabled`** property is only present on **`ScrollView`** for Lollipop and above.

Nested scrolling works with CoordinatorLayout to notify and manage when:
- the app bar should be scrolling,
- the nested view should be scrolling,
- both should be scrolling,
- or none.

==================================

**Check these out:**
- [Parallax Scrolling](https://en.wikipedia.org/wiki/Parallax_scrolling)
- [Read more  about AppBarLayout](https://developer.android.com/reference/android/support/design/widget/AppBarLayout.html)
