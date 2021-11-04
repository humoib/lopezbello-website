<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author"
		content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Jekyll v4.1.1">
	
	<title>th1ngs - Home page</title>
	
	<!-- Bootstrap core CSS -->
	<link
		href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css"
		rel="stylesheet">
	
</head>

<body>
	<main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
        	<div class="d-flex flex-row-reverse">
        		<#if Session.SPRING_SECURITY_CONTEXT?? >
				<a href="${context!""}/main" class="btn btn-primary">Logged in as ${Session.SPRING_SECURITY_CONTEXT.authentication.name} - Go to th1ngs!</a>&nbsp;&nbsp;
				<#else>        		
				<a href="${context!""}/login" class="btn btn-primary">Login</a>&nbsp;&nbsp;&nbsp;
				</#if>
				<a href="${context!""}/signup" class="btn btn-success">Sign up here!</a>
			</div>		
        	
          	<h1 class="display-3"><@spring.message code="home.welcome"/> th1ngs!</h1>
          	<p>Manage everyThing with all the flexibility</p>
          	<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more »</a></p>
          	
        </div>
      </div>

      <div class="container">
      
        <div class="row">
          <div class="col-md-4">
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor 
            mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna 
            mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>
          </div>
          <div class="col-md-4">
            <h2>Heading</h2>
            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
             mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
              mollis euismod. Donec sed odio dui. </p>
            <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>
          </div>
          <div class="col-md-4">
            <h2>Heading</h2>
            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id 
            ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris 
            condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <p><a class="btn btn-secondary" href="#" role="button">View details »</a></p>
          </div>
        </div>

        <hr>

      </div> <!-- /container -->

    </main>

</body>

