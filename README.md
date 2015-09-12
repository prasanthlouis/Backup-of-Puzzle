# Backup-of-Puzzle

My most stable commit is the "Lint Commit".

But the newest commit shouldn't be having any problems. Please do take a look if you're interested. Check the commit messages for more info.

Features added that weren't in the original version.

1) Developed material design. Material design was already added for the previous version. But I've added some animations to go along with it.

2) Overflow removed, instead added icons to action bar.

3) Developed a Free as well as Paid version for the apps using gradle product flavors.

By using product flavors, you can develop separate builds for the apps with minimal code.

Link will be updated soon!

Free Version : https://play.google.com/store/apps/details?id=com.psiuol12.kaitpicco.puzzleapplication.free

Paid Version : https://play.google.com/store/apps/details?id=com.psiuol12.kaitpicco.puzzleapplication.paid

(The paid version is free for now. I don't know the password for the master developer account. Sorry :D 

But hey, no ads! Yay.)

4)Modularity of code. (More functions)

5)SQLite database for your history

6)Promo video accessible from action bar. Check it out here: https://www.youtube.com/watch?v=03Im4B9nyTE

7)More unit tests. Including intent checking.



Old Stuff:


1) 2 EditTexts with a hint. It’s important never to hard code your
strings. Always enter your strings into your strings.xml file. It
helps when you want to make multiple strings.xml files for multiple
languages. Plus Lint hates when you hardcode constants.
2) Spinner data was obtained from array.xml file. Plus it uses a
custom layout that I defined in spinner_item.xml. Make the layout
yours!
3) Image buttons are pretty nice. I used a check_mark with multiple
sizes located in drawable**dpi folders. According to Google “Pictures
are faster than words”. Define separate icons of the same image to
accommodate for all screen sizes.
4) Use a separate color and sound when clicking on the image button.
Give the user some encouragement that he/she has interacted with the
button.
5) I use fragments. Fragments help in more modular code and helps to
reduce the waste of empty space on tablets.
6) I used a ScrollView on my first screen so on smaller screens, you
can scroll the layout to click on the button without minimizing the
keyboard. Yes, you could resize the whole layout after the keyboard
comes into focus, but in my opinion everything looks a little more
cramped.
7) Set a background! Now the important thing to remember here is that
we use .9.png images because they automatically resize well despite
how large the screen is. There are tools in your sdk-tools to generate
the images, but I used an online service. Just upload a jpeg, they’ll
make it into the .9patch image. If you used a jpeg directly, it’ll
look distorted on some screens.
8) My icon is a sun. Icons are always placed in your mip-map folder.
This is because in some applications, like your launcher it’ll pick
the next best size (Eg. if you’re on a nexus 4 it’ll pick xxhdpi
instead of xhdpi) to make the icon a bit sharper. But mip-maps are
only used for icons. Don’t place your drawables here.
9) The JSON string was in the form of a file. Hmmm. Instead of
actually hard-coding into the app directly, I hosted it online. See it
here:https://api.myjson.com/bins/4i6jm.
10) Well because of that, I worked with http connections. So I used
the async task. Now why? It’s because retrieving the data only
consumes a small time. If the task was downloading a large file, I’d
rather use a service. Async tasks aren’t supposed to be used for
processes that consume a large amount of time. If the activity gets
destroyed, (like rotating the screen) it’ll either crash or memory
that’ll be pointed to that can’t be garbage collected. For this
purpose, an Async task would be perfect.
11) Don’t use the main thread. Duh. Don’t forget your permissions. (I forgot.)
12) I like logging all the time when retrieving data from online. Also
make sure to close your connection and buffered reader. You don’t want
to consume more memory.
13) I forgot to release the media player after the playing the
feedback. Fixed that up. There are some more errors with the media
player, but my audio doesn’t have a "subtitle thing”. This should be a
warning, not an error. Sigh. Besides the “warning” my media player
works fine. Again, didn’t use a service since the audio is just a
matter of seconds.
14) For the list of people, I added that to the overflow menu on the action_bar.
15) There was a way to add rows statically to the table. Check out the
documentation on the developer site:
https://developer.android.com/guide/topics/ui/layout/grid.html. Come
on Google. Why don’t you show the example adding rows dynamically.
Writing all those table rows manually is exhausting. Took me a while
after reading the documentation, but I did it DYNAMICALLY :)
16) Hmm. Let’s make a share action provider. (Idk why, I just felt
like implementing one). It’s been disabled, if you haven’t entered
your name. (Fixes any null values.)
17) Tried my app on a ldpi screen. Realized my people table wasn’t
scrollable. The table cut off half way through. Fixed that up with a
scrollable layout. (I probably need to make my full_name activity
scrollable too. I’ll fix it later. Oh, I forgot. There’s a TODO
command in android, that’ll remind you what you missed. Pretty handy)
18) HERE’S THE BIGGEST THING PEOPLE GET WRONG ABOUT FRAGMENTS. Don’t
ever make direct communication between fragments. It ruins the whole
purpose of creating fragments. If you try to reuse the fragment, it’ll
just break. Make an interface. (Behavior interface). Now get the
instance of the activity from the fragment. Implement the interface in
your main activity. Then access the second fragment. In short:
Communication is Fragment1->Activity->Fragment2. NOT
fragment1->fragment2
19)So for the nexus 7, a lot of space is being wasted. Let’s make
split panes. The pane on the left is a static pane. It doesn’t need to
change on input events. But the screen on the right is dynamic. Since
it’ll change based on the input you feed on the first activity.
20) You need to make a separate screen layout for larger screens. I
used screen width 600, for a multi pane app.
21) Styled my action bar with colors (AGAIN DEFINED IN A VALUES
FOLDER). Used separate styles with API 21 (Material Design) and others
using the support library.
22) Rotating the screen looks okay. As long as your values have ids,
it’ll get restored by your saved instance. (Thank God.)
23) Specify your parent activity to enable the back arrow on your action bar.
24) Going back to async task, the class that extends only requires you
to override the “doinbackground”. I threw in a “onpreexecute” to show
the user the app is busy.
25) Now for testing. How it works. First thing is to fail your test.
Go back to your code and implement it to make it work. Write the next
test. Make it purposely fail. Now go back and implement the code to
make it correct. This is one way to actually develop your code, when
you don’t have a QA. But you can always jump into code if you’re sure
of a QA. Eg. If you were checking a palindrome checking method check
for three cases. 1) Actual palindrome. Eg. Mom, should return a
boolean true. 2) Not a palindrome. Eg. Android, should return a
boolean false. 3) Null string. What happens when the user enters a
null string.
26) Don’t make objects in your UI global in testing. They may interact
with other test cases. It’s a good idea to always “findViewbyId” for
every test case.
27) Instrumentation tests- deals with UI. Unit tests- deal with logic.
You can use the terminal or set up your own test config. I like
setting up test_configs. It’s annoying to view the output file in a
browser when using the terminal.
28) Static variables? Well, it’s pretty cool that you can access them
without a class object. But they aren’t good for memory. Use
sparingly.
29) Fragments. Again, avoid the onclick option in XML. Use implements
for more reusability. If you use onclick, you’re creating a
dependency.
30) Set my uses-minsdk to 16. Checked on devices older than API-16.
Doesn’t install. YAY! App covers >90% of market.
31) Button stays black on image-click (Large Devices). Hmmm.
32) Got it! Reading the documentation, you can monitor your button
press dynamically by defining a separate xml under drawable.
33) Gave a toast message if there’s no internet connection. (People activity)
34) Used getparentactivityintent to restore latest running intent of
MainActivity(Restores values on returning back from people activity)
Documentation notes that you have to use TargetApi for jellybean.
35) Checked on tablets, phones, tv. Seems good. (All emulators).
Watch-UI isn’t great. I’d have to make a separate UI for both the
square and round watches as according to developer documentation. App
being pushed to a wear even though it wasn’t intended for it has been
reported as a bug.
https://code.google.com/p/android/issues/detail?id=80712. I could
limit the device by specifying the limits screen size, but I think
it’s a kind of nasty way to handle the situation.
36) Rotated the device. Values are persisting. Could’ve set it as
portrait. But then I’d feel bad for people with tablets with
landscape.
37) Memory requirement peaks at 10MB on a nexus7 api 23. Garbage
collection is working, with no frequent jumps. Check. No services=less
memory.
38) Deallocated some memory. Noticing .1 increase in memory allocation
on Android rotation. Negligible, plus garbage collection is kicking
in. I’ll avoid calling it. Removed all static instances.
39) The parent activity for both fullnameact and peopleact is the
mainact screen.
40) Cleaning up code with Lint. 1 probable bugs.However there is no
other method invocation of people activity than defined. For this
application, it’s fine.
41) Removed depreciated methods
42) Cleaned up lint errors (The important ones anyways. I’m pointing
at you “Spelling mistakes”).
43) 25 tests are successful. I used logging statements in my people
activity since it uses an async task. Handled any exceptions with
try/catch statements.
44) I noticed the last name on the json file was “Serenity null”. I
avoided adding ‘null' to the table.



Tested Devices:


Nexus 4
Nexus 7
Nexus 9
Nexus 10
Android TV (Can’t Rotate Screen on Emulator, but should work fine)
Nexus S
Nexus One
Unknown LDPI device
