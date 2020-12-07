<#import "template.ftl" as admin />

<@admin.page title="Thing Types">

	<!-- Main content -->
    <section class="content">
    
    	<div class="row">
        <div class="col-12">
          
          <div class="card">
              <div class="card-header">
                <!--h3 class="card-title">Responsive Hover Table</h3-->

                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>User</th>
                      <th>Date</th>
                      <th>Status</th>
                      <th>Reason</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                  <#if thingtypes??>
				  	<#list thingtypes as thingtype >
				  	
	                    <tr>
	                      <td>${thingtype.id}</td>
	                      <td>${thingtype.name}</td>
	                      <td><#if thingtype.description??>${thingtype.description}</#if></td>
	                      <td><span class="tag tag-success">Approved</span></td>
	                      <td></td>
	                    </tr>
	                    
	                  </#list>
					</#if>
                
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
          <!-- /.card -->

         
        </div>
        <!-- /.col -->
      </div>
      
      
      
    </section>
    <!-- /.content -->
    
    
    
</@admin.page>

