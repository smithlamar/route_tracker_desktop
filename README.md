# route_tracker_desktop
Create custom routes of CTA buses and trains. View arrival times for each stop along the routes all at once. This a prototype desktop version of the app.

* main() can be found in src/main/controller/

* Most of the work is currently done in the controller, which realistically needs to be split up into smaller controllers. However, for a quick prototype, the current orginization is good enough to get to a working version of the app. Comments are a little on the rough side at the moment, but should be thorough (and accurate) enough in most of the source to have an idea of what's going on.

* Gson is used for JSON parsing. It is declared as dependency in the Maven POM.

* Testing, what to say... I totally ignored the need for unit testing to this point because I wanted to see how quickly I could build this. Thus, Unit test design is currently in "TODO" limbo.
