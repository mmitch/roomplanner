/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.room.additional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.room.additional.CornerInset;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.test.stub.CM2;

public class CornerInsetTest {

	@Test
	public void floorAreaIsReducedByWidthTimesHeight() {
		CornerInset cornerInset = new CornerInset(new CM(2), new CM(3));
		assertThat(cornerInset.getFloor(), is(new CM2(-6)));
	}

	@Test
	public void wallAreaIsUnchanged() {
		CornerInset cornerInset = new CornerInset(new CM(1), new CM(2));
		assertThat(cornerInset.getWall(), is(new CM2(0)));
	}

	@Test
	public void ceilingAreaIsReducedByWidthTimesHeight() {
		CornerInset cornerInset = new CornerInset(new CM(4), new CM(3));
		assertThat(cornerInset.getCeiling(), is(new CM2(-12)));
	}
}
