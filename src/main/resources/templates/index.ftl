<#import "common.ftl" as c/>

<@c.page title="Main page">

	<div class="container-fluid">
	
		<div class="row">
		    <div class="col-sm">
		      	 <h4>Last things viewed</h4>
				  <ul>
				 	<li>aaa
				 	<li>bbb
				 	<li>ccc
				  </ul>
		    </div>

		    <div class="col-sm">
		          <h4>Last boxes opened</h4>
				  <ul>
				 	<li>aaa
				 	<li>bbb
				 	<li>ccc
				  </ul>
		    </div>

		    <div class="col-sm">
				<h4>Last searches</h4>
				  <ul>
				 	<li>aaa
				 	<li>bbb
				 	<li>ccc
				  </ul>
			</div>

		  </div>
		  	  
	</div>

	<style>
		 .boxThing {
		 	border-style: solid;
		 	border-width: 2px;
		 	white-space: nowrap;
		 	display: inline-block;
    		padding: 3px;
    		margin: 3px;
		 }
	</style>

	<div class="d-flex flex-start" style="align-items: flex-start;">

		<#if boxes??>
	 		<#list boxes as box >
	 			<div 
	 				style="background-color: #eee; width: 30%; border-width: 1px; border-style: solid; border-color: red; margin: 2px;
	 				display: block; overflow: auto; min-height: 0;" 
	 				class="container-fluid">
					
					<h5>${box.name!""} ${box.id}</h5>
				  	<#list thingBoxes[box.id?c] as thing >
				  		<span class='boxThing' title="${thing.summary}" 
				  			onclick="window.location.href='${context}/thing/${thing.thingKey}';"><b>${thing.thingKey}</b> :: ${thing.summary[0..*20]}</span>
				  	</#list>
				</div>
	 		
	 		</#list>
	 	</#if>
		
	</div>
			
	<footer>footer</footer>
	
</@c.page>
