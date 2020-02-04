
<%@ taglib prefix="s" uri="/struts-tags"%>
<aside class="left-side sidebar-offcanvas">
	<section class="sidebar">
		<ul class="sidebar-menu">
		<!--  <img src="img/ic_launcher.jpg" style="width:220px;height:50px" style="PADDING-LEFT: 5px">-->
			<li class="active">
			<s:if test="%{#session['loggedinuser'].role=='ADMIN'}">
			<s:a action="dashboard">
					<i class="fa fa-dashboard"></i>
					<span>Dashboard</span>
				</s:a>
				</s:if>
				<s:elseif test="%{#session['loggedinuser'].role=='DONOR'}">
				<s:a action="donorDashboard">
					<i class="fa fa-dashboard"></i>
					<span>Dashboard</span>
				</s:a>
				
				</s:elseif>
				
				</li>
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-laptop"></i>
					<span>Donors </span> 
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					
					<s:if test="%{#session['loggedinuser'].role=='ADMIN'}">
							<li><a href="listDonors"><i
								class="fa fa-angle-double-right"></i> List-Donors </a></li>
					<li><a href="prepareAddDonor"><i
							class="fa fa-angle-double-right"></i> Add New Donor</a></li>
					<li><a href="prepareSearch"><i
							class="fa fa-angle-double-right"></i> Search Donor</a></li>
					</s:if>
					<s:elseif test="%{#session['loggedinuser'].role=='DONOR'}">
    				     <li><s:a href="prepareEditDonor?donorId=%{#session['loggedinuser'].donorId}"><i
								class="fa fa-angle-double-right"></i> Edit My Profile </s:a></li>
						 <li><s:a href="listDonations?donorId=%{#session['loggedinuser'].donorId}"><i
								class="fa fa-angle-double-right"></i> View Donation History  </s:a></li>		
					</s:elseif>
						
				</ul>
			</li>
			 <s:if test="%{#session['loggedinuser'].role=='ADMIN'}">
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-laptop"></i>
					<span>Donations</span> 
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li><a href="listDonations"><i
							class="fa fa-angle-double-right"></i> List Donations</a></li>
					<li><a href="prepareAddEditDonation"><i
							class="fa fa-angle-double-right"></i> Add Donation Entry</a></li>
					
				</ul>
			</li>
			</s:if>
			<%--
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-laptop"></i>
					<span>Issue Book</span> 
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li><a href="prepareIssue"><i
							class="fa fa-angle-double-right"></i>Issue Book to Student</a></li>
					<li><a href="issedBooks"><i
							class="fa fa-angle-double-right"></i>Issued Books</a></li>
				</ul>
			</li>
			--%>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
