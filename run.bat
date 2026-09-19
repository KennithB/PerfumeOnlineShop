@echo off
setlocal
cd /d "%~dp0"

if not exist "build\classes" mkdir "build\classes"

if exist "src\images" (
    xcopy /s /y /i "src\images" "build\classes\images" >nul 2>&1
)

echo Compiling Java sources...
javac -encoding UTF-8 -cp "lib/*;src" -d build/classes src/*.java src/online/shop/*.java
if %ERRORLEVEL% neq 0 (
    echo [ERROR] Compilation failed. Check if all required JARs exist in lib\
    pause
    exit /b %ERRORLEVEL%
)

echo Starting Perfume Shop...
java -cp "build/classes;lib/*" Main
endlocal
