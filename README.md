[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/RyiBKJgD)
# Portfolio project IDATA1003
This file uses Mark Down syntax. For more information see [here](https://www.markdownguide.org/basic-syntax/).

STUDENT NAME = "ARPIT SAHOO"  
STUDENT ID = "131809"

## Project description
The purpose of this application is to help the user to have a better overview of food in their fridge
and have the meals they can prepare. This application also supports user to add, remove and find recipes. 
The goal of the application is to reduce food waste. 
## Project structure
```
.
├── main/
│   ├── food/
│   │   ├── FoodItem.java
│   │   └── FridgeStorage.java
│   ├── recipe/
│   │   └── Recipes.java
│   ├── recipebook/
│   │   └── RecipeStorage.java
│   ├── userinterface/
│   │   ├── InputReader.java
│   │   ├── UiPrintHandler.java
│   │   └── UserInterface.java
│   └── FridgeApp
└── test/
├── food/
│   └── FoodItemTest.java
├── fridge/
│   └── FridgeStorageTest.java
├── recipes/
│   └── RecipesTest.java
└── recipebook/
└── RecipeStorageTest.java
```

The project is structured in a simple manner. 
Under the main package, you will find various sub-packages. 
Every class are in their respective packages, 
and all the user interaction classes are in the **userinterface** package.

All the test classes are under the package called **test**.

## Link to repository
This is the link to the git repository:
https://github.com/NTNU-BIDATA-IDATG1003-2024/meal-planning-ArpitSahoo.git

## How to run the project
The FridgeApp serves as the main entry point for the application. 
It initializes the UserInterface, which is placed within a try-block 
to ensure robust error handling. A catch-block is also included to handle any 
exceptions that may occur.

Once the application starts, you will be greeted with a choice screen where '
you can select different commands to execute.

The application will only exit when explicitly commanded to do so.
## How to run the tests

[//]: # (TODO: Describe how to run the tests here.)
It is highly recommended to clean and compile before running tests. 
Click on the Maven button on the top left and select 'test'. 
It will prompt that the tests have passed.
## References
Codes that have been used from websites or ChatGPT, have been referenced as 
a comment in the code. 

[//]: # (TODO: Include references here, if any. For example, if you have used code from the course book, include a reference to the chapter.
Or if you have used code from a website or other source, include a link to the source.)