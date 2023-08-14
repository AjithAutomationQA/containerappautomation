Changes made in repository while migration appium 1.x to appium 2.x
1. Changed POM.xml file
    a. added dependency to avoid log4j errors.
    b. updated appium-java client version to 8.5.1.
    c. added dependency of Selenium Java Library.

2. Changes in Capabilities file
    a. Removed the older desired capabilities.
    b. Added Options as a capabilities for driver initialization.
    c. Added required properties in app.properties file.

3. Changes in container.methods package
    a. Removed unused imports.
    b. removed imports from older Appium-java client library.
    c. changed IOSElements to WebElements.
    d. Changed findElementByXpath method to findElement(By.xpath())