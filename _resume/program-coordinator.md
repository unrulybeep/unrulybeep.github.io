---
layout: post
company: Paul G. Allen School of Computer Science and Engineering at University of Washington
location: Seattle, WA, USA
title: Program Coordinator
started: 2019
duration: July 2019 - Present
ended: Present
description: The Program Coordinator – Student Advising position provides general coordination and reception duties for the Allen School Graduate Advising Team.
collection: resume
type: employment
---

Additional duties will include special event planning and general administrative/clerical support to the department. This position will report to the Director of Graduate Student Services.

·	Student service-focused by independently advising prospective and current students
o	Prospective students are counseled on the admissions process from beginning to acceptance/rejection by interpreting and applying Graduate School and Allen School admission policies and requirements
o	Current students are advised from admittance to degree completion by interpreting, maintaining, and communicating the policies and regulations of the University of Washington, Federal and local laws, and those of the Allen School
o	Current students outside the major who are interested in taking Allen School courses are advsised on non-major enrollment policies and assisted through the process as needed
	Includes collaborating with other departments to ensure shared resources (seating, teaching assistance, etc.,) are maintained and available as expected
·	Data entry using Google Sheets, Microsoft Excel, and homebrew web applications offered by the University of Washington and Paul G. Allen School
·	Events program manager for student-led events such as Women’s Research Day, LGBTQ+ reception at Allen School Visit Days, and , as well as the Allen School Graduate program events
o	 New Student Orientation, New Student “Pit Party” (welcome event for newly admitted graduate students), Allen School Visit Days (in collaboration with team),
·	Utilize School and University technological tools to keep students on track with the admission process, degree pathway requirements, satisfactory course progress, and other administrative tasks and procedures
·	Required an understanding of University, School, and other stakeholder policies and communicating these policies to others while also assisting and explaining the technical tools used to facilitate these processes and policies.
·	Homebrew digital software/databases: MyGrad Program (UW), Electronic Academic Records System (UW), Keynes/Student Database (UW),
·	Third-party digital software/databases: Google Workspace (Gmail, Drive, Sheet, Docs, Doodle, Sites, Calendar), Google App Script, Drupal, Github/Gitlab, DocuSign, Handshake, Canvas LMS, BI Portal, Trello, Microsoft Suite (Word, Excel, Teams, Sharepoint, Outlook, Flow, Forms), Adobe Photoshop, and Avery online label designer.

