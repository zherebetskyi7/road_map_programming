Download and Install JAVA 1.8.*
https://java.com/en/download/help/download_options.xml

check java version in console:  "java -version"
check javac version in console: "javac -version"

Download and Install Maven
https://maven.apache.org/download.cgi
https://maven.apache.org/install.html

check mvn version in console:   "mvn -version"

Clone this project, enter to this project from console and run from console:

mvn clean install

mvn exec:java -Dexec.mainClass="runProgramFromJson.JsonMain"              if you want run tasks from json
mvn exec:java -Dexec.mainClass="enterDataFromConsole.mainPackage.Main"    if you want type data to console

All Json files with input data are in src/main/java/runProgramFromJson folder

For tasks 11, 12, 13 !!!
All data from this task will upload to src/results_twitter (11 task), src/results_images (12 task), src/results_pdf (13 task)
For 13n task will create pdf only with html code (Later will improve this task and will add pictures)


