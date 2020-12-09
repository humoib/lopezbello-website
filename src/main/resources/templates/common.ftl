<#macro page title subtitle=""> <#setting locale="es_ES">

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

<title>${title?html}</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/navbar-fixed/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">    
    
<!-- Favicons -->
<link rel="apple-touch-icon"
	href="https://getbootstrap.com/docs/4.5/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest"
	href="https://getbootstrap.com/docs/4.5/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="https://getbootstrap.com/docs/4.5/assets/img/favicons/safari-pinned-tab.svg"
	color="#563d7c">
<link rel="icon"
	href="https://getbootstrap.com/docs/4.5/assets/img/favicons/favicon.ico">
<meta name="msapplication-config"
	content="https://getbootstrap.com/docs/4.5/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<!--link href="navbar-top-fixed.css" rel="stylesheet"-->
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="${context}/">Boxes!</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">

			<ul class="navbar-nav mr-auto">
				<!-- li class="nav-item"><a class="nav-link" href="/">Dashboards</a></li-->
				
				<li class="nav-item ">
					<!-- active --> <a class="nav-link" href="${context}/garage">Garage</a> 
					<!--  <span class="sr-only">(current)</span> -->
				</li>
				<li class="nav-item "><a class="nav-link" href="${context}/things">Things
						</span>
				</a> <span class="sr-only">(current) </li>

				<!--li class="nav-item">
	        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
	      </li-->
				&nbsp; &nbsp;

				<div class="btn-group" role="group"
					aria-label="Default button group">
					<button type="button" class="btn btn-secondary"
						onclick="window.location.href = '${context}/thing/newfirst';">New</button>
				</div>

			</ul>
			
			<form class="form-inline mt-2 mt-md-0" method="POST" action="${context}/search">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search" id="search" name="search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			&nbsp; &nbsp;

			<button type="button" class="btn btn-outline-primary"
				onclick="window.location.href='${context}/admin/';">
				<svg width="1em" height="1em" viewBox="0 0 16 16"
					class="bi bi-gear-fill" fill="currentColor"
					xmlns="http://www.w3.org/2000/svg">
			  <path fill-rule="evenodd"
						d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 0 0-5.86 2.929 2.929 0 0 0 0 5.858z"></path>
			</svg>
			</button>

		</div>
	</nav>

	<div class="container-fluid" style="top:80px;position: absolute;">
	
	<!-- main role="main" class="container"
		style="top:80px;position: absolute;"--> 
		
		<!-- JUMBOTRON --> <!--div class="jumbotron">
	    <h1>Navbar example</h1>
	    <p class="lead">This example is a quick exercise to illustrate how fixed to top navbar works. As you scroll, it will remain fixed to the top of your browser’s viewport.</p>
	    <a class="btn btn-lg btn-primary" href="https://getbootstrap.com/docs/4.5/components/navbar/" role="button">View navbar docs &raquo;</a>
	  </div--> 
	
	  
	<#nested /> 
	
	<!-- /main-->
	</div> 
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="https://getbootstrap.com/docs/4.5/assets/js/vendor/jquery.slim.min.js"><\/script>')
	</script>
	<script
		src="https://getbootstrap.com/docs/4.5/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>

</body>
</html>


</#macro>
