    	
    	<p>HELO</p>
	    
	    <ul>
	    	<li>baseUrl: ${baseUrl!""}
	    	<li>valor: ${valor!""}
	    	
	    	<li>username: ${username!""}
	    
	    	<li>demo.greet: <@spring.message code="demo.greet" />	
	    </ul>
	    
	    
	    <style>
	    html, body {
		  background: #e9ecef;
		}
		
		.cursor-grab {
		  cursor: -webkit-grab;
		  cursor: grab;
		}
		
		.tasks {
		  min-height: 450px;
		}
	    </style>
	    
	    <!-- Bootstrap core CSS -->
		<link
			href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css"
			rel="stylesheet">
			    
			    
	    <script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
	    
	    <script src='https://cdnjs.cloudflare.com/ajax/libs/dragula/3.7.2/dragula.min.js'></script>
	    
	    <div class="container py-5">
		  <div class="row">
		
		    <!-- Start lane -->
		    <div class="col-12 col-lg-4">
		      <div class="card mb-3">
		        <div class="card-header bg-light">
		          <h3 class="card-title h5 mb-1">
		            Backlog
		          </h3>
		          <small class="mb-0 text-muted">
		            Nam pretium turpis et arcu. Duis arcu.
		          </small>
		        </div>
		        <div class="card-body">
		          <div class="tasks" id="backlog">
		            <!-- Start task -->
		            <div class="card mb-3 cursor-grab">
		              <div class="card-body">
		                <p class="mb-0">You can move these elements between the containers</p>
		                <div class="text-right">
		                  <small class="text-muted mb-1 d-inline-block">25%</small>
		                </div>
		                <div class="progress" style="height: 5px;">
		                  <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		                </div>
		              </div>
		            </div>
		            <!-- End task -->
		            <!-- Start task -->
		            <div class="card mb-3 cursor-grab">
		              <img class="card-img-top" src="https://source.unsplash.com/sECcwm6BN8w/400x200" alt="Bootstrap Kanban Board" />
		              <div class="card-body">
		                <span class="badge bg-primary text-white mb-2">On hold</span>
		                <p class="mb-0">Moving them anywhere else isn't quite possible</p>
		                <div class="text-right">
		                  <small class="text-muted mb-1 d-inline-block">33%</small>
		                </div>
		                <div class="progress" style="height: 5px;">
		                  <div class="progress-bar" role="progressbar" style="width: 33%;" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100"></div>
		                </div>
		              </div>
		            </div>
		            <!-- End task -->
		          </div>
		          <div class="btn btn-primary btn-block">Add task</div>
		        </div>
		      </div>
		    </div>
		    <!-- End lane -->
		
		    <!-- Start lane -->
		    <div class="col-12 col-lg-4">
		      <div class="card mb-3">
		        <div class="card-header bg-light">
		          <h3 class="card-title h5 mb-1">
		            In Progress
		          </h3>
		          <small class="mb-0 text-muted">
		            Aenean posuere, tortor sed cursus feugiat.
		          </small>
		        </div>
		        <div class="card-body">
		          <div class="tasks" id="progress">
		            <!-- Start task -->
		            <div class="card mb-3 cursor-grab">
		              <div class="card-body">
		                <span class="badge bg-danger text-white mb-2">Bug</span>
		                <p class="mb-0">Moving them anywhere else isn't quite possible</p>
		                <div class="text-right">
		                  <small class="text-muted mb-1 d-inline-block">45%</small>
		                </div>
		                <div class="progress" style="height: 5px;">
		                  <div class="progress-bar" role="progressbar" style="width: 45%;" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"></div>
		                </div>
		              </div>
		            </div>
		            <!-- End task -->
		            <!-- Start task -->
		            <div class="card mb-3 cursor-grab">
		              <div class="card-body">
		                <p class="mb-0">Anything can be moved around. That includes images, links or any other nested elements.</p>
		                <div class="text-right">
		                  <small class="text-muted mb-1 d-inline-block">75%</small>
		                </div>
		                <div class="progress" style="height: 5px;">
		                  <div class="progress-bar" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
		                </div>
		              </div>
		            </div>
		            <!-- End task -->
		          </div>
		          <div class="btn btn-primary btn-block">Add task</div>
		        </div>
		      </div>
		    </div>
		    <!-- End lane -->
		
		    <!-- Start lane -->
		    <div class="col-12 col-lg-4">
		      <div class="card mb-3">
		        <div class="card-header bg-light">
		          <h3 class="card-title h5 mb-1">
		            Completed
		          </h3>
		          <small class="mb-0 text-muted">
		            Curabitur ligula sapien, tincidunt non.
		          </small>
		        </div>
		        <div class="card-body">
		          <div class="tasks" id="completed">
		            <!-- Start task -->
		            <div class="card mb-3 cursor-grab">
		              <img class="card-img-top" src="https://source.unsplash.com/zNRITe8NPqY/400x200" alt="Bootstrap Kanban Board" />
		              <div class="card-body">
		                <span class="badge bg-warning text-white mb-2">Enhancement</span>
		                <p class="mb-0">Moving them anywhere else isn't quite possible</p>
		                <div class="text-right">
		                  <small class="text-muted mb-1 d-inline-block">95%</small>
		                </div>
		                <div class="progress" style="height: 5px;">
		                  <div class="progress-bar" role="progressbar" style="width: 95%;" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"></div>
		                </div>
		              </div>
		            </div>
		            <!-- End task -->
		            <!-- Start task -->
		            <div class="card mb-3 cursor-grab">
		              <div class="card-body">
		                <p class="mb-0">You can move these elements between the containers</p>
		                <div class="text-right">
		                  <small class="text-muted mb-1 d-inline-block">80%</small>
		                </div>
		                <div class="progress" style="height: 5px;">
		                  <div class="progress-bar" role="progressbar" style="width: 80%;" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
		                </div>
		              </div>
		            </div>
		            <!-- End task -->
		          </div>
		          <div class="btn btn-primary btn-block">Add task</div>
		        </div>
		      </div>
		    </div>
		    <!-- End lane -->
		
		  </div>
		</div>
		
		
			<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="https://getbootstrap.com/docs/4.5/assets/js/vendor/jquery.slim.min.js"><\/script>')
	</script>
	<script
	src="https://getbootstrap.com/docs/4.5/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
		
		
		
		<script>
		
			$(document).ready(function(){
				dragula([
  					document.querySelector('#backlog'),
			  		document.querySelector('#progress'),
			  		document.querySelector('#completed')
				  ]);
			});
		</script>
		
		
		
		