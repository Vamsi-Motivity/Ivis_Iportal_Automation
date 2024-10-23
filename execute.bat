taskkill /F /IM IEDriverServer.exe /T
pause
taskkill /F /IM chromedriver.exe /T
pause
rd %temp% /s /q

md %temp%