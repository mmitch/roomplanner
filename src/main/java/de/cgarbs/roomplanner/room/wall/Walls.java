/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.wall;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.room.HasFaces;
import de.cgarbs.wavefront.Face;

public class Walls extends HashMap<WallPosition, Wall> implements HasFaces
{
	private static final long serialVersionUID = 1L;

	public static Walls of(Wall... walls)
	{
		Walls w = new Walls();
		Stream.of(walls).forEach(w::put);
		return w;
	}

	public Area getArea()
	{
		Iterator<Wall> iter = values().iterator();
		Area area = iter.next().getArea();
		while (iter.hasNext())
		{
			area = area.add(iter.next().getArea());
		}
		return area;
	}

	public void put(Wall wall)
	{
		put(wall.getPosition(), wall);
	}

	@Override
	public List<Face> faces()
	{
		return values().stream() //
				.flatMap((wall) -> wall.faces.stream()) //
				.collect(Collectors.toList());
	}

}
