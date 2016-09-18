# ViaPlay-TrailerService
Provide clients with Trailer URL for a provided ViaPlay movie resource link.

Step 1 : 
Download the API files :
Extract the attached files to your desktop, from the following link.
Download zip from https://github.com/divya005/ViaPlay-TrailerAPI

Step 2 :
Gradle Installation :
https://gradle.org/getting-started-gradle-java/
Download gradle from the above link and install the same. Please add the path and environmental variables to the PC.
Refer to the youtube video for configuring the path and environmental variable :
https://www.youtube.com/watch?v=kAIqcPwGo_w

Step 3:
Starting the application by running gradle :
* Open command prompt and navigate to the path where you download the file.
* Build the API using the command gradle build.
* Run the application by the command gradle run.
The application starts

Step 4:
open any browser and run the API along with the request movie URL.
Sample URL
http://localhost:7002/trailer?content-url=http://content.viaplay.se/pc-se/film/fight-club-1999
The result will be the name of the youtube tralier and its path.
