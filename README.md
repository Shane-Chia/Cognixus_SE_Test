# Cognixus_SE_Test

Running the service

As I was using the Spring Framework:

-cd into the demo file. (D:\ ... \ ... \demo)

-Run it with ./gradlew bootRun

Building the service

-Once bootRun is complete, go to your browser(I use Chrome) and simply enter: http://localhost:8080/

Testing the service

-Here are all the commands for the functionality of the To Do List

-http://localhost:8080/

-http://localhost:8080/signin

-http://localhost:8080/signin?name=Charles

-http://localhost:8080/add/Charles/Jogging/Incomplete
 
-http://localhost:8080/remove/id
 
-http://localhost:8080/display

-http://localhost:8080/edit/id/status

Documentation

-A simple greeting to show the user that it is running
   http://localhost:8080/
  
-Signing in (WIthout a Name will default to Anon)
   http://localhost:8080/signin
  
-Signing in With a Name
   http://localhost:8080/signin?name=Charles

-Add a task 
   http://localhost:8080/add/name/desc/status
   
  -name = What you would like to name the new task
  
  -desc = A description of what is the new task
  
  -status = Whether the task is complete or not (You can write anything here to describe if it is half done or pending, etc)

-Remove a task 
   http://localhost:8080/remove/id
   
  -id = Which task in the list you want to delete

-Display a task 
   http://localhost:8080/display

-Edit a task 
   http://localhost:8080/edit/id/status
   
  -id = Which task in the list you want to edit
  
  -status = Whether the task is complete or not (You can write anything here to describe if it is half done or pending, etc)
