<#import "common.ftl" as c/>

<@c.page title="Main page">

	<div class="container-fluid">
	
		<div class="row">
		    <div class="col-sm">
		    
		    	<form action="${context}/thing/attach" enctype="multipart/form-data" method="POST">
		    		<input type='hidden' name='thingId' value='${thingId}'>
		 			
		    		<label class="form-label" for="customFile">Attach a file to this thing</label>
					<input type="file" class="form-control" id="customFile" name="file2attach" />
		    	
					<input class="btn btn-primary" type="submit" value="Submit">
					<input class="btn btn-primary" onclick="window.history.back();" type="reset" value="Reset">
		    	</form>
				
		    </div>

		</div>
		  	  
	</div>
	
</@c.page>
