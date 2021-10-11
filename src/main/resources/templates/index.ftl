<#import "common.ftl" as c/>

<@c.page title="Main page">


		<style>
			@media (min-width: 576px) {
			    .card-columns {
			        column-count: 2;
			    }
			}
			
			@media (min-width: 768px) {
			    .card-columns {
			        column-count: 3;
			    }
			}
			
			@media (min-width: 992px) {
			    .card-columns {
			        column-count: 4;
			    }
			}
			
			@media (min-width: 1200px) {
			    .card-columns {
			        column-count: 5;
			    }
			}
		</style>

    	<!-- custom page content -->
    	
	  	<div class="container-fluid">
 	
	 		<#if things??>
	 		<div class="card-columns">
			  	<#list things as thing >
					<!-- index: ${thing?index} -->
					<div class="card-group">
						<div class="card w-50">
							<div class="card-body">
					  			<h4 class="doc"><a href="${context}/thing/${thing.id}">${thing.summary}</a></h4>
					  				
					  			<small>
					  				<p>Creator: ${thing.creator!""}</p>
					  				<p>Created: ${thing.created!""?date}</p>
					  				
					  				${thing.descrription!""}
					  			</small>
							</div>
						</div>
					
					</div>
				</#list>
		    </div>
			</#if>
		
		</div>
			
</@c.page>
