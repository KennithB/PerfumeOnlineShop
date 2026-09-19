$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $scriptDir

if (!(Test-Path "build\classes")) {
    New-Item -ItemType Directory -Path "build\classes" | Out-Null
}

if (Test-Path "src\images") {
    Copy-Item -Path "src\images" -Destination "build\classes\images" -Recurse -Force
}

Write-Host "Compiling Java sources..."
$javaFiles = Get-ChildItem -Path "src" -Filter *.java -Recurse | Select-Object -ExpandProperty FullName
javac -encoding UTF-8 -cp "lib/*;src" -d "build\classes" $javaFiles

if ($LASTEXITCODE -eq 0) {
    Write-Host "Starting Perfume Shop..." -ForegroundColor Green
    java -cp "build\classes;lib/*" Main
} else {
    Write-Host "[ERROR] Compilation failed. Ensure required JARs are inside lib/" -ForegroundColor Red
}
