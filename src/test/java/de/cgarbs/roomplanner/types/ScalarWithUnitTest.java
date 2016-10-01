/*
 * Copyright 2016 (C)  Christian Garbs <mitch@cgarbs.de>
 * Licensed under GNU GPL 3 (or later)
 */
package de.cgarbs.roomplanner.types;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import de.cgarbs.roomplanner.area.AreaUnit;
import de.cgarbs.roomplanner.length.LengthUnit;
import de.cgarbs.roomplanner.test.stub.CM;
import de.cgarbs.roomplanner.types.ScalarWithUnit;

public class ScalarWithUnitTest {

	@Test
	public void forDisplayContainsValueAndUnit() {
		ScalarWithUnit<LengthUnit> scalar = new ScalarWithUnit<LengthUnit>(BigDecimal.TEN, LengthUnit.CM);
		assertThat(scalar.forDisplay(), is("10cm"));
	}
	
	@Test
	public void twoScalarsWithEqualValueAndEqualUnitAreEqual() {
		ScalarWithUnit<LengthUnit> scalar1 = new ScalarWithUnit<LengthUnit>(BigDecimal.TEN, LengthUnit.CM);
		ScalarWithUnit<LengthUnit> scalar2 = new ScalarWithUnit<LengthUnit>(BigDecimal.TEN, LengthUnit.CM);
		assertThat(scalar1, is(scalar2));
	}

	@Test
	public void twoScalarsWithDifferentUnitsAndEqualValuesAreNotEqual() {
		ScalarWithUnit<LengthUnit> scalar1 = new ScalarWithUnit<LengthUnit>(BigDecimal.TEN, LengthUnit.CM);
		ScalarWithUnit<AreaUnit> scalar2 = new ScalarWithUnit<AreaUnit>(BigDecimal.TEN, AreaUnit.CM2);
		assertThat(scalar1, not(scalar2));
	}

	@Test
	public void twoScalarsWithDifferentValuesAndEqualUnitsAreNotEqual() {
		ScalarWithUnit<LengthUnit> scalar1 = new ScalarWithUnit<LengthUnit>(BigDecimal.ONE, LengthUnit.CM);
		ScalarWithUnit<LengthUnit> scalar2 = new ScalarWithUnit<LengthUnit>(BigDecimal.TEN, LengthUnit.CM);
		assertThat(scalar1, not(scalar2));
	}

	@Test
	public void scalarCanBeConvertedToDifferentUnit() {
		ScalarWithUnit<LengthUnit> scalar = new ScalarWithUnit<LengthUnit>(BigDecimal.ONE, LengthUnit.M);
		ScalarWithUnit<LengthUnit> convertedScalar = scalar.convertTo(LengthUnit.CM);
		assertThat(convertedScalar, is(new CM(100)));
	}
	
	@Test
	public void typeConversionIsSkippedIfNotNeeded() {
		ScalarWithUnit<LengthUnit> scalar = new ScalarWithUnit<LengthUnit>(BigDecimal.ONE, LengthUnit.M);
		ScalarWithUnit<LengthUnit> convertedScalar = scalar.convertTo(LengthUnit.M);
		assertThat(convertedScalar, sameInstance(scalar));
	}
}
