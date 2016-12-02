# route_tracker_desktop
Create custom routes of CTA buses and trains. View arrival times for each stop along your route all at once. This a prototype desktop version of the app.

* main() can be found in src/main/controller/

* Most of the heavy lifting is currently handled in the controller, which realistically needs to be split up into smaller controllers/handlers. However, for a quick prototype, the current orginization is good enough to get to a working version of the app. Comments are a little on the rough side at the moment, but should be thorough (and accurate) enough in most of the source to have an idea of what's going on.

* A key for the Bus Tracker and Train Tracker API's is required for requests to work. Keys contained in this public source have been redacted.

* Gson is used for JSON parsing. It is declared as dependency in the Maven POM.

* Testing, what to say... I totally ignored the need for unit testing to this point because I wanted to see how quickly I could build this. Thus, Unit test design is currently in "TODO" limbo.
