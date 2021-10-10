<#import "template.ftl" as admin />

<@admin.page title="Users">

	<!-- Main content -->
    <section class="content">

		
		  <#if user??>
			<form method="POST" action="${context}/admin/user/edit">
				<input type="hidden" id="userId" name="userId" value="${user.id}">
		  <#else>
			<form method="POST" action="${context}/admin/user/add">
		  </#if>
		  
				
		  <div class="form-group">
		    <label for="username">Username</label>
		    
		    <#if user??>
			    <input type="text" readonly name="username" class="form-control" id="username" placeholder="" value="${user.username!""}">
            <#else>
                <input type="text" name="username" class="form-control" id="username" placeholder="">
            </#if>
		  
		    <label for="fullname">Full Name</label>
		    <input type="text" name="fullname" class="form-control" id="fullname" placeholder=""
		    <#if user??>
				value="${user.fullname!""}"
            </#if>
		    >
		  
		    <label for="email">Email address</label>
		    <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com"
		    <#if user??>
				value="${user.email!""}"
            </#if>
		    >
		  
		    <label for="password">Password</label>
		    <input type="password" name="password" class="form-control" id="password" placeholder="">
		  
		  </div>
		  
		  <!--div class="form-group">
		    <label for="exampleFormControlTextarea1">Example textarea</label>
		    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		  </div-->
		
		  <button type="submit" class="btn btn-primary">Send</button>
			
		</form>
		
    </section>
    <!-- /.content -->
    
    
    
</@admin.page>

