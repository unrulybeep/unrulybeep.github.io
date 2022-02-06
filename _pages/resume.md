---
title:
layout: default
permalink: resume/
published: true
collection: resume
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

  <div class="container-fluid">
      <div class="row-fluid">
          <div class="col-md-8">
              <h3 class="title with-icon"><span class="glyphicon glyphicon-plane cat-title"></span>Work History</h3>
                <ul class="timeline">
                {% for exp in site.resume %}
                  <li class="timeline-inverted">
                              {% if exp.started %}
                                  <div class="timeline-badge info">{{ exp.started }}</div>
                              {% endif %}
                              <div class="timeline-panel grid-block">
                                  <div class="timeline-heading">
                                      {% if exp.company %}
                                          <h4 class="timeline-title">{{ exp.company }} </h4>
                                      {% endif %}
                                      <p>
                                          <small class="text-muted">
                                              {% if exp.title %}
                                                  {{ exp.title }}
                                              {% endif %}
                                          </small>
                                      </p>
                                      <p>
                                          <small class="text-muted">
                                              {% if exp.duration %}
                                                  <i class="fa fa-calendar"></i> {{ exp.duration }} |
                                              {% endif %}
                                              {% if work.location %}
                                                  <i class="fa fa-map-marker"></i>  {{ exp.location }}
                                              {% endif %}
                                          </small>
                                      </p>
                                  </div>
                                  <div class="timeline-body">
                                      {% if exp.description %}
                                          <p>{{ exp.description }}</p>
                                      {% endif %}
                                  </div>
                              </div>
                          </li>
                      {% endfor %}
                  </ul>
            </div>
          </div>
        </div>
