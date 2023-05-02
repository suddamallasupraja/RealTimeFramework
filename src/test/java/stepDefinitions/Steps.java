package stepDefinitions;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.Amazonpage;
import pageObjects.BlazedemoPage;
import pageObjects.Desktops;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.Orange_tabsPage;
import pageObjects.Pagination_page;
import pageObjects.Phones_PDAspage;
//import pageObjects.WebDriverWait;
import utilities.DataReader;
import org.openqa.selenium.interactions.Actions;
public class Steps 
{
	WebDriver driver;
	Logger logger;
	 ResourceBundle rb;
	 String br;
	 
	 HomePage hp;
	 LoginPage Lp;
	 MyAccountPage mp;
	 Phones_PDAspage ph;
	 Desktops ds;
	 Orange_tabsPage ohw;
	 Pagination_page pag;
	 Amazonpage ap;
	 BlazedemoPage bp;
	List<HashMap<String, String>> datamap;
	 
@Before
public void setup()
{
	rb=ResourceBundle.getBundle("config");
	logger=LogManager.getLogger(this.getClass());
	//driver.manage().deleteAllCookies();
}

@After
public void teardown(Scenario scenario)
{
	System.out.println("Scenario status :"+scenario.getStatus());
	if(scenario.isFailed())
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	//driver.quit();
}
	
	@Given("user launches the browser")
	public void user_launches_the_browser() 
	{
		br=rb.getString("browser");
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		} 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("open URL {string}")
	public void open_url(String URL) throws InterruptedException {
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}

	@When("navigates to MyAccount menu")
	public void navigates_to_my_account_menu() 
	{
		hp=new HomePage(driver);
		hp.clickaccount();
	}

	@When("click on login")
	public void click_on_login() 
	{
		
		hp.hlogin();
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String maile, String pwrd) 
	{
		Lp=new LoginPage(driver);
	   Lp.mail(maile);
	   Lp.paswrd(pwrd);
	}

	@When("click on Login button")
	public void click_on_login_button() 
	{
	   Lp.lg();
	}

	@SuppressWarnings("deprecation")
	@Then("User navigates to Myaccount Page")
	public void user_navigates_to_myaccount_page() throws InterruptedException 
	{
		mp=new MyAccountPage(driver);
		Thread.sleep(4000);
      String res= mp.acpage();
      if(res=="My Acccount")
      {
    	  Assert.assertTrue(true);
      }
      else
      {
    	  Assert.assertTrue(false);
      }
     
	}
	
	@Then("check user navigates to Myaccount Page  by passing Email and Pssword with excel row {string}")
	public void check_user_navigates_to_myaccount_page_by_passing_email_and_pssword_with_excel_row(String rows) throws InterruptedException 
	{
	 datamap = DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_LoginData.xlsx","Sheet1");
		
		int index=Integer.parseInt(rows)-1;
		String email=datamap.get(index).get("username");
		String pwd=datamap.get(index).get("password");
		String exp_res=datamap.get(index).get("result");
		
		Lp=new LoginPage(driver);
		 Lp.mail(email);
		 Lp.paswrd(pwd);
		 Lp.lg();
		 Thread.sleep(3000);
		 
		 mp=new MyAccountPage(driver);
		 String ex=mp.acpage();
		 try
		 {
		 if(exp_res.equals("valid"))
		 {
		 if(ex.equals("My Account"))
		{
			 mp.logout();
			Assert.assertTrue(true);      
		 }
		 else
		 {
			 Assert.assertTrue(false);   
		 }
		
		 }
		 
		 if(exp_res.equals("invalid"))
		 {
			 if(ex.equals("My Account"))
			 {
				 mp.logout();
				 Assert.assertTrue(false);   
			 }
			 else
			 {
				 Assert.assertTrue(true);   
			 }
		 }
		 }
		 catch(Exception e)
		 {
			 Assert.assertTrue(false);
		 }
		 driver.close();
		 
	}
	@When("user navigates to Phones & PDAs menu")
	public void user_navigates_to_phones_pd_as_menu() 
	{
		hp=new HomePage(driver);
		
		hp.clk();
	}

	@When("choose {string} by clicking on Sort By dropdown")
	public void choose_by_clicking_on_sort_by_dropdown(String exp_tx) throws InterruptedException 
	{
		ph=new Phones_PDAspage(driver);
		ph.selct(exp_tx);
	}
	   
	

