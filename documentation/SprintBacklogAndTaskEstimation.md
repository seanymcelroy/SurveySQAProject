# Sprint Backlog + Task Estimation

Having already created a use case diagram and class diagram, we are ready to move onto the sprint backlog.

Sprint Backlog is a Scrum Artifact

### Background on Scrum

Scrum is an agile framework used for developing and delivering software in short periods of time.
These short periods of time are called sprints, generally a 2 week period that starts with a **Sprint plan** and ends with shippable code.

### Sprint Backlog

A **Sprint Backlog** is a Scrum artifact.
It contains

- User Stories (informal description of a feature to be available)
- Tasks. Within the user stories we have tasks that need be **done** to complete user story
  - These Tasks are a subset of product backlog(list of all tasks) to be completed within a given sprint.

The Sprint backlog is designed to be mutable so tasks can be added or updated if need be.
This is one of the ways that scrum supports agile development.

---

### Sprint Backlog Categories

The Sprint Backlog/Sprint board can be broken down into 3 categories

1. To-Do
   - Tasks that have to be started
2. In-Progress
   - Tasks that a developer has begun working on but are not complete
3. Done
   - This can be misconstrued. It means the task has been tested and passed and is completely ready for merging into release branch.

The way i have decided to track development progress is known as the white board method.

Where the user stories and tasks are put on white board in the different sections. (Bedroom wall in my case)

Other options include project management tools like Jira and Github Project Management that are web based tools.

The whiteboard method provides clarity and tangibility, as well as a reminder of the overall goal.

---

<p align="center">
<img src="images/SprintBacklogAtBeginning.jpg" alt="Sprint backlog at beginning" width="900">
</p>

---

---

### Prioritization

Prioritization is the process of ensuring the most essential functionality gets done first. The process becomes more difficult the larger the list of tasks becomes.
A methodoly i decided to use when prioritizing the functionality a.k.a my user stories was the **"MoSCoW Rules"**

### MoSCoW Rules

- Must Have.

  - User stories that are part of core functionality. Essential.
  - (**Create Survey**, **Respond to Survey**).

- Should Have

  - These feauture are not part of core functionality but equally important.
  - (**View Survey**).

- Could Have

  - Not core or necessary but would benefit the feature.
    - (A not so important part of View Survey story is **"survey statistics"**).

- Won't Have
  - Most likely will not have time to implement, but potentially in a later sprint.
  - (E.g A user interface feature for survey project).

From the board my prioritization works from top to bottom. Highest physically on board is highest priority

---

### Task Estimation/Sizing

### T-shirt Sizing

I'm using T-shirt size method. I believe this is the most straight - forward method of task estimation for new developers and people on the business side.

It's based on sizes of t-shirts (surprisingly).

Generally T-shirts come in small, medium, large and extra large.

Making estimates based on T-shirt sizes, allows the process to go much quicker than the traditional **Fibonacci sequence** estimation.
The Fibonacci sequence. Each number is a sum of the two preceding numbers in the sequence. 1,2,3,5,8.

The sizing in terms of time/hours depends on the project scope (size of project).

In our small survey project.
My sizing translates to.

- S - predicting < 1
- M - predicting between 1 & 3 hours
- L - Anything predicted to take more than 3 hours

---

<p align="center">
<img src="images/SmallTask.jpg" alt="Image of Individual task small" width="300">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="images/MediumTask.jpg" alt="Image of Individual task medium" width="300">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="images/LargeTask.jpg" alt="Image of Individual task Large" width="300">

</p>

---

---

### My Sizing

Here are examples of some of my task estimations, Left I have a task marked 'S' = small. Right I have task marked 'M'= medium. Bottom I have a task marked 'L' = large.

- Small

  - (View All Surveys) I believe this task is relatively straightforward as have a lot of experience iterating through collections and some collections have a retrieve all function built in. Small amount of time needed.

- Medium

  - (Find Survey By Name) This task is similar to first as it involves going through a list but must find and retrieve a particular Survey. Should be manageable and completed within a few hours. Thus i marked this task as Medium.

- Large

  - (View Survey Statistics) Statistical calculations is something i have little experience with, so the **doubt factor** increases the time i believe this will take. This is one of the more trickier tasks of the project thus estimating it's sizing Large.

---

### Velocity

- The velocity metric is used to determine the size of the entire sprint.

- To calculate the velocity of a sprint, you must add up all the story points for each individual task.

- In our case with using T-shirt sizing estimation we will say

  - Small = 1 hour
  - Medium = 2 hours
  - Large = 5 hours

- Velocity of Survey Project. (Story points for one task multiplied by number of tasks)

  - Small x 2 = 2
  - Medium x 4 = 8
  - Large x 4 = 20

- The total velocity for our sprint will be **30 hours**.

- If i were to use a burndown chart i could accurate predict my completion time.

#### Burndown Chart

- Graphical representation of work left to do in a sprint.
- y axis displays story points.
- x axis displays time.
- With a burndown chart we can predict likelihood of completing work in the time available.
- The Closer to a gradual decrease of story points the better. 1:1 ratio with time.
- If your development is far off (in either direction), you need to change estimation for next sprint.

---

---

## Quick Links

- [Readme](../README.md)
- [UML Modelling](UMLModelling.md)
- [Unit Testing And Test Driven Development](UnitTestingAndTestDrivenDevelopment.md)
- [Code coverage](CodeCoverage.md)
- [Team Version Control](TeamVersionControl.md)
- [Code Review Checklist](CodeReviewChecklist.md)
