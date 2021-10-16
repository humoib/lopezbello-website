<#import "common.ftl" as c />

<@c.page title="">

	<div class="row">
 	
		<div class="col-2" id="relations">
			<h3><a href="${context}/box/box.id">box.name</a></h3>
		</div>
		
		<!-- CENTRAL -->
		<div class="col-8">

			<!-- VIEW -->
			<#if !operation??>
				
				<#if thing??>
					<input type="hidden" id="thingId" name="thingId" value="${thing.id}">
					
					<h5><a href='${context}/thing/${thing.thingKey}'>${thing.thingKey}</a> : ${thing.summary}</h5>
					
				</#if>
							
				<!-- Action Bar--> 
				<div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
				    <button type="button" class="btn btn-primary"
				    	onclick="window.location.href = '${context}/thing/edit/${thing.id}';">Edit</button>
				    
				    <button type="button" class="btn btn-primary">Assign</button>
				    
				    <button type="button" class="btn btn-secondary"
				    	onclick="window.location.href = '${context}/thing/attach/${thing.id}';">Attach</button>
				    
				    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#relations-modal">Relate</button>
				    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				      More
				    </button>
				    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
				    	<a class="dropdown-item" href="${context}/thing/delete/${thing.id}">Delete</a>
				    	<!--a class="dropdown-item" href="#">Dropdown link</a-->
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
				
				<br/>
									
				<#if thing.analysis??>
					<p><b>Analysis:</b></p>
					<p>${thing.analysis!""}</p>
				
					<hr/>
				</#if>
						
				<#if fields??>
			  		<#list fields as field >
			  			<#if field.value?? >
							<p><b>${field.name}</b>: ${field.value}</p>
						</#if>
			  		</#list>	
			  	</#if>
			  	
			  	<hr/>
			  	
			  		
			<#elseif (operation=="new"||operation=="edit")>
			
				<!-- EDIT -->
				<#if operation == 'new' >
			      	<form action="${context}/box/new" method="POST">
	        	<#elseif operation == 'edit' >	  
					<form action="${context}/box/edit/${box.id}" method="POST">
				</#if>	
		 			
		 			<input type='hidden' name='boxTypeId' value='${boxTypeId!""}'>
		 					 		
		 			<div class="form-group">
					    <label for="boxName">Box Name</label>
					    <input type="text" class="form-control" id="boxName" aria-describedby="Name your box on a side" placeholder="">
					    <small id="emailHelp" class="form-text text-muted">This name is editable</small>
					</div>
					
					<div class="form-group">
					    <label for="exampleInputPassword1">Box Key</label>
					    <input type="text" class="form-control wd-25" id="boxKey" placeholder="">
					</div>
					
					<div class="form-group">
					    <label for="exampleFormControlSelect1">Example select</label>
					    <select class="form-control" id="exampleFormControlSelect1">
					      <option>1</option>
					      <option>2</option>
					      <option>3</option>
					      <option>4</option>
					      <option>5</option>
					    </select>
					</div>
					
					<div class="form-group">
						<label for="">Select View modes for your box</label>
					    <div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
						  <label class="form-check-label" for="defaultCheck1">
						    Kanban
						  </label>
						</div>
						<div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2">
						  <label class="form-check-label" for="defaultCheck2">
						    List
						  </label>
						</div>
						<div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2">
						  <label class="form-check-label" for="defaultCheck2">
						    Calendar
						  </label>
						</div>
					</div<
					
					<!-- -->
	
					<!-- SUBMIT -->
					<div class="form-group row">
					    <div class="col-sm-10">
					      <button type="submit" class="btn btn-primary">Submit</button>
					      <a href="#" onclick="window.history.back();" class="btn btn-secondary">Cancel</a>
					    </div>
					</div>
				  
				</form>
		
			</#if>
			
        </div>
        
        
		<!-- CENTRAL -->
		<div class="col-2">
			<div class="container">
			
			<#if thing?? >
			
				<h5>Info</h5>
					<ul>
						<li><b>Type:</b> ${thing.thingTypeName}
					</ul>
			
				<h5>People</h5>
					<ul>
						<li><b>Creator:</b> ${thing.creator.username!"unknown"}
						<li><b>Assignee:</b> user
						<li><b>Watchers:</b> users
					</ul>
				
				<h5>Dates</h5>
					<ul>
						<#if thing.created??>
							<li><b>Created:</b> ${thing.created?date}
						</#if>
						<#if thing.updated??>
							<li><b>Updated:</b> ${thing.updated?date}
						</#if>
					</ul>
			</#if>
			
			</div>
		</div>
        
	</div> <!-- FIN primera fila -->
	
	<hr/>
	
	<#if !operation?? || (operation?? && (operation!="new" && operation!="edit")) >
	
		<div class="row">
			<div class="col-12">
		
				<#if thing?? >
					
				<ul class="nav nav-tabs">
	 				<li class="nav-item">
	 					<a class="nav-link active" aria-current="page" href="#comments" data-toggle="tab">Comments</a>
	 				</li>
	 				
					<li class="nav-item">
						<a class="nav-link" href="#changes" data-toggle="tab">Changes</a>
					</li>
				</ul>
	
				<div class="tab-content">
	        		<div class="tab-pane active" id="comments">
	        
	       		 	<form action="${context}/thing/newComment" method="POST">
	        			<input type="hidden" name="thingId" value="${thingId}">
			 			
		        		<div class="form-group">
	    					<textarea class="form-control" id="comment" name="comment" rows="3"></textarea>
	    					<button type="submit" class="btn-small btn-primary">Add comment</button>
	  					</div>
		        	
	  				</form>
			
					<#if thingComments?? >
						<#list thingComments as thingComment >
						  	<p>On <b>${thingComment.created?datetime}</b>, <b>${thingComment.actor.username}</b> comment: <b>${thingComment.comment}</b></p>
						</#list>
					</#if>
					
		        </div>
		        <div class="tab-pane" id="changes">changes</div>
		    </div>
	    
	    

			</#if>
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
      							<option value="${thing.id}">${thing.thingKey} - ${thing.summary}</option>
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
	<!-- fin de MODAL for relations -->

</@c.page>
