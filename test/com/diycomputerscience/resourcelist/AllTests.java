package com.diycomputerscience.resourcelist;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.diycomputerscience.resourcelist.controller.UrlsTest;
import com.diycomputerscience.resourcelist.view.ShowTopicViewTest;
import com.diycomputerscience.resourcelist.view.ShowTopicsViewTest;

@RunWith(Suite.class)
@SuiteClasses({UrlsTest.class, 
			   ShowTopicsViewTest.class,
			   ShowTopicViewTest.class})
public class AllTests {

}
