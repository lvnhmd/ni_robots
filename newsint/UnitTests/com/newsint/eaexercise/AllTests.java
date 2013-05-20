package com.newsint.eaexercise;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.newsint.eaexercise.command.CommandTest;
import com.newsint.eaexercise.entities.PlateauTest;
import com.newsint.eaexercise.entities.PositionTest;
import com.newsint.eaexercise.entities.RobotTest;
import com.newsint.eaexercise.state.DirectionEastTest;
import com.newsint.eaexercise.state.DirectionNorthTest;
import com.newsint.eaexercise.state.DirectionSouthTest;
import com.newsint.eaexercise.state.DirectionWestTest;

@RunWith(Suite.class)
@SuiteClasses({ PlateauTest.class, PositionTest.class, RobotTest.class, DirectionEastTest.class,
		DirectionNorthTest.class, DirectionSouthTest.class,
		DirectionWestTest.class, CommandTest.class  })
public class AllTests {

}
