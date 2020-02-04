<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
   %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blood Donor Management Dashboard</title>
<s:include value="../include/cssIncludes.jsp"></s:include>
<s:include value="../include/jsIncludes.jsp"></s:include>

</head>
<body class="skin-blue">
	<s:include value="../include/header.jsp"></s:include>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<s:include value="../include/sidebar.jsp"></s:include>
		<aside class="right-side"> <!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>Blood Bank Management Dashboard</h1>
		<section class="content"> <!-- Small boxes (Stat box) -->
		<div class="row">
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-WET_ASPHALT">
					<div class="inner">
						<h3>
							<s:property value="dashboard.totalDonors"/>	
						</h3>
						<p>Donors</p>
					</div>
					<div class="icon">
						<i class="ion ion-calendar"></i>
					</div>
					<s:a href="listDonors" class="small-box-footer"> View Details <i
						class="fa fa-arrow-circle-right"></i>
					</s:a>
				</div>
			</div>
			<!-- ./col -->
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-ASBESTOS">
					<div class="inner">
						<h3>
							<s:property value="dashboard.onegativeDonors"/>
						</h3>
						<p>O- Donors</p>
					</div>
					<div class="icon">
						<i class="ion ion-flag"></i>
					</div>
					<a href="#" class="small-box-footer"> View Details <i
						class="fa fa-arrow-circle-right"></i>
					</a>
				</div>
			</div>
			<!-- ./col -->
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-red">
					<div class="inner">
						<h3>
								<s:property value="dashboard.opositiveDonors"/>
						</h3>
						<p>O+ Donors</p>
					</div>
					<div class="icon">
						<i class="ion ion-person-add"></i>
					</div>
					<a href="#" class="small-box-footer"> View Details <i
						class="fa fa-arrow-circle-right"></i>
					</a>
				</div>
			</div>
		
		</div>
		<div class="row">
		<div class="col-md-4">
		<div id="advisorsFunnel" ></div>
		</div>
		<div class="col-md-4">
		<div id="idWeeklyOfficeVisits" ></div>
		
		</div>
		<div class="col-md-4">
		<div id="advisorByLeads" ></div>
		</div>
		</div>
		<div class="row">
		
		</div>
		</section>
		
	</section>
	</aside>
	</div>	
	<s:include value="../include/footer.jsp"></s:include>
	
	</body>
</html>