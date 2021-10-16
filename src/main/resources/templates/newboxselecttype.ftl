<#import "common.ftl" as c />

<@c.page title="">

 	<div class="row">
		<div class="col-2">&nbsp;</div>
		
		<div class="col-10">

			<!-- 1 - Stuff --> 
			<div class="card small" style="margin: 0.5rem 0.25rem;">
		  		<div class="section">
		  			<button type="button" class="btn btn-primary float-lg-right" float="right"
		  				style="margin: 5px"
			 			onclick="window.location.href='${context}/box/new/1';"
			 			>
						Create Box
					</button>
					
					<h3 class="doc">Super Simple Things</h3>
		  			<p>Paragraph</p>
	  				<ul>
	  					<li>Manage: <b>Things</b>
	  					<li>Status: <b>Open & Closed</b>
	  					<li>View: <b>Kanban</b>
	  					<li>Fields: <b>only the needed</b>
	  				</ul>
	  				<small>
						Type: stuff
	  				</small>
	  				
				 </div>
			</div>

			<!-- 2 - Process -->
			<!--div class="card small" style="margin: 0.5rem 0.25rem;">
		  		<div class="section">
		  			<h3 class="doc">Processes</h3>
		  			<p>Business process management (BPM) is the discipline in which people use various methods to discover, 
		  			model, analyze, measure, improve, optimize, and automate business processes.[1][2] Any combination of 
		  			methods used to manage a company's business processes is BPM.[3] Processes can be structured and repeatable 
		  			or unstructured and variable. Though not required, enabling technologies are often used with BPM.</p>
	  				<ul>
	  					<li>Manage: Things
	  					<li>Status: Open & Closed
	  					<li>View: Kanban
	  					<li>Fields: only the necesary
	  				</ul>
	  				<small>
						Type: stuff
	  				</small>
				 </div>
			</div-->
	
			<!-- 3 - Project Management -->
			<div class="card small" style="margin: 0.5rem 0.25rem;">
		  		<div class="section">
		  		
		  			<button type="button" class="btn btn-primary float-lg-right" float="right"
		  				style="margin: 5px"
			 			onclick="window.location.href='${context}/box/new/3';"
			 			>
						Create Box
					</button>
		  			
		  			<h3 class="doc">Project Management</h3>
	  				<p>From simple to complex projects, this template provides a simple way of coordinating multiple deadlines, 
	  				teams and stakeholders involved. Rally all involved parties within a single source of truth and see projects 
	  				from start to execution.</p>
	  				<ul>
	  					<li>Manage: <b>Tasks</b>
	  					<li>Status: <b>Pending, In Progress & Closed</b>
	  					<li>View: <b>Calendar (default), List & Kanban</b>
	  					<li>Fields: <b>only the necesary</b>
	  				</ul>
	  				<small>
						Type: stuff
	  				</small>
				 </div>
			</div>
				
        </div>
        
	</div>
	  
</@c.page>
