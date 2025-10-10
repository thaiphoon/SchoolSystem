# SchoolSystem UML Diagrams

This directory contains a complete set of UML diagrams for the **SchoolSystem** Java project (Sprint 1).
All diagrams use the PlantUML syntax with `!pragma layout smetana` for clean layouts.

---

## 📋 Diagram Overview

| File | Type | Description |
|------|------|--------------|
| **01_SystemContext.puml** | System Context | Shows external actors (Student, Teacher, Administrator) interacting with the SchoolSystem console application. Illustrates JSON persistence and data flow. |
| **02_ComponentOverview.puml** | Component / Package Diagram | Displays how the application is organized into packages — UI menus, domain model, input handling, and data/persistence. |
| **03_ClassDiagram.puml** | Class Diagram | Visualizes main classes: `Person`, `Student`, `Teacher`, `Administrator`, `Course`, `Grade`, `PendingGrade`, `LetterGrade`, and their relationships. |
| **04_Sequence_Startup.puml** | Sequence Diagram | Describes the startup sequence: loading JSON data and initializing menus. |
| **05_Sequence_EnrollCourse.puml** | Sequence Diagram | Demonstrates how a student enrolls in a course, resulting in a `PendingGrade` being added. |
| **06_Sequence_AssignGrade.puml** | Sequence Diagram | Shows the teacher workflow to assign a grade (creating a new `LetterGrade`). |
| **07_Activity_AssignGrade.puml** | Activity Diagram | Outlines the logic flow for assigning a grade, including validation and error handling. |
| **08_State_GradeLifecycle.puml** | State Diagram | Depicts the lifecycle of a grade from `Pending` to `Lettered` to `Revised`. |

---

## 🧭 Suggested Presentation Flow

1. **System Context** – Overview of actors and data flow  
2. **Component Overview** – Layered architecture  
3. **Class Diagram** – Core structure and inheritance  
4. **Sequence (Startup)** – System initialization  
5. **Sequence (Enroll)** – Student enrolling flow  
6. **Sequence (Assign Grade)** – Teacher grading flow  
7. **Activity Diagram** – Detailed grading logic  
8. **State Diagram** – Grade lifecycle

---

## 🛠️ Usage

You can render these `.puml` files directly in:
- **IntelliJ IDEA** with the *PlantUML Integration* plugin  
- **VS Code** with *PlantUML* extension  
- Or online at [PlantText](https://www.planttext.com/)

Each file starts with `!pragma layout smetana` for a simplified and tidy layout suitable for documentation and slide decks.

---

*Author: Generated automatically for the SchoolSystem study project demo.*
