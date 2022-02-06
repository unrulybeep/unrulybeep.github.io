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
                <ul class="timeline">

                {% for exp in site.resume | where:"type","employment" %}
                  <li class="timeline-inverted">
                              {% if exp.started %}
                                  <div class="timeline-badge info">{{ exp.started }}</div>
                              {% endif %}
                              <div class="timeline-panel grid-block">
                                  <div class="timeline-heading">
                                      {% if exp.title %}
                                          <h4 class="timeline-title"><a href="{{ exp.url }}">{{ exp.title }}</a> </h4>
                                      {% endif %}
                                      <p>
                                          <small class="text-muted">
                                              {% if exp.company %}
                                                {{ exp.company}}
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
