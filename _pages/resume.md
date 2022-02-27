---
title: Resume
width: full
layout: default
permalink: resume/
published: true
collection: resume
---
  <div class="container-fluid">
    <div class="row">
    <div class="deviter"></div>
      <div class="col-md-8">

        <div id="pitch">
          <h3 class="title with-icon">
            <span class="bi bi-easel cat-title"></span>Elevator
          Pitch
          </h3>
          <div class="timeline-panel grid-block">
            I bring the capacity to ask questions about diversity that are not
            anchored solely at the individual level but also at the institutional
            level. I have over 20 years experience with technical skills acquired
            through formal computer science coursework in HTML/CSS, Javascript
            and Java at Portland Community College and the University of
            Washington and self-directed on-the-job skill development of
            Bootstrap, Google App Scripts, Excel, React.js, and XXXXX. My
            hunmble beginnings working with HTML/CSS has flourished a skilled
            reader and debugger of code; I am adept at reviewing existing to identify and reverse-engineer elegant solutions.
          </div>
        </div>

        <div class="deviter"></div>

        <h3 class="title with-icon">
          <span class="bi bi-pencil-square cat-title" aria-hidden="true"></span>Work History</h3>
        {% assign section = site.resume | where:"type","employment"
        | sort_natural: "ended" | reverse %}
          {% include timeline.html %}

        <h3 class="title with-icon"><span class="bi bi-book cat-title" aria-hidden="true"></span>Education History</h3>
        {% assign section = site.resume | where:"type","education"
        | reverse %}
          {% include timeline.html %}

        <div class="deviter"></div>

        <h3 class="title with-icon">
          <span class="bi bi-award cat-title"></span>Awards and Honors
        </h3>
        {% assign section = site.data.awards %}
          {% include widebox.html %}
      </div>

      <div class="col-md-4">

        <h3 class="title with-icon">
          <span class="bi bi-code-slash cat-title" aria-hidden="true"></span> Programming Skills
        </h3>
        {% assign section = site.data.resumeSkills | where: "area", "programming" %}
          {% include sidebar-meter.html %}

        <div class="deviter"></div>

        <h3 class="title with-icon">
          <span class="bi bi-card-checklist cat-title" aria-hidden="true"></span>Frameworks
        </h3>

        <div class="grid-block">
          <ul class="list-unstyled list-strip">
          {% assign section = site.data.resumeSkills | where: "area", "framework" %}
          {% for entry in section %}
            {% if entry.name %}
            <li>
              <span class="fa fa-check"></span>
              {{ entry.name }}
            </li>
            {% endif %}
          {% endfor %}
          </ul>
        </div>

        <div class="deviter"></div>

        <h3 class="title with-icon">
        <span class="bi bi-brush cat-title" aria-hidden="true"></span>Photo/Graphic Software</h3>

          {% assign section = site.data.resumeSkills | where: "area", "design" %}
          {% include sidebar-meter.html %}

        <div class="deviter"></div>

        <h3 class="title with-icon">
        <span class="bi bi-brush cat-title" aria-hidden="true"></span>Frontend Design</h3>
          {% assign section = site.data.resumeSkills | where: "area", "frontend" %}
          {% include sidebar-meter.html %}

        <div class="deviter"></div>

        {% if site.data.workshops %}
        <h3 class="title with-icon">
          <span class="bi bi-card-checklist cat-title" aria-hidden="true">
        </span>Workshops/Trainings</h3>
        {% assign section = site.data.workshops %}
          {% include sidebar-list.html %}
        {% endif %}
      </div>
    </div>
  </div>
