package com.ea.test.steps;

import com.ea.framework.base.BasePage;
import com.ea.test.pages.CreateEmployeePage;
import com.ea.test.pages.EmployeeListPage;
import com.ea.test.pages.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static com.ea.framework.base.Base.CurrentPage;

/**
 * Created by Karthik-pc on 12/6/2016.
 */
public class EmployeeSteps  {
    @And("^I click employeeList link$")
    public void iClickEmployeeListLink() throws Throwable {
        CurrentPage = CurrentPage.As(HomePage.class).ClickEmployeeList();
        Thread.sleep(3000);
    }


    @Then("^I click createnew button$")
    public void iClickCreatenewButton() throws Throwable {
        CurrentPage = CurrentPage.As(EmployeeListPage.class).ClickCreateNew();
        Thread.sleep(3000);
    }

    @And("^I enter following details$")
    public void iEnterFollowingDetails(DataTable table) throws Throwable {

        List<List<String>> data = table.raw();
        CurrentPage.As(CreateEmployeePage.class).CreateEmployee(data.get(1).get(0), data.get(1).get(1), data.get(1).get(2),
                data.get(1).get(3), data.get(1).get(4));
        Thread.sleep(3000);
    }

    @And("^I click create button$")
    public void iClickCreateButton() throws Throwable {
        CurrentPage.As(CreateEmployeePage.class).ClickCreateButton();
        Thread.sleep(3000);
    }

}
