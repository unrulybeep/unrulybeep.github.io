---
title: Resume
width: full
layout: default
permalink: resume/
published: true
collection: resume
---
<style>


</style>
  <div class="container-fluid">
    <div class="row">
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
            reader and debugger of code; I am adept at reviewing existing to identify and reverse-engineer elegant solutions.</div>
          </div>

          <div class="deviter"></div>

        <h3 class="title with-icon"><span class="bi bi-pencil-square cat-title" aria-hidden="true"></span>Work History</h3>
        {% assign section = site.resume | where:"type","employment" %}
        {% include timeline.html %}

        <h3 class="title with-icon"><span class="fa fa-book cat-title" aria-hidden="true"></span>Education History</h3>
        {% assign section = site.resume | where:"type","education" %}
        {% include timeline.html %}
      </div>
      <div class="col-md-4">

        <h3 class="title with-icon"><span class="bi bi-code-slash cat-title" aria-hidden="true"></span> Programming Skills</h3>
        {% if site.programmingSkills %}
          {% assign section = site.programmingSkills %}
          {% include sidebar-meter.html %}
        {% endif %}

        <div class="deviter"></div>

        <h3 class="title with-icon">
        <span class="bi bi-brush cat-title" aria-hidden="true"></span>Design
        Skills</h3>
        {% if site.designSkills %}
          {% assign section = site.designSkills %}
          {% include sidebar-meter.html %}
        {% endif %}

        <div class="deviter"></div>

        {% if site.workshopsCerts %}
          <h3 class="title with-icon">
          <span class="bi bi-card-check cat-title" aria-hidden="true"></span>Workshops/Trainings</h3>
          <div class="grid-block">
            <ul class="list-unstyled list-strip">
            {% for entry in site.workshopsCerts %}
              {% if entry.title %}
              <li>
                <span class="fa fa-check"></span>
                <span class="badge badge-green badge-right-float">{{ entry.type }}</span>
                {{ entry.title }}
              </li>
              {% endif %}
            {% endfor %}
            </ul>
          </div>
        {% endif %}

      </div>
    </div>
  </div>
