/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.floor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

import de.cgarbs.roomplanner.test.stub.M;
import de.cgarbs.wavefront.Face;
import de.cgarbs.wavefront.V;

public class FloorTest
{
	@Test
	public void floorFaceIsARectangle()
	{
		Floor floor = new Floor(new M(3), new M(5));
		assertThat( //
				floor.faces().collect(Collectors.toList()), //
				is( //
						Arrays.asList( //
								new Face( //
										new V(0, 0, 0), //
										new V(300, 0, 0), //
										new V(300, 500, 0), //
										new V(0, 500, 0) //
								) //
						) //
				) //
		);
	}
}
