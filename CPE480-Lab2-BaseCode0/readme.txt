/***********************\
* BotEnvironment README *
* Matt Colon            *
\***********************/

*********************************************************
* Version History
*********************************************************

v1.2.10
- Cleaned up "WumpusAgent" by removing old belief getters
  and setters.
- Put "MyAgent3.class" in "Agents" as an example of a
  (poor) Wumpus agent.

v1.2.9
- Added new methods to move, get and set beliefs, and
  fire arrows
- Added new methods to get the heuristics and directions
  of adjacent nodes.
- moveForward() now returns GOLD_FOUND if the agent moves
  onto the node with the gold.

v1.2.8
- Initial release of the Wumpus World version of the Bot
  Environment.

v1.2.7
- Fixed a bug that would not open a map if the width was
  greater than the height.

v1.2.6
- Added the management of node costs in the movement cost.

v1.2.5
- Added a command-line startup.  Additional arguments are
  as follows:

    - agent_name.class : The agent to load
    - map_name.sbm     : The map file to load
    - delay            : The integer delay value to load

  Usage is the following (all one line):

  java -cp .;BotEnvironment.jar; BotEnvironment.BotEnvironment
  agent_name.class map_name.sbm delay

- Added a developer name to the agent.  The developer name
  will be displayed on the Map windows.
- Allowed agents to be in one subdirectory of the "Agents"
  directory.  For example, Joe Smith can put his agent and
  all the files that the agent uses in "Agents/jsmith".  Just
  be sure to set the package to the same directory.

v1.2.4
- Now when a new agent is chosen, the delay resets itself
  correctly.
- Added a "Quick Start" choice to choose an agent and
  start immediately with SearchMap

v1.2.3
- Fixed a "NullPointerException" that occurred if
  getFringeString() was called on an empty fringe.
- Changed the starting Agent directory to open in the
  "Agents" directory.
- Changed the starting map directory to open in the "Maps"
  directory.

v1.2.2
- Allowed the program to be run either maximized or not.

v1.2.1
- Fixed a bug that let agents move through walls.

v1.2

- Fixed a bug where the map does not respond if a new
  session is started.
- Fixed a bug where the agent does not respond if a new
  map is opened while the bot is auto-stepping.
- The agent log now clears when a map is closed or reset.
- Now when an agent is chosen at the start of a session,
  the class file is chosen instead of the Java file.
- NOTE: A bug was discovered where the agent does not
        respond if the delay is set to zero, auto-stepping
        is on, and a new map is opened.  It is probably
        because of threading issues, but for now, users
        should stop the agent or set the delay to a higher
        value than zero before opening a new map.

v1.1

- Added buttons for stepping, auto-stepping and stopping.
- Added a bar to change the delay between agent steps.
- Embedded the agent log into the GUI rather than having
  it be a window, and subsequently removed the log toggle
  from the View menu.
- Added the option to save the agent log.
- Changed the map legend to not appear when a map is opened.

v1.0

- Initial release.

*********************************************************
* Usage Instructions
*********************************************************

Extract BotEnvironment.zip to some directory.  From
the command prompt, go to the directory the zip file was
extracted to and type (for DOS):

java -classpath WumpusEnvironment.jar;.; BotEnvironment.WumpusEnvironment

When the program is running, choose File->New WUmpus Environment Session
From here, choose an agent from the Agents directory (in this case,
MyAgent).  You can load a map by choosing Map->Open Map, then choosing
a map from the "testmaps" directory.  To choose which search to run
and to start traversing the map, use the Bot Menu.

There are two maps that are loaded when a map is chosen; one is
the global map, showing everything, and the other is the agent
map, showing only what the agent has seen.  Also, a legend is
available as well as a window showing what the bot has logged.

*NOTE* Since this program is still under construction, you will
need to manually move the windows around until they are visible.

*********************************************************
* Programming Instructions
*********************************************************

Important methods to consider when making your own agent are
as follows:

        getBotLocation():     Returns the Node where the agent is.
        moveForward():        Moves the agent one tile forward in
                              the current direction it is facing.
        turnLeft():           Turns the agent 90 degrees left from
                              the current direction it is facing.
        turnRight():          Turns the agent 90 degrees right from
                              the current direction it is facing.
        turnTo(int):          Turns the agent to the direction given
                              (the integer values for direction are
                              defined in the SBConstants class).
        log(String):          Prints the string in the logging window.
        step():               Each time tick, the agent performs
                              actions as defined in this method.

For further programming instructions, review the online tutorial.

*********************************************************
* Contact
*********************************************************

For questions, suggestions, or more information, email Matt Colon
at mcolon@calpoly.edu