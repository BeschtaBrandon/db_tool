<head>
<title>README.md</title>
</head>
<body style="padding-left: 15px;">
<h2>AutoDbService</h2>
<p>AutoDbService is a Java SpringBoot application that drives the database migration process.<br>
It reads the migration scripts from AutoDbSchema and drives Flyway to perform the migration.</p>

<h4>What you'll need</h4>
<ul>
  <li>Eclipse, IntelliJ, or Visual Studio (IntelliJ instructions can be found at <a href="https://thehub.thomsonreuters.com/docs/DOC-1601762">https://thehub.thomsonreuters.com/docs/DOC-1601762</a></li>
  <li>Gradle</li>
  <li>Gradle plugin for Eclipse</li>
  <li>Git: <a href="https://git-scm.com/">https://git-scm.com/</a></li>
</ul>

<h4>Install Gradle</h4>
<p>This is a good guide to installing gradle on windows. <a href="http://www.javacodegeeks.com/2013/04/how-to-install-gradle-2.html">http://www.javacodegeeks.com/2013/04/how-to-install-gradle-2.html</a>

Note that if you are using cygwin, you can install gradle by running the cygwin setup.</p>

<h4>Clone the repo</h4>
<p>Assuming you have configured your git credentials, open the command prompt and navigate to your workspace directory, then run the following command</p>
<div class="panel panel-default">
  <div class="panel-body">
  `git clone https://git.sami.int.thomsonreuters.com/platformcm/AutoDbService.git`
  </div>
</div>


<h4>Install the gradle eclipse plugin</h4>
<p> You can do this by clicking on Help -> Eclipse Market Place and search for 'Gradle'</p>

<h4>Eclipse Project Setup</h4>

<p>Go to File -> Import -> Gradle Project. Click browse and locate the folder where
you cloned the repo to. Click 'build model'. Once this is complete, you can click
finish and you'll have the project.</p>

<h4><span class="glyphicon glyphicon-play" aria-hidden="true"></span>Building and Running the application</h4>
<h5><b>To run as web application</b></h5>
<p>Go to the root directory of the project in the command prompt, enter `gradle build` then run `java -jar build/libs/AutoDbService.jar`</p>

<h5><b>To run as a standalone command-line application</b></h5>
<p>Go to the root directory of the project in the command prompt, enter `gradle build -DapplicationProperties="{path/to/database/connection/info}"` then run `java -DapplicationProperties="{path/to/database/connection/info}" -DdbMacro="{macro} -jar {path/to/}AutoDbService.jar --schema flywayScript={path/to/flyway/scripts}`</p>
<p><b>Please note, you must provide a command-line argument for database connection information located in a resources directory before running a gradle task. For instance, to run flyway clean do the following: <br>'gradle flywayClean -DapplicationProperties="{path/to/database/connection/info} -DdbMacro="{macro}'</b></p>
</body>