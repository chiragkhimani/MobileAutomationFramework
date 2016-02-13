package com.automation.pages.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:report/html/" }, features = { "behavior/Navigation.feature" })
public class MainCucumberRunner {
}
