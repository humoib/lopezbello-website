<#import "../common.ftl" as c />

<@c.page title="Thing">    
	
	<style>
	.card-columns {
		  @include media-breakpoint-only(lg) {
    		column-count: 4;
  		  }
  	     @include media-breakpoint-only(xl) {
    	    column-count: 5;
  		  }
  	}
	</style>

	<p>Photo</p>
	
	<button>Add physical folder</button>
		
	<div class="row">
	
	${content}
	
	<#if searchedThings??>
	  	<#list searchedThings as thing >
	
			<div class="card-group">
				<div class="card" >
				  <div class="card-body">
    				<h5 class="card-title"><a href='${context}/thing/${thing.id}'>${thing.summary}</a></h5>
    				<h6 class="card-subtitle mb-2 text-muted">${thing.thingType.name}</h6>
    				<p class="card-text">${thing.created?date}</p>
  		  			<a href="#" class="card-link">Card link</a>
    			  </div>
				</div>
			</div>
		
		</#list>
	</#if>
	
	</div>
	  
</@c.page>
