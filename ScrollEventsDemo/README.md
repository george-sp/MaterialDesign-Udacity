## ScrollEventsDemo
----------------------------------
This app employs an extended app bar that collapses to a standard height and pins to the top
of the screen as the user scrolls.

_You can build this effect entirely in XML using the new at bar layout and collapsing toolbar layout._

==================================

#### res/layout/activity_main.xml
----------------------------------
<pre>
 CoordinatorLayout
|
|_\ AppBarLayout
| /     <i>android:layout_height="168dp"
|       android:background="?colorPrimary"</i>
|      |
|      |_\ CollapsingToolbarLayout
|        /     <b>app:layout_scrollFlags="scroll|exitUntilCollapsed"</b>
|             |
|             |_\ Toolbar
|               /     <i>android:layout_height="56dp"
|                     app:layout_collapseMode="pin"</i>
|
|_\ RecyclerView
  /     <b>app:layout_behavior="@string/appbar_scrolling_view_behavior"</b>
</pre>

==================================

**Check out the documentation** for scroll flags in layout behaviors to find out about other great scrolling behaviors you can built with the library:
- [Scroll Flags](https://developer.android.com/reference/android/support/design/widget/AppBarLayout.LayoutParams.html#setScrollFlags(int))
- [Layout Behaviors](https://developer.android.com/reference/android/support/design/widget/CoordinatorLayout.LayoutParams.html#setBehavior(android.support.design.widget.CoordinatorLayout.Behavior))
