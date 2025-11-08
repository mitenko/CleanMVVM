### Clean MVVM Project

## This is a simple project to highlight familiarity with the following:
- Kotlin
- MVVM Architecture
- Jetpack Compose
- Dagger / Hilt

# The project is divided into three MVVM / Clean Architecture Layers
* Presentation Layer: For UI Elements 
    * packages for each screen
    * ui package for shared UI elements / theme
* Domain Layer: Data Models, Repository Definitions (interfaces), Business Logic 
    * model 
    * repository: contains the *interface definition* for the repositories
    * use_case
* Data: All data sources are contained here
    * repository
    * remote
        * dto : Data Transfer Object - the full data pulled from the API 
    
####- Data Layer: Contains the Data, Databases and / or API interface

