RoomPlanner
===========

[![Build Status](https://travis-ci.org/mmitch/roomplanner.svg?branch=master)](https://travis-ci.org/mmitch/roomplanner)
[![Coverage Status](https://codecov.io/github/mmitch/roomplanner/coverage.svg?branch=master)](https://codecov.io/github/mmitch/roomplanner?branch=master)
[![GPL 3+](https://img.shields.io/badge/license-GPL%203%2B-blue.svg)](http://www.gnu.org/licenses/gpl-3.0-standalone.html)


about
-----

A little calculation tool for room refurbishments that
is able to calculate floor, ceiling and wall areas from
a given room description.

The project homepage is at <https://github.com/mmitch/roomplanner/>


usage
-----

Run the ``RoomPlanner`` main class (``gradle run`` should suffice).

There is no configuration parser yet, so you'll have to edit
``RoomPlanner.java`` to enter other dimensions or room setups.


dependencies
------------

While the test suite needs at least Java 8, the code itself should run
on older versions as well (but I did not test this).


TODOs
-----

 - support sloped ceilings
 - add 3D export to visualize the parsed room (only if I really get
   bored, but this would help to ensure a complex setup got parsed as
   desired)
   
   
copyright
---------

RoomPlanner - calculation tool for room refurbishments  
Copyright (C) 2016  Christian Garbs <mitch@cgarbs.de>
Licensed under GNU GPL v3 (or later)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
