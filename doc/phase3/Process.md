#process
##Roles:
###Scrum Master: Asher
* Asher has served as the de facto scrum master in phase 2. The role automatically went to him again for phase 3, as we can't imagine anyone else doing the job as well.
* As Scrum Master, Asher regularly performed maintenance on github issues, resolved conflicts when they arose and led meetings.
* Shirley has attempted to assist this role by taking notes and actively creating github issues for tasks planned throughout the meetings
* Shirley has also attempted (sometimes unsuccessfully) to schedule in-person meetings. Due to busy schedules, most of our communication happened online through Slack, our online collaboration tool

##Utilizing the Github Repository and Travis
With a team as large as 6 people, the resulting frequency and complexity of merge conflicts and errors are headache inducing. We came up with a good solution for this problem: branching, rebasing and merging. The idea is that we work on our separate branches, and when we're ready to propagate changes to master, we pull and rebase master to our own branch: which applies our changes on top of the most recent commits in master. If this results in conflicts or Travis failing, then we resolve them and make sure that our branch is error/conflict free before merging it with master. Travis was crutial to our team because we each developed on various IDE's and different Operating Systems. As a result, code that would work in Windows and would pass all test cases on Windows could break Mac functionality. In the specific case of serialization of the application, we had issues which only occured because the Travis environment was setup differently from our own. [link] (https://github.com/csc301-fall-2015/project-team9-L5101/commit/68253704a6b5a68f1905cd0a7ab234b2eccb0862). Travis guaranteed that we had a baseline for a passing build and it was referenced multiple times throughout our development cycle.

##Meetings and Planning
We tried to hold meetings on a weekly basis. An example of our meeting minutes is included in the folder.
Originally we intended to split the group into 3 pairs, with each pair working together on a part of the project. However, this never came to fruition and instead had everyone work on a piece of the project, with one pairing working closely together for more advanced issues. 
Once again we experienced the same difficulty during the previous phase, where we had trouble maintaining communication and finding organization as the pieces faced difficulty nearing the end of the sprint pertaining to completion and overall direction of the piece.
I find that on the occasion that we were able to meet in person, we were highly productive. During face-to-face meetings, there'd no lag in communication and any issue or difficulty faced by weaker programmers can immediately be resolved by members with higher expertise.
 
 
* During our first full meeting this sprint, the first thing that was discussed was the state of the current project, where we wanted it to go, and how to get there. We had discussed what needed to be added to the different classes and the need for a GUI for people not comfortable working at a command line.
	* we prioritized tasks based on how crucial it is towards the MVP, deliverables, and overall vision for the project.
	* we separated tasks into low-priority and high-priority
		* Low-priority tasks: these were usually features that were "nice to have" such as deleting experiments and moving resources around. They did not impact the success of the project directly but provided benefit to the user and the sanity of developers. [link to low priority tasks](https://github.com/csc301-fall-2015/project-team9-L5101/issues?utf8=%E2%9C%93&q=is%3Aissue+label%3A%22priority+-+low%22+)
		* High-priority tasks: These were issues that directly impacted the vision for the project. They included restructuring entire classes to provide a clearer implementation and class responsibilities to implementing features in the GUI and linking them with the relevant code in the back end. [link to high priority tasks](https://github.com/csc301-fall-2015/project-team9-L5101/issues?page=1&q=is%3Aissue+label%3A%22priority+-+high%22&utf8=%E2%9C%93)
		* Nearing the end of the sprint, high priority tasks were then filtered into an even more crutial task grouping called "critical". This came during a decision during a meeting to take what we have, and produce a viable demo with it. A run through was done with the current code and notes were taken in the form of new issues pertaining to the work-flow during the demo. The tasks were then split evenly amoung the group members to complete. [link to critical priority tasks] (https://github.com/csc301-fall-2015/project-team9-L5101/issues?utf8=%E2%9C%93&q=is%3Aissue+label%3A%22critical%22+)
	* In addition to priorities, tasks were given a size. Sizes of tasks were determined by an estimation of the amount of work it would take to bring a task to a closed and completed state. Some indicators which contributed to this were: estimated amount of code, estimated amount of classes modified, and overall difficulty in understanding what needed to be completed.
		* [size-S](https://github.com/csc301-fall-2015/project-team9-L5101/labels/Size%20-%20S) usually only impacted a single class and were no more than implementing a new function or refactor of some kind
		* [size-M](https://github.com/csc301-fall-2015/project-team9-L5101/labels/Size%20-%20M) impacted multiple classes or required a larger amount of problem solving to complete. These were usually done by one person with occasional assistance from other members of the group. Moving from a saved text file as a result to a result object being passed is an example of this.
		* [size-L](https://github.com/csc301-fall-2015/project-team9-L5101/labels/Size%20-%20L) these issues required cooperation and collaboration from multiple people to complete and were usually described as an overhaul of classes. Refactoring and changing functionality over the course of multiple classes with related research also fell into this category. These tasks were more likely to be done in person during meetings where collaboration is quickest and most efficient.

##Burn Down Charts



	