	@Then("it will show Highest rating mobiles accordingly")
	public void it_will_show_highest_rating_mobiles_accordingly() 
	{
		ph=new Phones_PDAspage(driver);
		ph.na();
	}
	
	@When("user navigates to Desktops menu")
	public void user_navigates_to_desktops_menu() 
	{
		hp=new HomePage(driver);
		hp.demenu();
	}

	@When("click on Show All Desktops")
	public void click_on_show_all_desktops()
	{
		hp=new HomePage(driver);
		hp.sadmenu();
	}

	@Then("user navigates to Desktops page")
	public void user_navigates_to_desktops_page() 
	{
		ds=new Desktops(driver);
		String te=ds.dtext();
		Assert.assertEquals(te,"Desktops");
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("click on all available pages")
	public void click_on_all_available_pages() throws InterruptedException 
	{
	 ds=new Desktops(driver);
//	  int no_pages= ds.pages();
	  for(int i=1;i<=2;i++)
	  {
		  Thread.sleep(4000);
//		  if(no_pages>0)
//		  {
		  
		WebElement pp= ds.pagexpath(i);
		System.out.println("---------------------------"+pp);
		Actions as=new Actions(driver);
		 as.moveToElement(pp).click().build().perform();
		// WebElement ws= ds.pagexpath(i);
		 //JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", ws);
		 if(pp.getText().equals(i))
		 {
			Assert.assertTrue(true); 
		 }
		 else
		 {
			 Assert.assertTrue(false);  
		 }
		  }		 
	  
	  }
	//jdbc connectivity
	
	@Then("execute query {string}")
	public void execute_query(String qry) throws SQLException 
	{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Supraja@98");
		Statement stmt=con.createStatement();
		//String qry="Insert INTO Employee (emp_id,emp_dept) values(10,100)";
		stmt.execute(qry);
		con.close();
	}
	
//Orange HRM Application
	
	@When("user clicks on OrangeHRM.Inc")
	public void user_clicks_on_orange_hrm_inc() throws InterruptedException 
	{
	   ohw=new Orange_tabsPage(driver);
	   ohw.orngehrm();
	}

	@Then("clicks on Try it for Free by navigating to respective page")
	public void clicks_on_try_it_for_free_by_navigating_to_respective_page() 
	{
		 ohw=new Orange_tabsPage(driver);
		// ohw.tab();
		 Set<String> wh=driver.getWindowHandles();
		 for(String windowid:wh)
			{
				String id=driver.switchTo().window(windowid).getTitle();
				if(id.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
				{
					ohw.chk();
				}
			}
			driver.close();
	}
	
	
	@When("user enters the username as {string} and password as {string}")
	public void user_enters_the_username_as_and_password_as(String username, String password) 
	{
	  pag=new Pagination_page(driver);
	  pag.name(username);
	  pag.pword(password);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() 
	{
	pag=new Pagination_page(driver);
	   pag.login();
	}

	@When("user navigates to dashboard page")
	public void user_navigates_to_dashboard_page() 
	{
		pag=new Pagination_page(driver);
		
	//Alert pop=	driver.switchTo().alert();
	//pop.dismiss();
		String txt=pag.dashb();
		if(txt.equals("Dashboard"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("user navigates to customers")
	public void user_navigates_to_customers() 
	{
		pag=new Pagination_page(driver);
		pag.custo();
	}

	@When("click on customers")
	public void click_on_customers() 
	{
		pag=new Pagination_page(driver);
		pag.costom();
	}

	@Then("user enters to customers page")
	public void user_enters_to_customers_page() 
	{
		pag=new Pagination_page(driver);
		String text=pag.customd();
		if(text.equals("Customers"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		}

	@Then("click on all avaliable pages in the table")
	public void click_on_all_avaliable_pages_in_the_table() 
	{
		pag=new Pagination_page(driver);
		pag.pagi();
		//int pages=pag.npages();
/*		for(int i=2;i<10;i++)
		{
		WebElement fir=pag.pagi(i);
		System.out.println("---------------------------"+fir);
		fir.click();
		 if(fir.getText().equals(i))
		 {
			Assert.assertTrue(true); 
		 }
		 else
		 {
			 Assert.assertTrue(false);  
		 }
		}  */
	}
	
	//Amazon application
	
	@When("user searches for tees for women")
	public void user_searches_for_tees_for_women() 
	{
	  ap=new Amazonpage(driver); 
	  ap.key();
	}

	@When("click on search")
	public void click_on_search() 
	{
		ap=new Amazonpage(driver);
		ap.search();
	}

	@Then("user clicks on all available pages")
	public void user_clicks_on_all_available_pages() throws InterruptedException 
	{
		ap=new Amazonpage(driver); 
		ap.pagination();
	}
	
	//Blazedemo
	
	@When("user navigates to home page check the title")
	public void user_navigates_to_home_page_check_the_title()
	{
	    bp=new BlazedemoPage(driver);
	  String value= bp.display();
	  if(value.equals("Welcome to the Simple Travel Agency!"))
	  {
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertTrue(false);
	  }
	}

	@When("click on hyperlink")
	public void click_on_hyperlink() 
	{
		bp=new BlazedemoPage(driver);
		bp.clk();
	}

	@When("user navigates to new tab and check the url has string vacation")
	public void user_navigates_to_new_tab_and_check_the_url_has_string_vacation() 
	{
		bp=new BlazedemoPage(driver);
	//	String ele=	driver.getWindowHandle();
	//	System.out.println(ele);
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().equals("https://blazedemo.com/vacation.html"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("user navigates to home page tab")
	public void user_navigates_to_home_page_tab() 
	{
		bp=new BlazedemoPage(driver);
		driver.navigate().back();
	}

	@When("select {string} in departure city")
	public void select_in_departure_city(String city) 
	{
		bp=new BlazedemoPage(driver);
		List<WebElement> op=bp.dep();
		System.out.println(op.size());
		for(int i=0;i<op.size();i++)
		{
		String sc=op.get(i).getText();
		if(sc.equals(city))
		{
			op.get(i).click();
		}
		}
	}

	@When("select {string} in destination city")
	public void select_in_destination_city(String citi) 
	{
		bp=new BlazedemoPage(driver);
		List<WebElement> ops=bp.des();
		System.out.println(ops.size());
		for(int i=0;i<ops.size();i++)
		{
		String sc=ops.get(i).getText();
		if(sc.equals(citi))
		{
			ops.get(i).click();
			break;
		}
		}
	}

	@When("click on FindFlights")
	public void click_on_find_flights() 
	{
		bp=new BlazedemoPage(driver);
		bp.sub();
	}

	@When("select the flight with lowest price by clicking on choose the flight")
	public void select_the_flight_with_lowest_price_by_clicking_on_choose_the_flight() 
	{
		bp=new BlazedemoPage(driver);
		int val=bp.row();
		for(int i=1;i<val;i++)
		{
		 String ech=bp.choose(i).getText();
		 if(ech.equals("$200.98"))
		 {
		WebElement sc=driver.findElement(By.xpath("//div[@class='container']//table[@class='table']//tr["+i+"]//td[1]"));
		sc.click();
		break;
		 }
		}
	}

	@When("user navigates to purchase page")
	public void user_navigates_to_purchase_page() 
	{
		bp=new BlazedemoPage(driver);
		String value=bp.vvv();
		if(value.equals("Your flight from TLV to SFO has been reserved."))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
	}

	@When("check the total cost")
	public void check_the_total_cost() throws InterruptedException 
	{
		Thread.sleep(4000);
		bp=new BlazedemoPage(driver);
		String tct=bp.cost();
		System.out.println(tct);
		if(tct.equals("Total Cost:"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("check the price available")
	public void check_the_price_available() 
	{
		bp=new BlazedemoPage(driver);
		String num=bp.value();
		System.out.println(num);
		if(num.equals("914.76"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("click on purchase flight button")
	public void click_on_purchase_flight_button() 
	{
		bp=new BlazedemoPage(driver);
		bp.subbm();
	}

	@Then("user navigates to purchase confirmation page")
	public void user_navigates_to_purchase_confirmation_page() 
	{
		bp=new BlazedemoPage(driver);
		String txt=bp.check();
		if(txt.equals("Thank you for your purchase today!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@Then("store id in the console")
	public void store_id_in_the_console() 
	{
		bp=new BlazedemoPage(driver);
		for(int i=1;i<=2;i++)
		{
		String id=	bp.fina(i).getText();
		System.out.println(id);
		}
	}
}

