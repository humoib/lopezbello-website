<#import "common.ftl" as c />

<@c.page title="">


	<script>
	
	function relates(){
		$.ajax({
   			type: "PUT",
		    contentType: "application/json; charset=utf-8",
    		url: "${context}/rest/api/1/thing/relate",
    		data: '{"source": "'+$("#thingId").val()+'", "target":"'+$("#relate option:selected").val()+'"}',
    		dataType: "json",
    		success: function (msg) {
        		console.log('Success');
    		},
   			error: function (err){
        		console.log('Error');
    		}
		});
	}
	
	</script>
	
	
 	<div class="row">
 	
		<div class="col-2">
		
			<#if !operation??>
			
				<div class="list-group">
  				<a href="#" class="list-group-item list-group-item-action active">
    				Relations
    				
    				<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#relations-modal">
  						Add
					</button>
    				
  				</a>
  				
  				<#if thingsRelated??>
			  		<#list thingsRelated as thingRelated >
						<a href="${context}/thing/${thingRelated.id}" class="list-group-item list-group-item-action">${thingRelated.humanKey} ${thingRelated.summary}</a>
			  		</#list>	
			  	</#if>
			  		
			</div>
			</#if>	
		</div>
		
		<!-- CENTRAL -->
		<div class="col-8">

			<!-- VIEW -->
			<#if !operation??>
			
				<input type="hidden" id="thingId" name="thingId" value="${thing.id}">
			
				<!-- Action Bar--> 
				<div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
				    <button type="button" class="btn btn-secondary"
				    	onclick="window.location.href = '${context}/thing/edit/${thing.id}';">Edit</button>
				    <button type="button" class="btn btn-secondary">Assign</button>
				    <button type="button" class="btn btn-secondary">Attach</button>
				    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#relations-modal">Relate</button>
				    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				      More
				    </button>
				    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
				      <a class="dropdown-item" href="#">Delete</a>
				      <a class="dropdown-item" href="#">Dropdown link</a>
				    </div>
				</div>
				
				<div class="btn-group btn-group-sm" role="group">
				    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				      Transit
				    </button>
				    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
				      <a class="dropdown-item" href="#">Dropdown link</a>
				      <a class="dropdown-item" href="#">Dropdown link</a>
				    </div>
	            </div>
				
				<br/><br/>
				
				<#if thing.thingTypeId??>
					<p><b>Type:</b> ${thing.thingTypeId}</p>
			  	</#if>
				
				<p><b>Summary:</b> ${thing.summary}</p>
											
				<#if fields??>
			  		<#list fields as field >
			  			<#if field.value?? >
							<p><b>${field.name}</b>: ${field.value}</p>
						</#if>
			  		</#list>	
			  	</#if>
			  		
			
			<#elseif (operation=="new"||operation=="edit")>
			
				<!-- EDIT -->
				<#if operation == 'new' >
			      	<form action="${context}/thing/new" method="POST">
	        	<#elseif operation == 'edit' >	  
					<form action="${context}/thing/edit/${thing.id}" method="POST">
				</#if>	
		 		
		 			<input type='hidden' name='boxId' value='${boxId}'>		 			
		 			<input type='hidden' name='thingTypeId' value='${thingTypeId}'>
		 			
 					<div class="form-group row">
				    	<label for="summary" class="col-sm-2 col-form-label">Summary</label>
				    	<div class="col-sm-10">
				      		<input type="text" class="form-control form-control-sm" 
				      			id="summary" name="summary" placeholder="text" 
				      			<#if thing??>
				      				value="${thing.summary}"
				      			</#if>
				      			>
				    	</div>
					</div>
					 			
		 			<#if fields??>
			 			<#list fields as field >
							<!-- <p><b>field.name:</b> value</p> -->
							
							<#switch field.type>
							 <#case "text">
    							<div class="form-group row">
							    	<label for="cf_${field.id}" class="col-sm-2 col-form-label">${field.name}</label>
							    	<div class="col-sm-10">
							      		<input type="text" class="form-control form-control-sm" id="${field.id}" 
							      			name="cf_${field.id}" placeholder="text" 
							      			<#if field.value?? >
							      			value="${field.value}"
						    	  			</#if>
						      				>
						    		</div>
								</div>
							<#break>

							 <#case "text-large">
    							<div class="form-group row">
    								<label for="cf_${field.id}" class="col-sm-2 col-form-label">${field.name}</label>
    								<div class="col-sm-10">
	    									<textarea class="form-control form-control-sm" 
	    										id="${field.id}" name="cf_${field.id}" 
	    										rows="3"><#if field.value?? >${field.value}</#if></textarea>
         				    		</div>
									
								</div>
							<#break>

							
							</#switch>
					  	
					  	</#list>
					</#if>
							
							
							
							
							
							
		 			<!--div class="form-group row">
					    <label for="cf_1000" class="col-sm-2 col-form-label">text</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control form-control-sm" id="cf_1000" placeholder="text">
					    </div>
					</div>
					  
					<div class="form-group row">
					    <label for="cf_1001" class="col-sm-2 col-form-label">select</label>
					    <div class="col-sm-10">
					    
					    	<div class="input-group mb-3">
							  <div class="input-group-prepend">
							    <label class="input-group-text" for="inputGroupSelect01">Options</label>
							  </div>
							  <select class="custom-select" id="cf_1001">
							    <option selected>Choose...</option>
							    <option value="1">One</option>
							    <option value="2">Two</option>
							    <option value="3">Three</option>
							  </select>
							</div>
							
					    </div>
					</div-->
					
					  
				  <!--div class="form-group row">
				    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
				    <div class="col-sm-10">
				      <input type="email" class="form-control form-control-sm" id="inputEmail3" placeholder="Email">
				    </div>
				  </div-->
				  
				  <!--div class="form-group row">
				    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control form-control-sm" id="inputPassword3" placeholder="Password">
				    </div>
				  </div-->
				  
				  <!--fieldset class="form-group">
				    <div class="row">
				      <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
				      <div class="col-sm-10">
				        <div class="form-check">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
				          <label class="form-check-label" for="gridRadios1">
				            First radio
				          </label>
				        </div>
				        <div class="form-check">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
				          <label class="form-check-label" for="gridRadios2">
				            Second radio
				          </label>
				        </div>
				        <div class="form-check disabled">
				          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
				          <label class="form-check-label" for="gridRadios3">
				            Third disabled radio
				          </label>
				        </div>
				      </div>
				    </div>
				  </fieldset-->
				  
				  <!--div class="form-group row">
				    <div class="col-sm-2">Checkbox</div>
				    <div class="col-sm-10">
				      <div class="form-check">
				        <input class="form-check-input" type="checkbox" id="gridCheck1">
				        <label class="form-check-label" for="gridCheck1">
				          Example checkbox
				        </label>
				      </div>
				    </div>
				  </div-->
				  
				  <!-- SUBMIT -->
				  <div class="form-group row">
				    <div class="col-sm-10">
				      <button type="submit" class="btn btn-primary">Submit</button>
				      <button type="cancel" class="btn btn-secondary">Cancel</button>
				    </div>
				  </div>
				  
				</form>
		
			</#if>
			
        </div>
        
        
		<!-- CENTRAL -->
		<div class="col-2">
			<div class="container">
			
			<#if thing?? >
				<h5>People</h5>
					<ul>
						<li><b>Creator:</b> user
						<li><b>Assignee:</b> user
						<li><b>Watchers:</b> users
					</ul>
				
				<h5>Dates</h5>
			
					<ul>
						<#if thing.created??>
							<li><b>Created:</b> ${thing.created}
						</#if>
						<#if thing.updated??>
							<li><b>Updated:</b> ${thing.updated}
						</#if>
					</ul>
			</#if>
			
			</div>
		</div>
        
	</div> <!-- FIN primera fila -->
	  
	<div class="row">
		<div class="col-12">
	
			<#if thing?? >
			
			<ul class="nav nav-tabs">
			  <li class="nav-item">
   				 <a class="nav-link active" href="#">Active</a>
  				</li>
  			<li class="nav-item dropdown">
    			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
   			 <div class="dropdown-menu">
 			     <a class="dropdown-item" href="#">Action</a>
 			     <a class="dropdown-item" href="#">Another action</a>
			      <a class="dropdown-item" href="#">Something else here</a>
 			     <div class="dropdown-divider"></div>
 			     <a class="dropdown-item" href="#">Separated link</a>
  			  </div>
 			 </li>
 			 <li class="nav-item">
  		  <a class="nav-link" href="#">Link</a>
  			</li>
 			 <li class="nav-item">
 			   <a class="nav-link disabled" href="#">Disabled</a>
 			 </li>
			</ul>
			
			</#if>
	
		</div>
	</div>
	
	
	<!-- Modal for relations -->
	<#if thing?? >
		<div class="modal fade" id="relations-modal" tabindex="-1" role="dialog" 
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  			<div class="modal-dialog modal-dialog-centered" role="document">
  			  <div class="modal-content">
 			     <div class="modal-header">
 			       <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
   				     	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
     				     	<span aria-hidden="true">&times;</span>
      			 		 </button>
      			</div>
      			<div class="modal-body">
      				<select class="form-control form-control-sm" id="relate">
      					<#if thingsToRelate??>
      						<#list thingsToRelate as thing >
      							<option value="${thing.id}">${thing.key} - ${thing.summary}</option>
      						</#list>
      					</#if>
					</select>
     	 		</div>
     	 		<div class="modal-footer">
    	    		<button type="button" class="btn btn-secondary" data-dismiss="modal"
    	    			onclick="$('#relations-modal').modal('hide');">Close</button>
	       			<button type="button" class="btn btn-primary" 
	       				onclick="console.log('relate');relates();$('#relations-modal').modal('hide');location.reload();">Relate</button>
      			</div>
    			</div>
  			</div>
		</div>
	
	</#if>

</@c.page>
