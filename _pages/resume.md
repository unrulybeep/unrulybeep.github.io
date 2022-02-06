---
title:
layout: default
permalink: resume/
published: true
---

This is showing up.

  {% for exp in site.resume %}

  <div class="projectTile">
          <a href="{{ exp.url }}">
          <span>
              <h2>{{ exp.title }}</h2>
              <br/>
              <p>{{ exp.description }}</p>
          </span>
          </a>
  </div>

  {% endfor %}
