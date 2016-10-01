/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.length;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.cgarbs.roomplanner.length.LengthUnit;

public class LengthUnitTest {
	
	@Test
	public void stringCanBeConvertedToLengthUnit() {
		assertThat(LengthUnit.of("cm"), is(LengthUnit.CM));
	}
	
	@Test
	public void unknownUnitStringThrowsException() {
		try {
			LengthUnit.of("UNKN0WN");
			fail("no exception thrown");
		}
		catch (Exception e) {
			assertThat(e.getMessage(), endsWith("UNKN0WN"));
		}
	}

}