## Frontend Design
### Allen School Ph.D. Admissions
- [Current Ph.D. Admissions Webpage](https://www.cs.washington.edu/academics/phd/admissions)
  - I wrote and designed the “Admissions Highlights” block.
  - [Wayback Machine (08/2019)](https://web.archive.org/web/20190826223420/www.cs.washington.edu/academics/phd/admissions) from just after I was hired for this position.
- [Current Ph.D. Required Materials Webpage](https://www.cs.washington.edu/academics/phd/admissions/required-materials)
  - [Wayback Machine (01/2019)](https://web.archive.org/web/20190107083907/https:/www.cs.washington.edu/academics/phd/admissions/required-materials)
![Google Drawing of Graduate Program Admissions Process](/images/admissions-mockup.svg)
- [GitLab Repository of Public webpages for Ph.D. program](https://gitlab.cs.washington.edu/ellean/phd-public)
  - I maintain the repository, and currently I am the only team member who knows HTML/CSS and how to use Git.
### Allen School Advising Info & Contact info
- https://www.cs.washington.edu/academics/phd/advising
  - [Wayback Machine (07/2019)](https://web.archive.org/web/20190702080054/https:/www.cs.washington.edu/academics/phd/advising)
### Allen School New Graduate Orientation calendar
- https://www.cs.washington.edu/students/newgrad/orientation
  - ![Wayback Machine didn’t crawl this site](/images/orig-orientation.png)
### Allen School Space Request Internal Tool
![Google Drawing of Space Request Internal Tool Updates](/images/space-request.svg)
  - [Milestone Deadline Extensions Form (PDF)]("assets/samples/exam-deadline-extension-petition.pdf"): I used Adobe Acrobat to create this form. This form is loosely based on [this form](). The Ph.D. program has set timeframe deadlines for milestones to be completed, and this form is used to record the student's need for an extension. The form asks for the student, advisor, and a graduate advising staff member to sign. The team processes about 6 or 7 of these every academic quarter. Prior to the creation of this form, the students were asked to have a conversation with their advisor and then to contact graduate advising by email. There was a need for there to be documentation regarding this process, in order to provide data to the faculty when they are reviewing the degree program's time-to-completion and student satisfaction. The signature process is handled via DocuSign. I created a Powerform so that student could initiate the form themselves. The form is sent first to the student, then to the student's advisor(s), and finally to the graduate advising team to file in the student's record.

  Graduate Advising Email Templates Webapp
  •	Currently under development with Supervisor oversight
  •	[Google App Script Project Link](https://script.google.com/d/1rP2x-6Y90S4CE0Vr7EgWua3p5i-bwGeLgv96hszF-p7rVfDxdJcjmF-F/edit?usp=sharing)
  Program Coordinator Automation Hub
  •	Google Sheet project that includes:
  o	Mail Merge
  o	Script to generate two columns from spreadsheet data (screenshot below)
  o	Formulas for calculating reported internship salaries from graduate students



`This document is written as an .html file because GAS doesn't allow for any other types. README.md
is a convention of documentation, so it is being used here. This README covers the formulas in the
GSheet, and has appendix information regarding the scripts.

Project Authors: Emma Gebben, CJ Smith, Elle Brown, copyright 2021

scripting.gs - scripts that can access files outside the document
bound.gs - functions that are bound to the document
GMExtensions - Another Apps Script project, by Elle Brown, that is tied to the GMS form

Forumlas are in row 2 of columns that have a grey background color.  The iferror is used because
VLOOKUP returns an error if the column D value is not found. In some instances the use of iferror
is asthetic, and others it is required for the formula to function. Arrayformula is so ranges can
be used as opposed to needing to put a formula on every line.


Cell C
===============
arrayformula(iferror(IFERROR(VLOOKUP(D2:D200,FallResponses!B2:C204,2,false),
VLOOKUP(D2:D200,ManualResponses!B2:F200,5,false)), ""))

The cell C formula compares the column D value to the value on the corresponding row on the
FallResponses tab, and if a match is found returns the value in column F (index 5).
---------------
Cell F
===============
arrayformula(iferror(IFERROR(VLOOKUP(D2:D200,FallResponses!B2:E200,4,false),
VLOOKUP(D2:D200,ManualResponses!B2:C200,2, false)), " "))

The cell F formula compares the column D value to the value on the corresponding row on the
FallResponses tab, and if a match is found returns the value in column C (index 2).
---------------
Cell G
===============
arrayformula(iferror(if(match(D2:D200, FallResponses!B2:B204, 0) > 0, TRUE, FALSE), FALSE))

The cell G formula checks for a match between column D values and FallResponses column B values,
and if it is greater than 0 it will return TRUE, and if there is no match it will return
FALSE. Column G is a checkbox.
---------------
Cell H
===============
iferror(arrayformula(IFERROR(IFS(not(isblank(vlookup(D2:D200,FallResponses!B2:H200,7,false))),
vlookup(D2:D200,FallResponses!B2:H200,7,false),not(isblank(vlookup(D2:D200,FallResponses!B2:M200,12,false))),
vlookup(D2:D200,FallResponses!B2:M200,12,false),not(isblank(vlookup(D2:D200,FallResponses!B2:W200,22,false))),
vlookup(D2:D200,FallResponses!B0:W204,22,false), not(isblank(D2:D200)), "Can't come in"),
VLOOKUP(D2:D200,ManualResponses!B2:H200,7, false))), " ")

Most of the IFERRORR and IFNA functions are needs for this formula to evaluate.

The cell H formula compares the column D value to the value on the corresponding row on the
FallResponses tab, and if it is not blank returns column H (index 7). If index 7 is blank, then
column M is returned (index 12). If index 12 is blank then column W (index 22) is returned. If
column D is not blank, "Can't come in" is returned. If any of those return an error, then column
H (index 7) is returned. If an error occurs then a blank is returned, so that the error
isn't displayed.
---------------
Cell K
===============
ARRAYFORMULA(IFS(not(isblank(IFNA(VLOOKUP(D2:D200,FallResponses!B2:I200,8,false),))),
VLOOKUP(D2:D200,FallResponses!B2:I200,8,false),not(isblank(IFNA(vlookup(D2:D200,FallResponses!B2:N200,13,false),))),
VLOOKUP(D2:D200,FallResponses!B2:N200,13,false) & "-" & VLOOKUP(D2:D200,FallResponses!B2:O200,14,false),
OR(IFERROR(FIND("Leaving",VLOOKUP(D2:D200,ManualResponses!B2:C200,2,false)),0)>0,
IFERROR(FIND("Leaving",VLOOKUP(D2:D200,FallResponses!B2:E200,4,false)),0)>0),
IFNA(VLOOKUP(D2:D200,ManualResponses!B2:E200,4,false),""),IFERROR(FIND("Initial",
VLOOKUP(D2:D200,ManualResponses!B2:E200,2,false)),0)>0,""))

Most of the IFERRORR and IFNA functions are needs for this formula to evaluate. The cell K formula compares The
column D value to the value on the corresponding row on the Fall Responses tab, and if it is not blank returns
column I (index 8). If column I is blank, then it checks if column N (index 13) is blank, and if not then
it returns column N (index 13) + column O (index 22) separated by an "-". If column N is blank, then the
formula checks if the word "Leaving" is in column C (index 2) on the ManualResponses tab or is in column E
(index 4) of the FallResponses tab, then it returns column E (index 4) from the FallResponses tab if the
check returns true. If the check returns NA, then column E (index 4) is returned or a blank. If all the prior
checks have not triggered, then the formula checks column C (index 2) of the ManualResponsestab to see if
the word "Initial" is present. If it is, then column C (index 2) from the ManualResponses is returned. If
the final check throws an error, then a blank is returned.

---------------
Cell T
===============
ARRAYFORMULA(IFNA(IFS(IFERROR(FIND("Initial",VLOOKUP(D2:D200,ManualResponses!B2:E200,2,false)),0),"N/A",
IFERROR(FIND("Research Lab",VLOOKUP(D2:D200,FallResponses!B2:D200,3,false)),0)>0,
VLOOKUP(D2:D200,FallResponses!B2:F200,5,false),not(isblank(IFNA(VLOOKUP(D2:D200,FallResponses!B2:B200,1,false),))),
VLOOKUP(D2:D200,FallResponses!B2:D200,3,false),not(isblank(IFNA(VLOOKUP(D2:D200,ManualResponses!B2:B200,1,false),))),
VLOOKUP(D2:D200,ManualResponses!B2:D200,3,false)),""))

Most of the IFERRORR and IFNA functions are needs for this formula to evaluate. The cell T formula checks if
column C (index 2) has the word "Initial" on the ManualResponsestab. If an error is given, then 0 is returned,
and if an NA error is given then "N/A" is returned. Then if column D (index 3) of the FallResponses tab has
"Research Lab" in its value, then column F (index 5) is returned. If "Research Lab" is not present, then the
formula checks if column B (index 1) is blank, if it is not blank then column D (index 3) is returned. If an error
is thrown, the nothing is returned. The final check is if column B (index 1) on ManualResponses is blank, and if
it isn't then column D (index 3) is returned. If an NA error is thrown, a space is returned.
`
