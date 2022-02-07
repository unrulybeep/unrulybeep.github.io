---
title: Resume
width: full
layout: default
permalink: resume/
published: true
collection: resume
---
<style>
@import url("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css");

</style>
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-8">
        <h3 class="title with-icon"><span class="glyphicon glyphicon-plane cat-title"></span>Work History</h3>
        {% assign section = site.resume | where:"type","employment" %}
        {% include timeline.html %}

        <h3 class="title with-icon"><span class="fa fa-book cat-title"></span>Education History</h3>
        {% assign section = site.resume | where:"type","education" %}
        {% include timeline.html %}
      </div>
      <div class="col-md-4">
        <h3 class="title with-icon"><span class="fa fa-code cat-title"></span> Programming Skills</h3>
        {% if site.programmingSkills %}
          {% assign section = site.programmingSkills %}
          {% include sidebar-meter.html %}
        {% endif %}
      </div>
    </div>
  </div>
