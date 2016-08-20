## ScrollEventsDemo
----------------------------------
This app employs an extended app bar that collapses to a standard height and pins to the top
of the screen as the user scrolls.

_You can build this effect entirely in XML using the new at bar layout and collapsing toolbar layout._

==================================

#### res/layout/activity_main.xml
----------------------------------
``` 
 CoordinatorLayout
|
|_\ AppBarLayout
  / 	android:layout_height="168dp"
        android:background="?colorPrimary"
```
