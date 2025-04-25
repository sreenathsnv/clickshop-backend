@echo on
setlocal EnableDelayedExpansion

:: Define project directories
set "PROJECTS=ServiceRegistry AuthManagerMicroservice CartManagement OrderManagement ProductMicroservice"

:: Check prerequisites
echo Checking prerequisites...
where mvnd >nul 2>&1
if !ERRORLEVEL! neq 0 (
    echo Error: mvnd is not installed. Please install mvnd to proceed.
    pause
    exit /b 1
)
where docker >nul 2>&1
if !ERRORLEVEL! neq 0 (
    echo Warning: Docker is not installed. Docker-related commands will not work.
)
where docker-compose >nul 2>&1
if !ERRORLEVEL! neq 0 (
    echo Warning: Docker Compose is not installed. Docker-related commands will not work.
)
echo Prerequisites checked.

:: Function to build all projects
:build_projects
echo Building all projects...
for %%p in (%PROJECTS%) do (
    if exist "%%p\" (
        echo Building %%p...
        cd "%%p" || (
            echo Failed to change directory to %%p
            pause
            exit /b 1
        )
        call mvnd clean package -DskipTests
        if !ERRORLEVEL! neq 0 (
            echo Failed to build %%p
            pause
            cd ..
            exit /b 1
        )
        cd ..
    ) else (
        echo Directory %%p not found
        pause
        exit /b 1
    )
)
echo All projects built successfully.
exit /b 0

:: Function to run all services in Docker
:run_docker
echo Starting all services in Docker with 'docker' profile...
if exist "docker-compose.yml" (
    docker-compose up --build
    if !ERRORLEVEL! neq 0 (
        echo Failed to start Docker services
        pause
        exit /b 1
    )
) else (
    echo docker-compose.yml not found
    pause
    exit /b 1
)
exit /b 0

:: Function to stop Docker services
:stop_docker
echo Stopping Docker services...
if exist "docker-compose.yml" (
    docker-compose down
    if !ERRORLEVEL! neq 0 (
        echo Failed to stop Docker services
        pause
        exit /b 1
    )
    echo Docker services stopped.
) else (
    echo docker-compose.yml not found
    pause
    exit /b 1
)
exit /b 0

:: Main script
if "%1"=="" goto usage
if "%1"=="build" (
    call :build_projects
    if !ERRORLEVEL! neq 0 exit /b !ERRORLEVEL!
)
if "%1"=="docker" (
    call :build_projects
    if !ERRORLEVEL! neq 0 exit /b !ERRORLEVEL!
    call :run_docker
    if !ERRORLEVEL! neq 0 exit /b !ERRORLEVEL!
)
if "%1"=="stop-docker" (
    call :stop_docker
    if !ERRORLEVEL! neq 0 exit /b !ERRORLEVEL!
) else (
    goto usage
)
exit /b 0

:usage
echo Usage: %0 {build^|docker^|stop-docker}
echo   build: Build all projects using mvnd
echo   docker: Run all services in Docker with 'docker' profile
echo   stop-docker: Stop Docker services
exit /b 1