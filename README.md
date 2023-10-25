# Todo Console App

This is a working solution of a todo console app. is has the complete functionality of a todo app. A user can add new todo, view todos, delete todo, mark todo completed and also clear completed todos.

## Usage

- clone the repo
- open the code with any java IDE of your choice e.g InteliJ IDEA, eclipse e.t.c, 
- compile and run

**_Note: Java has to be installed on your computer before you are able to run the app_**

**_Note: To add a new task to todos just type in the name of the task and press enter_**

## List of Commands

- **`-help`** : list all help commands and their usage
- **`-exit`** : terminate or exit application
- **`show --all`** : list todos
- **`show --active`** : list all active todos
- **`show --completed`** : list all completed todos
- **`remove- <todoID | todoName>`** : removes the todo e.g 'remove- 2' or 'remove- wash plate' deletes the todo from todo list
- **`remove --completed-`** : remove completed todos
- **`remove --all`** : remove all todos
- **`completed- <todoID | todoName>`** : marks the todo completed e.g 'completed- 2' or 'completed- wash plate', marks the todo completed

Watch a sample below

```bash
➜  Todo Console App:(main)
Please Enter your username: kingsley

Welcome kingsley to our Todo Console App with Complete Todo Functionality

These are our lists of Commands and their Usage: 

-help                	list all commands and their usage
-exit                	terminate todo application in terminal
show --all           	list all todos
show --active        	list all active todos
show --completed     	list all completed todos
remove- <todoID | todoName> 	removes the todo e.g 'remove- 2' or 'remove- wash plate' deletes the todo from todo list
remove --all         	remove all  todos
remove --completed   	clear all completed todos
completed- <todoID | todoName> 	marks the todo completed e.g 'completed- 2' or 'completed- wash plate', marks the todo completed

Please enter a list item to add or a command to perform: wash play
Todo added successfully

Please enter a list item to add or a command to perform: watch movie
Todo added successfully

Please enter a list item to add or a command to perform: play football
Todo added successfully

Please enter a list item to add or a command to perform: show --all

***********************************************TODO LIST************************************************

S/N       	 ID             	 TASK                                              	 STATUS

1         	 433            	 WASH PLAY                                         	 ACTIVE

2         	 395            	 WATCH MOVIE                                       	 ACTIVE

3         	 164            	 PLAY FOOTBALL                                     	 ACTIVE

********************************************************************************************************

Please enter a list item to add or a command to perform: completed- 433
todo marked completed
Please enter a list item to add or a command to perform: show --all

***********************************************TODO LIST************************************************

S/N       	 ID             	 TASK                                              	 STATUS

1         	 433            	 WASH PLAY                                         	 COMPLETED

2         	 395            	 WATCH MOVIE                                       	 ACTIVE

3         	 164            	 PLAY FOOTBALL                                     	 ACTIVE

*******************************************************************************************************

Please enter a list item to add or a command to perform: show --completed

***********************************************TODO LIST**********************************************

S/N       	 ID             	 TASK                                              	 STATUS

1         	 433            	 WASH PLAY                                         	 COMPLETED

*******************************************************************************************************

Please enter a list item to add or a command to perform: show --active

***********************************************TODO LIST**********************************************

S/N       	 ID             	 TASK                                              	 STATUS

1         	 395            	 WATCH MOVIE                                       	 ACTIVE

2         	 164            	 PLAY FOOTBALL                                     	 ACTIVE

*******************************************************************************************************

Please enter a list item to add or a command to perform: remove- 433
todo removed successfully
Please enter a list item to add or a command to perform: show --all

***********************************************TODO LIST**********************************************



S/N       	 ID             	 TASK                                              	 STATUS

1         	 395            	 WATCH MOVIE                                       	 ACTIVE

2         	 164            	 PLAY FOOTBALL                                     	 ACTIVE

*******************************************************************************************************

Please enter a list item to add or a command to perform: remove- completed
Invalid todo id or name provided
Please enter a list item to add or a command to perform: remove --completed
Please enter a list item to add or a command to perform: show --all

***********************************************TODO LIST**********************************************

S/N       	 ID             	 TASK                                              	 STATUS

1         	 395            	 WATCH MOVIE                                       	 ACTIVE

2         	 164            	 PLAY FOOTBALL                                     	 ACTIVE

*******************************************************************************************************

```
