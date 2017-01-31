# route_tracker_desktop
Create custom routes of CTA buses and trains. View arrival times for each stop along your route all at once. This a prototype desktop version of the app.

This is a prototype. Critical elements such as testing, production quality orginization of the codebase, and thorough commenting was deprioritized in the name of getting this prototype built as quikcly as possible. The danger of this less than stellar version becoming the foundation of the project is somewhat alleviated by creating the prototype for desktop instead of as a proper android application. Care will still need to be taken in the future to not end up with undesirable artifacts from this rushed version in the proper android implementation.

* main() can be found in src/main/controller/

* Most of the heavy lifting is currently handled in the controller, which realistically needs to be split up into smaller controllers/handlers. However, for a quick prototype, the current orginization is good enough to get to a working version of the app. Comments are a little on the rough side at the moment, but should be thorough (and accurate) enough in most of the source to have an idea of what's going on.

* Keys for the Bus Tracker and Train Tracker APIs are required for requests to work. Keys contained in this public source have been redacted.

* Gson is used for JSON parsing. It is declared as dependency in the Maven POM.

* Testing, what to say... I opted to forgo unit testing for the sake of building out this prototype as quickly as possible. Robustness was not the goal in this case. This was more an exercise in getting familiar with the endpoints of the CTA's API and getting a general sense for general flow of the application.
