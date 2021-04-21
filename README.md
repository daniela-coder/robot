# Robot Implementation
Solution design: When I read the task description I visulized the robot movement on a matrix with rows and columns. Then I decided to use a concept of robot state that contains the position as a couple of (row, column) and the direction the robot looks at. Executing a line from the script (that I mapped as an event) means to build a new robot state with correct position and direction calculate from current robot state and applying the calculation of the specific executed event.

Important: I decided that if an event execution is bringing the robot outside of the grid boundaries, the robot just doesn't move... it behaves the same as for the Wait Event.

Implemented: 
 * controller to provide the endpoint to the frontend to create the script
 * the robot controlling script parsing to build the list of Event to execute
 * movement business logic 
 * grid boundary checks
 * exception handling.


To improve:
 * add more tests for each component 
 * extends the controller advice for other possile exception
 * some architecture diagram of the solutioh.
