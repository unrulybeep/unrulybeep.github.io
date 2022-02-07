---
title: Resume
layout: default
permalink: resume/
published: true
collection: resume
---
  <div class="container-fluid" style="max-width: 1200px; font-size: 14px">
    <div class="row-fluid">
      <div class="col-md-8">
        <h3 class="title with-icon"><span class="glyphicon glyphicon-plane cat-title"></span>Work History</h3>
        {% assign section = site.resume | where:"type","employment" %}
        {% include timeline.html %}
      </div>
    </div>
  </div>
