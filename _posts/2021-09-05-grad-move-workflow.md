---
layout: post
title:  Grad Move Workflow Collaboration
experience: "Program Coordinator"
---

What your personal contributions were
The results of the project

The program coordinator oversees graduate student office/workroom
assignments. The work included the operations team and the support team. In
order to create efficiency and improve communication, Emma Gebbens, from the
support team, and I built a set of linked Google Workspace tools. The most
recent setup includes three (3) Google Forms, a Google Sheet, and two (2)
Google Presentations.

Below is the psudo-READ.md I created to cover the complex formulas Emma and
I developed to handle data across several tabs. This file was a self-driven
inclusion to the project.

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
