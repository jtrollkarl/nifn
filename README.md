# nifn
my solution fills all the requirements for this task. to sort different items there are 3 icons on the menu bar. refresh icon to pull all items from web. filled favourite icon to show only favourites and outlined favourite icon to show all items minus favourites (from web). you can also click on the favourite icon to add/remove it from favourites. I took an MVVM architecture path and used livedata/viewmodel (jetpack) to help achieve this. I believe my solution is quite clean and concerns are well separated. ḧere's a list of libraries and why I used them.

Room:
for database/mysql abstraction

Timber:
for logging

rxjava3:
reactive programming/multithreading

dagger2:
dependency management/graphing

retrofit2:
web api

moshi:
json parsing

glide:
image loading

note: on some images I receive an error 503 response both in glide and my own browser. not sure if this was intentional.

with more time I would have maybe added a way to wrap api responses in a generic wrapper class that'd return either something such as SUCCESS or ERROR to better handle success/error calls in ui classes (also make errors visible to user rather just in logcat). also perhaps a temporary image for ads with missing/unloadable image urls.
