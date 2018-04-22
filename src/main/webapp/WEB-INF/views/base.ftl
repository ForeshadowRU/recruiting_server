<!DOCTYPE html>
<html lang="en">
<head>
    <#macro page_head>
            <meta charset="UTF-8">
            <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.0/simplex/bootstrap.min.css" rel="stylesheet" integrity="sha384-dGOMD5bzPwVfOGp4zGQiudlmCab9PN0dIsv1r1MCotfVsSXM3m5ZiqEVO56XzCCh" crossorigin="anonymous">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="../resources/ccs/style.css">
    </#macro>
    <title>Title</title>
</head>
<body>
<#macro page_navbar>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">RecruitHub</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation" style="">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">

        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/users">Recruits</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/companies">Companies</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Vacancies</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
           <a href="/auth"> <button type="button" class="btn btn-info">Log In / Sing In</button></a>
        </form>
    </div>
</nav>
</#macro>
</body>
</html>