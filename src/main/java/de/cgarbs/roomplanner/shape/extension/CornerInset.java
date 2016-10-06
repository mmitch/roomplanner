/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.shape.extension;

import de.cgarbs.roomplanner.area.Area;
import de.cgarbs.roomplanner.length.Length;
import de.cgarbs.roomplanner.room.ceiling.Ceiling;
import de.cgarbs.roomplanner.room.corner.CornerPosition;
import de.cgarbs.roomplanner.room.floor.Floor;
import de.cgarbs.roomplanner.room.wall.Wall;
import de.cgarbs.roomplanner.room.wall.Walls;
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
 * Example: Corner inset in the top-left corner
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
public class CornerInset implements Extender {

	private static final int FIRST_WALL = 0;
	private static final int SECOND_WALL = 1;
	private static final int WALL_COUNT = 2;

	private Length[] length = new Length[WALL_COUNT];
	private CornerPosition corner;

	public CornerInset(CornerPosition corner, Length firstWall, Length secondWall) {
		this.corner = corner;
		length[FIRST_WALL] = firstWall;
		length[SECOND_WALL] = secondWall;
	}

	@Override
	public void extendFloor(Floor floor) {
		floor.add(new Extension(getCutoutArea()));
	}

	@Override
	public void extendCeiling(Ceiling ceiling) {
		ceiling.add(new Extension(getCutoutArea()));
	}

	@Override
	public void extendWalls(Walls walls) {
		for (int wallNumber = 0; wallNumber < WALL_COUNT; wallNumber++) {
			extendWall(walls, wallNumber);
		}
	}
	
	private Area getCutoutArea() {
		return new Rectangle(length[FIRST_WALL], length[SECOND_WALL]).getArea().negate();
	}

	private void extendWall(Walls walls, int wallNumber) {
		Wall wall = walls.get(corner.getAdjacentWalls().get(wallNumber));
		Length height = wall.getHeight();
		Area wallArea = new Rectangle(height, length[wallNumber]).getArea();

		// this is a zero-sum change, but for bookkeeping sakes we record it
		wall.add(new Extension(wallArea.negate()));
		wall.add(new Extension(wallArea));
	}
}
