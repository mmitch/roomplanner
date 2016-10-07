/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.area;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.cgarbs.roomplanner.shape.GenericShape;
import de.cgarbs.roomplanner.test.stub.CM2;
import de.cgarbs.roomplanner.test.stub.M2;

public class AreaTest {

	@Test
	public void addingTwoAreasGivesTheSumOfTheAreas() {
		assertThat(new CM2(1).add(new CM2(1)), is(new CM2(2)));
	}
	
	@Test
	public void theAreaOfMultipleShapesIsTheSumOfTheirAreas() {
		assertThat(
				Area.of(
					new GenericShape(new CM2(1)),
					new GenericShape(new CM2(1)),
					new GenericShape(new CM2(1))
						),
				is(new CM2(3)));
	}
	
	@Test
	public void differentUnitsCanBeSummed() {
		assertThat(
				Area.of(
					new GenericShape(new CM2(100)),
					new GenericShape(new M2("0.01"))
						),
				is(new CM2(200))
				);
	}

	@Test
	public void negateChangesValueSignum() {
		Area area = new Area(1, AreaUnit.M2);
		Area negated = area.negate();
		assertThat(negated.getValue(), is(area.getValue().negate()));
		assertThat(negated.getUnit(), is(area.getUnit()));
	}
}
