Please use the Selenium WebDriver power, framework unit test, and Page Object concepts for this task. Automate the following script:
1. Open https://cloud.google.com/.
2. Click on the icon at the top of the portal page and enter "Google Cloud Platform Pricing Calculator" into the search field.
3. Perform the search.
4. Click "Google Cloud Platform Pricing Calculator" in the search results and go to the calculator page.
5. Click COMPUTE ENGINE at the top of the page.
6. Fill out the form with the following data:
    * Number of instances: 4
    * What are these instances for?: leave blank
    * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or another User-Provided OS
    * Provisioning model: Regular
    * Machine Family: General purpose
    * Series: N1
    * Machine type: n1-standard-8 (vCPUs: 8, RAM: 30 GB)
    * Select “Add GPUs“
      * GPU type: NVIDIA Tesla V100
      * Number of GPUs: 1
    * Local SSD: 2x375 Gb
    * Datacenter location: Frankfurt (europe-west3)
    * Committed usage: 1 Year
      Other options leave in the default state.
7. Click 'Add to Estimate'.
8. Check the price is calculated in the right section of the calculator. There is a line “Total Estimated Cost: USD ${amount} per 1 month”
9. Select 'EMAIL ESTIMATE'.
10. In a new tab, open https://yopmail.com/ or a similar temporary email–generating service.
11. Generate a random email.
12. Copy the email generated in yopmail.com (or any other service).
13. Return to the calculator and enter the above email into the email field.
14. Press 'SEND EMAIL'.
15. Wait for the cost estimate email and check that the emailed 'Total Estimated Monthly Cost' matches the result in the calculator.
15. Wait for the cost estimate email and check that the emailed 'Total Estimated Monthly Cost' matches the result in the calculator.


