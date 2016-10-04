/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.additional;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.shape.Rectangle;

/**
 * A corner inset is an inward facing corner in a corner :-)
 * If you have a rectangular room and one corner has an inset,
 * the room is now L shaped.  Two corner insets next to each
 * other give a T shape, while two corners on opposite corners
 * give kind of an S shape.  Four corner insets let the room
 * look like a plus sign.
 * 
 * @author Christian Garbs <mitch@cgarbs.de>
 **/
/*
 * Example: Corner inset in the top-left corner (only wo
 *
 *     ########
 *     #      #
 *     #      #
 *   ###      #
 *   #        #
 *   #        #
 *   #        #
 *   #        #
 *   ##########
 */
public class CornerInset implements Additional {

	private Length firstWall;
	private Length secondWall;

	public CornerInset(Length firstWall, Length secondWall) {
		this.firstWall = firstWall;
		this.secondWall = secondWall;
	}

	@Override
	public Area getFloor() {
		return new Rectangle(firstWall, secondWall).getArea().negate();
	}

	@Override
	public Area getWall() {
		return Area.zero(firstWall.getUnit());
	}

	@Override
	public Area getCeiling() {
		return new Rectangle(firstWall, secondWall).getArea().negate();
	}

	public Length getFirstWall() {
		return firstWall;
	}

	public Length getSecondWall() {
		return firstWall;
	}

}
