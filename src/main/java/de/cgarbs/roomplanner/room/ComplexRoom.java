/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room;

import java.util.function.Function;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.room.additional.Additional;
import de.cgarbs.roomplanner.room.additional.Additionals;

public class ComplexRoom extends Room {

	private Room baseRoom;
	private Additionals additionals = new Additionals();

	public ComplexRoom(Room baseRoom, Additional additional) {
		this.baseRoom = baseRoom;
		additionals.add(additional);
	}
	
	public ComplexRoom add(Additional additional) {
		additionals.add(additional);
		return this;
	}

	@Override
	public Area getFloor() {
		return getSumFor(Additional::getFloor);
	}

	@Override
	public Area getWall() {
		return getSumFor(Additional::getWall);
	}

	@Override
	public Area getCeiling() {
		return getSumFor(Additional::getCeiling);
	}
	
	private Area getSumFor(Function<Additional, Area> function) {
		Area area = function.apply(baseRoom);
		for (Additional additional: additionals) {
			area = area.add(function.apply(additional));
		}
		return area;
	}
}
