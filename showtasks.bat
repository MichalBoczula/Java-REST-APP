call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startchrome
echo.
echo runcrud.bat has errors - work is stopped
goto fail

:startchrome
start chrome http://localhost:8080/crud/v1/task/getTasks
if "ERRORSLEVEL%" == "1" goto fail

:fail
echo There was error