---
layout: post
title: "Generate Google Slide from Google Sheet Scripts"
---
The Qualifying Evaluation process involves a faculty meeting. Every quarter
students signup to be on the meeting agenda. A slide deck of the students is
created for each student that has specific information including Qualifying
Evaluation project title, faculty advisor(s), enrollment dates, an evaluation
by the faculty advisor(s) on how the student is doing in the program thus far,
and a photo. Faculty in attendance then offer advice and decide whether the
student should continue on in the program.

A typical quarter has 15-20 students on the agenda. That is 45-60 slides a year
that have to be constructed by hand. I wrote this script to help automate the
process.

The script takes the data on the current active row and sets each value to the
corresponding variable name. Then an array named request is constructed where
placeholder text is replaced with the value from each variable. The function
goGoSlide is called and requests is passed to the function. The goGoSlide
function finds the specified slide in the enactor's Google Drive, creates a
copy of the slide, and replaces the placeholder text on the slide copy with the
values of the requests array.

`function GenerateSlide() {
  // Gets the row values of the active range, and its column heading
  var row = SpreadsheetApp.getActiveSheet().getActiveRange().getRow();
  var column = SpreadsheetApp.getActiveSheet().getLastColumn() - 1;
  var values = SpreadsheetApp.getActiveSheet().getRange(row, 1, 1, SpreadsheetApp.getActiveSheet().getLastColumn() ).getValues() ;

  var fname = values[0][1]; // first name in column 2
  var lname = values[0][2]; // last name in column 3
  var committee = values[0][3]; // Quals Committee in column 4
  var advisor = values[0][3].slice(0,values[0][3].indexOf(",") ) ; // get the value in row 4 and discard anything after the comma
  var area = values[0][4]; // area in column 5
  var year = values[0][7].toString();  // year in column 8
  var prezTitle = values[0][column]; // title in last column

  // Create the text merge (replaceAllText) requests for this presentation.
  requests = [{
    replaceAllText: {
      containsText: {
        text: '<<FNAME>>',
        matchCase: true
      },
      replaceText: fname
    }
  }, {
    replaceAllText: {
      containsText: {
        text: '<<LNAME>>',
        matchCase: true
      },
      replaceText: lname
    }
  }, {
    replaceAllText: {
      containsText: {
        text: '<<Advisor>>',
        matchCase: true
      },
      replaceText: advisor
    }
  }, {
    replaceAllText: {
      containsText: {
        text: '<<Quals Committee>>',
        matchCase: true
      },
      replaceText: committee
    }
  }, {
    replaceAllText: {
      containsText: {
        text: '<<Year>>',
        matchCase: true
      },
      replaceText: year
    }
  }, {
    replaceAllText: {
      containsText: {
        text: '<<Area>>',
        matchCase: true
      },
      replaceText: area
    }
  }, {
    replaceAllText: {
      containsText: {
        text: '"<<Title>>"',
        matchCase: true
      },
      replaceText: '"' + prezTitle + '"'
    }
  }];

  var copyTitle = lname + ' presentation';
  goGoSlide(requests, copyTitle);
};

function goGoSlide(requests, copyTitle) {
  // Duplicate the template presentation using the Drive API.

  var copyFile = {
    title: copyTitle,
    parents: [{id: 'root'}]
  };
  // Put File ID of Slide Template between ""
  copyFile = Drive.Files.copy(copyFile, "1ew8f8fWANiKKDRf7whqrvkxj0dQ3tg4PzNcGtfz3mIo");
  var presentationCopyId = copyFile.id;

  // Execute the requests for this presentation.
  var result = Slides.Presentations.batchUpdate({
    requests: requests
  }, presentationCopyId);
  // Put a link to the slide in the active cell
  SpreadsheetApp.getActiveSheet().getActiveCell().setValue( Drive.Files.get(presentationCopyId).alternateLink );

}
`
