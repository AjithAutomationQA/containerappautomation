Changes made in repository while migration appium 1.x to appium 2.x
1. Changed POM.xml file
    a. Added dependency to avoid log4j errors.
    b. Updated appium-java client version to 8.5.1.
    c. Added dependency of Selenium Java Library.

2. Changes in Capabilities file
    a. Removed the older desired capabilities.
    b. Added Options as a capabilities for driver initialization.
    c. Added required properties in app.properties file.

3. Changes in container.methods package
    a. Removed unused imports.
    b. Removed imports from older Appium-java client library.
    c. Changed IOSElements to WebElements.
    d. Changed findElementByXpath method to findElement(By.xpath())

4. changes in CommonUtils file
    a. Removed unused imports.
    b. Removed imports from older Appium-java client library.
    c. Added Duration.ofSeconds method instead of pure integer value.